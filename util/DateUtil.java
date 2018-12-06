package com.beyontec.mol.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.DateUtils;

import com.beyontec.mol.config.CommonConfig;

public class DateUtil extends DateUtils {

    public static Date origin() { return CommonConfig.DATE_ORIGIN; }
    public static long getNumberOfDaysBetween(Date fromDate, Date toDate) {
        long diffInMs = toDate.getTime() - fromDate.getTime();
        return TimeUnit.DAYS.convert(diffInMs, TimeUnit.MILLISECONDS);
    }

    public static String toString(Date date) {
        if (date != null) { return CommonConfig.DATE_FORMAT.format(date); }
        return null;
    }
//    public static Date toDate(String date) { return toDate(date, date, null); }
//    public static Date toDate(String dateValue, String dateFieldName, ApplicationException ae) {
//        try {
//            return CommonConfig.DATE_FORMAT.parse(dateValue);
//        } catch (Exception e) {
//            if (ae == null) {
//                throw new ApplicationException(ResponseStatusCode.INVALID_REQUEST,
//                                               ErrorCode.DATE_INVALID,
//                                               dateFieldName,
//                                               CommonConfig.DATE_FORMAT.toPattern());
//            }
//            ae.appendErr(ErrorCode.DATE_INVALID, dateFieldName, CommonConfig.DATE_FORMAT.toPattern());
//            return null;
//        }
//    }

    public static Date now() { return new Date(); }

    public static int getAge(Date dateOfBirth) {
        LocalDate localDateOfBirth = dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(localDateOfBirth, LocalDate.now());
        return period.getYears();
    }

    public static Date extendDate(Date date, int noOfMonthsToExtend, int noOfDaysToExtend) {
        date = addMonths(date, noOfMonthsToExtend);
        date = addDays(date, noOfDaysToExtend);
        return date;
    }

    public static boolean isBetWeen(Date date, Date fromDate, Date toDate) { return isGreaterThan(date, fromDate) && isLessThan(date, toDate); }
    public static boolean isNotBetWeen(Date date, Date fromDate, Date toDate) { return ! isBetWeen(date, fromDate, toDate); }
    public static boolean isLessThan(Date date1, Date date2)    { return (date1.compareTo(date2) < 0); }
    public static boolean isGreaterThan(Date date1, Date date2) { return !isLessThan(date1, date2); }
    public static boolean isNotPast(Date date)                  { return isLessThan(now(), date); }

    public static Date convert(String dateStr) {
        DateTimeFormatter fomatter = CommonConfig.DATE_TIME_FORMATTER;
        try {
            LocalDateTime ldt = LocalDateTime.parse(dateStr, fomatter);
            return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        } catch (DateTimeParseException e) {
            try {
                LocalDate ld = LocalDate.parse(dateStr, fomatter);
                return Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
            } catch (DateTimeParseException exp) {
                try {
                    LocalTime lt = LocalTime.parse(dateStr, fomatter);
                    Calendar calendar = Calendar.getInstance();
                    calendar.clear();
                    calendar.set(0, 0, 0, lt.getHour(), lt.getMinute(), lt.getSecond());
                    return calendar.getTime();
                } catch (DateTimeParseException e2) {
                    return null;
                }
            }
        }
    }
}
