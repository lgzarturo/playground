package com.utils

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

import java.text.ParseException
import java.text.SimpleDateFormat

class DateUtilities {

    private static List<DateTimeFormatter> dateFormats = new ArrayList<DateTimeFormatter>()
    private static listPatterns = ['dd-MM-yy', 'dd-MM-yyyy', 'yy-MM-dd', 'yyyy-MM-dd', 'MM-dd-yy', 'MM-dd-yyyy']

    private static Date tryToParse(String input, DateTimeFormatter format) {
        DateTime date = null
        try {
            date = format.parseDateTime(input)
        } catch (ParseException e) {
            println("No apply ${input} format: ${format} - ${e}")
        }
        return (date != null) ? date.toDate() : null
    }

    static Date parseFormat(String input, String format) {
        try {
            return new SimpleDateFormat(format).parse(input.toString());
        } catch (ParseException e) {
            // ignore
        }
        return null
    }

    static Date multiParse(String input) {
        Date date = null

        listPatterns.each {
            dateFormats.add(DateTimeFormat.forPattern(it))
        }
        for (DateTimeFormatter format : dateFormats) {
            date = tryToParse(input, format)
            if (date != null) break
        }
        return date
    }

    static DateTime getFirstDayOfYear(int year = 0) {
        DateTime date = getDateByYear(year)
        return date.dayOfYear().withMinimumValue()
    }

    static DateTime getLastDayOfYear(int year = 0) {
        DateTime date = getDateByYear(year)
        return date.dayOfYear().withMaximumValue()
    }

    static DateTime getDateByYear(int year = 0) {
        DateTime date
        if (year == 0) {
            date = new DateTime()
        } else {
            date = new DateTime().withYear(year)
        }
        return date
    }
}
