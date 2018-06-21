package com.hendisantika.springreactiveblog.utils;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-reactive-blog
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/06/18
 * Time: 18.16
 * To change this template use File | Settings | File Templates.
 */
public abstract class Utils {

    private static Map<Long, String> daysLookup =
            IntStream.rangeClosed(1, 31).boxed().collect(Collectors.toMap(Integer::longValue, Utils::getOrdinal));
    private static DateTimeFormatter englishDateFormatter = new DateTimeFormatterBuilder()
            .appendPattern("MMMM")
            .appendLiteral(" ")
            .appendText(ChronoField.DAY_OF_MONTH, daysLookup)
            .appendLiteral(" ")
            .appendPattern("yyyy")
            .toFormatter(Locale.ENGLISH);

    private Utils() {
        throw new AssertionError();
    }

    public static String formatToEnglish(TemporalAccessor temporal) {
        return englishDateFormatter.format(temporal);
    }

    private static String getOrdinal(int n) {
        if (n >= 11 && n <= 13) {
            return n + "th";
        }
        if (n % 10 == 1) {
            return n + "st";
        }
        if (n % 10 == 2) {
            return n + "nd";
        }
        if (n % 10 == 3) {
            return n + "rd";
        }
        return n + "th";
    }

}