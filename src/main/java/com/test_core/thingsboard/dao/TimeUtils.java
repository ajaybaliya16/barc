package com.test_core.thingsboard.dao;



import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.time.temporal.WeekFields;
import java.util.Date;

public class TimeUtils {

    public static long calculateIntervalEnd(long startTs, IntervalType intervalType, ZoneId tzId) {
        var startTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(startTs), tzId);
        switch (intervalType) {
            case WEEK:
                return startTime.truncatedTo(ChronoUnit.DAYS).with(WeekFields.SUNDAY_START.dayOfWeek(), 1).plusDays(7).toInstant().toEpochMilli();
            case WEEK_ISO:
                return startTime.truncatedTo(ChronoUnit.DAYS).with(WeekFields.ISO.dayOfWeek(), 1).plusDays(7).toInstant().toEpochMilli();
            case MONTH:
                return startTime.truncatedTo(ChronoUnit.DAYS).withDayOfMonth(1).plusMonths(1).toInstant().toEpochMilli();
            case QUARTER:
                return startTime.truncatedTo(ChronoUnit.DAYS).with(IsoFields.DAY_OF_QUARTER, 1).plusMonths(3).toInstant().toEpochMilli();
            default:
                throw new RuntimeException("Not supported!");
        }
    }

    public static Long convertDateToMillis(String dateString, String format) {
        if (dateString == null || format == null) {
            return null;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            Date date = dateFormat.parse(dateString);
            return date.getTime();
        } catch (Exception ex) {
            throw new DataParshingException("Date parsing exception" + dateString);
        }

    }

    public static Long convertDateToMillis(String dateString) {
        return convertDateToMillis(dateString, AppConstant.DATE_FORMAT);
    }

    public static String convertMillisToDate(long milliseconds, String dateFormat) {
        Date date = new Date(milliseconds);
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }

    public static String convertMillisToDate(Long milliseconds) {
        if (milliseconds == null || milliseconds == 0) {
            return "";
        }

        return convertMillisToDate(milliseconds, AppConstant.DATE_FORMAT);
    }

    public static Timestamp convertDateToTimestamp(String dateString) {
        return convertDateToTimestamp(dateString, AppConstant.DATE_FORMAT);
    }

    public static Timestamp convertDateToTimestamp(String dateString, String format) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            Date date = dateFormat.parse(dateString);
            return new Timestamp(date.getTime());
        } catch (Exception ex) {
            throw new IllegalArgumentException("Invalid date or format: " + dateString, ex);
        }
    }

    public static String convertTimestampToDateStr(Timestamp timestamp) {
        return convertTimestampToString(timestamp, AppConstant.DATE_FORMAT);
    }

    public static String convertTimestampToDateAndTimeStr(Timestamp timestamp) {
        return convertTimestampToString(timestamp, AppConstant.DATE_AND_TIME_FORMAT);
    }

    public static String convertTimestampToString(Timestamp timestamp, String format) {
        if (timestamp == null || format == null || format.trim().isEmpty()) {
            throw new IllegalArgumentException("Timestamp or format cannot be null or empty");
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(timestamp);
    }

    public static String getCurrentDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(AppConstant.DATE_FORMAT));
    }

    public static String getProductionAndValidFromDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
