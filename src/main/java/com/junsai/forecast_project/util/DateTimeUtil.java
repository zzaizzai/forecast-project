package com.junsai.forecast_project.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateTimeUtil {

    public static String formatDateTime(Date date) {
        // Date -> LocalDateTime
        LocalDateTime dateTime = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        // Formatting
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return dateTime.format(outputFormatter);
    }

    public static String formattedDatetimeDiff(Double datetimeForecastDouble, Double datetimeResultDouble)
            throws NullPointerException, DateTimeParseException {

        if (datetimeForecastDouble == null || datetimeForecastDouble == null) {
            throw new NullPointerException("inputs dates cannot be null");
        }

        String dateForecastStr = String.format("%.0f", datetimeForecastDouble);
        String dateTimeForecastStr = String.format("%-12s", dateForecastStr).replace(' ', '0');

        String dateResultStr = String.format("%.0f", datetimeResultDouble);
        String dateTimeResultStr = String.format("%-12s", dateResultStr).replace(' ', '0');

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        LocalDate dateTimeForecast;
        LocalDate dateTimeResult;

        try {
            dateTimeForecast = LocalDate.parse(dateTimeForecastStr, formatter);
            dateTimeResult = LocalDate.parse(dateTimeResultStr, formatter);
        } catch (DateTimeParseException e) {
            throw new DateTimeParseException("Invalid date format. Expected format: yyyyMMddHHmm", dateTimeForecastStr, 0);
        }

        Period period = Period.between(dateTimeForecast, dateTimeResult);
        int days = period.getYears() * 365 + period.getMonths() * 30 + period.getDays();

        return days + "Days";
    }
}