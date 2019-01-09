package com.beyontec.mol.util;

import java.awt.Color;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.beyontec.mol.modal.ExcelCustomField;
import com.beyontec.mol.service.DMSService;

@Component
public class ReportGeneratorUtil {

    @Autowired private DMSService dmsService;
    @Autowired private TokenGenerator tokenGenerator;

    public byte[] generateExcel(List<ExcelCustomField> customFields,
                                    String sheetName,
                                    byte[] existExcel) throws IOException {

        try (SXSSFWorkbook wb = getExcel(existExcel, sheetName)) {

            SXSSFSheet sheet = wb.getSheetAt(0);

            // create header row style            
             XSSFCellStyle headerStyle = getHeaderStyle(wb.getXSSFWorkbook());

            //create value row style            
            XSSFCellStyle valueStyle = getCellStyle(wb.getXSSFWorkbook());

            int initialRowIndex = (wb.getXSSFWorkbook().getSheetAt(0).getLastRowNum() > 0 ? wb.getXSSFWorkbook().getSheetAt(0).getLastRowNum() + 2 : 0);
            int rowIndex = 0;
            int maxColIndex = 0;
            int endColNo = 0;
            int endRowNo = 0;
            int fieldRowNo = 0;
            if (customFields != null) {

                for (ExcelCustomField customField : customFields) {

                    if (customField.getValue() instanceof MultipartFile) {
                        setImage(customField, wb, sheet);
                    } else {

                        fieldRowNo = initialRowIndex + customField.getRowNo();

                        endRowNo = (customField.isCanMerge() ? (fieldRowNo + customField.getRowLength() - 2)
                                                             : (fieldRowNo - 1));
                        rowIndex = (rowIndex < endRowNo ? endRowNo : rowIndex);

                        endColNo = (customField.isCanMerge() ? (customField.getColumnNo() + customField.getColLength())
                                                             : customField.getColumnNo());
                        maxColIndex = (maxColIndex < endColNo ? endColNo : maxColIndex);

                        SXSSFRow customRow = null;
                        if (sheet.getLastRowNum() < (fieldRowNo - 1)) {
                            customRow = sheet.createRow(fieldRowNo - 1);
                        } else {
                            customRow = sheet.getRow(fieldRowNo - 1);
                        }

                        SXSSFCell customLabelCell = customRow.createCell(customField.getColumnNo() - 1);
                        customLabelCell.setCellStyle(headerStyle);
                        customLabelCell.setCellValue(customField.getLabel());

                        if (customField.isCanMerge()) {

                            SXSSFRow customValueRow = null;
                            for (int i = fieldRowNo
                                         - 1; i <= (fieldRowNo + customField.getRowLength() - 2); i++) {

                                customValueRow = (sheet.getLastRowNum() < i ? sheet.createRow(i) : sheet.getRow(i));
                                for (int j = customField.getColumnNo() - 1; j <= customField.getColLength(); j++) {

                                    SXSSFCell customValueCell = customValueRow.getCell(j,
                                                                                       MissingCellPolicy.CREATE_NULL_AS_BLANK);
                                    customValueCell.setCellStyle(headerStyle);
                                }
                            }

                            sheet.addMergedRegion(new CellRangeAddress(fieldRowNo
                                                                       - 1,
                                                                       fieldRowNo
                                                                            + customField.getRowLength()
                                                                            - 2,
                                                                       customField.getColumnNo() - 1,
                                                                       customField.getColumnNo()
                                                                                                      + customField.getColLength()
                                                                                                      - 2));
                        }

                        SXSSFCell customValueCell = customRow.createCell(customField.getColumnNo());
                        customValueCell.setCellStyle(valueStyle);
                        setCellValue(customValueCell, customField.getValue());
                    }
                }
                rowIndex = rowIndex + 2;
            }

            sheet.trackAllColumnsForAutoSizing();
            for (int i = 0; i < maxColIndex; i++) {
                sheet.autoSizeColumn(i);
            }
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                wb.write(baos);
                return baos.toByteArray();
            }
        }
    }

    public <T> byte[] generateExcel(String[] headers,
                                    String[] fields,
                                    List<T> values,
                                    String sheetName,
                                    byte[] existExcel) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException, IOException {

        try (SXSSFWorkbook wb = getExcel(existExcel, sheetName)) {

            SXSSFSheet sheet = wb.getSheetAt(0);

            // create header row style            
            XSSFCellStyle headerStyle = getHeaderStyle(wb.getXSSFWorkbook());

            // create value row style            
            XSSFCellStyle valueStyle = getCellStyle(wb.getXSSFWorkbook());

            int rowIndex = (wb.getXSSFWorkbook().getSheetAt(0).getLastRowNum() > 0 ? wb.getXSSFWorkbook()
                                                                                       .getSheetAt(0)
                                                                                       .getLastRowNum()
                                                                                     + 2
                                                                                   : 0);
            System.out.println(wb.getXSSFWorkbook().getSheetAt(0).getLastRowNum());
            int maxColIndex = 0;

            if (values != null && !values.isEmpty()) {

                maxColIndex = (maxColIndex < headers.length ? headers.length : maxColIndex);

                // create header row
                SXSSFRow header = sheet.createRow(rowIndex);
                header.setHeight((short) 400);
                for (int i = 0; i < headers.length; i++) {
                    SXSSFCell headerCell = header.createCell(i);
                    headerCell.setCellStyle(headerStyle);
                    headerCell.setCellValue(headers[i]);
                }

                // fill the values
                for (T t : values) {

                    rowIndex++;
                    SXSSFRow row = sheet.createRow(rowIndex);
                    for (int i = 0; i < fields.length; i++) {

                        Object value = new PropertyDescriptor(fields[i], t.getClass()).getReadMethod().invoke(t);
                        SXSSFCell valueCell = row.createCell(i);
                        valueCell.setCellStyle(valueStyle);
                        setCellValue(valueCell, value);
                    }
                }

            }
            sheet.trackAllColumnsForAutoSizing();
            for (int i = 0; i < maxColIndex; i++) {
                sheet.autoSizeColumn(i);
            }
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                wb.write(baos);
                return baos.toByteArray();
            }
        }
    }

    public byte[] generateExcel(String[] headers,
                                List<Object[]> values,
                                String sheetName,
                                byte[] existExcel) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException, IOException {

        try (SXSSFWorkbook wb = getExcel(existExcel, sheetName)) {

            SXSSFSheet sheet = wb.getSheetAt(0);

            // create header row style            
            XSSFCellStyle headerStyle = getHeaderStyle(wb.getXSSFWorkbook());

            // create value row style            
            XSSFCellStyle valueStyle = getCellStyle(wb.getXSSFWorkbook());

            int rowIndex = (wb.getXSSFWorkbook().getSheetAt(0).getLastRowNum() > 0 ? wb.getXSSFWorkbook()
                                                                                       .getSheetAt(0)
                                                                                       .getLastRowNum()
                                                                                     + 2
                                                                                   : 0);
            int maxColIndex = 0;

            if (values != null && !values.isEmpty()) {

                maxColIndex = (maxColIndex < headers.length ? headers.length : maxColIndex);

                // create header row
                SXSSFRow header = sheet.createRow(rowIndex);
                header.setHeight((short) 400);
                for (int i = 0; i < headers.length; i++) {
                    SXSSFCell headerCell = header.createCell(i);
                    headerCell.setCellStyle(headerStyle);
                    headerCell.setCellValue(headers[i]);
                }

                // fill the values
                for (Object[] rowValue : values) {

                    rowIndex++;
                    SXSSFRow row = sheet.createRow(rowIndex);
                    for (int i = 0; i < rowValue.length; i++) {

                        SXSSFCell valueCell = row.createCell(i);
                        valueCell.setCellStyle(valueStyle);
                        setCellValue(valueCell, rowValue[i]);
                    }
                }
            }

            sheet.trackAllColumnsForAutoSizing();
            for (int i = 0; i < maxColIndex; i++) {
                sheet.autoSizeColumn(i);
            }

            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                wb.write(baos);
                return baos.toByteArray();
            }
        }
    }

    private SXSSFWorkbook getExcel(byte[] existExcelFile, String sheetName) throws IOException {

        if (existExcelFile == null) {

            SXSSFWorkbook wb = new SXSSFWorkbook();
            wb.createSheet(StringUtils.isBlank(sheetName) ? "Sheet" : sheetName);
            return wb;
        }

        File excelFile = new File(System.getProperty("java.io.tmpdir") + File.separator + "mol-temp.xlsx");
        FileOutputStream fos = new FileOutputStream(excelFile);
        fos.write(existExcelFile);
        fos.flush();
        fos.close();

        FileInputStream inputStream = new FileInputStream(excelFile);
        return new SXSSFWorkbook(new XSSFWorkbook(inputStream));
    }

    private XSSFCellStyle getHeaderStyle(XSSFWorkbook wb) {

        XSSFCellStyle headerStyle = wb.createCellStyle();
        headerStyle.setFillForegroundColor(new XSSFColor(new Color(155, 194, 230)));
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = wb.createFont();
        font.setBold(true);
        font.setItalic(false);
        headerStyle.setFont(font);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);

        return headerStyle;
    }

    private XSSFCellStyle getCellStyle(XSSFWorkbook wb) {

        XSSFCellStyle valueStyle = wb.createCellStyle();
        valueStyle.setFillForegroundColor(new XSSFColor(new Color(221, 235, 247)));
        valueStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        valueStyle.setBorderTop(BorderStyle.THIN);
        valueStyle.setBorderRight(BorderStyle.THIN);
        valueStyle.setBorderBottom(BorderStyle.THIN);
        valueStyle.setBorderLeft(BorderStyle.THIN);

        return valueStyle;
    }

    private void setCellValue(SXSSFCell cell, Object value) {

        if (value != null) {

            if (value instanceof String) {
                cell.setCellValue((String) value);
            } else if (value instanceof Long) {
                cell.setCellValue((Long) value);
            } else if (value instanceof Integer) {
                cell.setCellValue((Integer) value);
            } else if (value instanceof Double) {
                cell.setCellValue((Double) value);
            } else if (value instanceof BigDecimal) {
                cell.setCellValue(((BigDecimal) value).doubleValue());
            } else if (value instanceof Date) {
                cell.setCellValue(DateUtil.toString((Date) value));
            }
        } else {
            cell.setCellValue("");
        }
    }

    private void setImage(ExcelCustomField customField, SXSSFWorkbook wb, SXSSFSheet sheet) throws IOException {

        Drawing<?> drawingPatriarch = sheet.createDrawingPatriarch();
        ClientAnchor anchor = new XSSFClientAnchor(0,
                                                   0,
                                                   0,
                                                   0,
                                                   (short) customField.getColumnNo(),
                                                   customField.getRowNo(),
                                                   (short) (customField.getColumnNo() + customField.getColLength()),
                                                   (customField.getRowNo() + customField.getRowLength()));
        drawingPatriarch.createPicture(anchor,
                                       wb.addPicture(((MultipartFile) customField.getValue()).getBytes(),
                                                     HSSFWorkbook.PICTURE_TYPE_PNG));
    }

    public Map<String, Object> generatePDF(List<String> label,
                                           List<Object[]> description,
                                           String template) throws Exception {

        Map<String, Object> pdfDetails = new HashMap<>();
        if (!label.isEmpty()) {
            for (int i = 0; i < label.size(); i++) {
                String key = (StringUtils.isNotEmpty(label.get(i))) ? label.get(i) : "";
                String value = (!description.isEmpty()
                                && (null != description.get(0)[i])) ? description.get(0)[i].toString() : "";
                pdfDetails.put(key, value);
            }
        }

        OAuth2AccessToken accessToken = tokenGenerator.getAccessToken();
        String authHeader = accessToken.getTokenType() + " " + accessToken.getValue();
        return dmsService.generateDownloadDocument(pdfDetails, template, authHeader);
    }
}
