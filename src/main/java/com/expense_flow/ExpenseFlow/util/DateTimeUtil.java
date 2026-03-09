package com.expense_flow.ExpenseFlow.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateTimeUtil {
    public static String DATE_FORMAT = "yyyy-MM-dd";
    public static String DATE_FORMAT_STRICT = "uuuu-MM-dd";
    public static LocalDate getFormattedDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
            return LocalDate.parse(date, formatter);
        } catch (Exception ex) {
            throw new RuntimeException("Invalid date format.");
        }
    }
}
