package com.doka.dokareporting.commons;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;

public class DateUtils {
    private DateUtils() {
    }

    public static LocalDateTime convertToLocalDateTime(Date date) {
        return Objects.isNull(date) ? null : date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static LocalDateTime convertToLocalDateTime(long time) {
        return time == 0L ? null : LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());
    }

    public static long convertToTimeMillis(LocalDateTime dateTime) {
        return Objects.isNull(dateTime) ? 0L : dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static int differenceOfSecondsWithNow(LocalDateTime time) {
        return differenceOfSeconds(LocalDateTime.now(), time);
    }

    public static int differenceOfSeconds(LocalDateTime firstTime, LocalDateTime secondTime) {
        long diff = ChronoUnit.SECONDS.between(firstTime, secondTime);
        int positiveDiff = (int)Math.abs(diff);
        return positiveDiff;
    }

    public static LocalDate asDate() {
        return LocalDate.now();
    }

    public static LocalDateTime asLocalDateTime() {
        return LocalDateTime.of(asDate(), asTime());
    }

    public static LocalTime asTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        return LocalTime.parse(LocalTime.now().format(dtf));
    }

    public static Date convertToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate convertToLocalDate(Date dateToConvert) {
        return LocalDate.ofInstant(dateToConvert.toInstant(), ZoneId.systemDefault());
    }

    public static String getDayExplanation(LocalDate localDate, TextStyle textStyle) {
        return Objects.isNull(localDate) ? null : localDate.getDayOfWeek().getDisplayName(textStyle, DokaUtils.getLocaleFromRequest());
    }

    public static boolean isWithInRange(LocalDateTime startDate, LocalDateTime endDate, LocalDateTime dateTime) {
        if (ObjectUtils.isAnyNull(new Object[]{startDate, endDate, dateTime})) {
            return false;
        } else {
            return startDate.isBefore(dateTime) && endDate.isAfter(dateTime);
        }
    }

    public static Date converToStartOfDay(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date converToEndOfDay(LocalDate localDate) {
        return Date.from(localDate.atTime(23, 59, 59, 999).atZone(ZoneId.systemDefault()).toInstant());
    }
}
