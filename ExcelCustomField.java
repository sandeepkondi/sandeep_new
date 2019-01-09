package com.beyontec.mol.modal;

public class ExcelCustomField {

    private int rowNo;
    private int columnNo;
    private int rowLength;
    private int colLength;
    private boolean canMerge;
    private String label;
    private Object value;

    public ExcelCustomField(int rowNo, int columnNo, String label, Object value) {
        this.rowNo = rowNo;
        this.columnNo = columnNo;
        this.label = label;
        this.value = value;
        this.rowLength = 0;
        this.colLength = 0;
        this.canMerge = false;
    }

    public ExcelCustomField(int rowNo,
                            int columnNo,
                            int rowLength,
                            int colLength,
                            boolean canMerge,
                            String label,
                            Object value) {
        this.rowNo = rowNo;
        this.columnNo = columnNo;
        this.rowLength = rowLength;
        this.colLength = colLength;
        this.canMerge = canMerge;
        this.label = label;
        this.value = value;
    }

    public int getRowNo() {
        return rowNo;
    }

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    public int getColumnNo() {
        return columnNo;
    }

    public void setColumnNo(int columnNo) {
        this.columnNo = columnNo;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public int getRowLength() {
        return rowLength;
    }

    public void setRowLength(int rowLength) {
        this.rowLength = rowLength;
    }

    public int getColLength() {
        return colLength;
    }

    public void setColLength(int colLength) {
        this.colLength = colLength;
    }

    public boolean isCanMerge() {
        return canMerge;
    }

    public void setCanMerge(boolean canMerge) {
        this.canMerge = canMerge;
    }

}
