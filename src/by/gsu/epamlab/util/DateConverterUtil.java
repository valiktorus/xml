package by.gsu.epamlab.util;

import by.gsu.epamlab.Constants;

import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;

public class DateConverterUtil {

    public static Calendar getCalendarFromXML(String stringDate){
        String[] date = stringDate.split(Constants.DATE_DELIMITER);
        int year = Integer.parseInt(date[Constants.YEAR_INDEX]);
        int month = Integer.parseInt(date[Constants.MONTH_INDEX]);
        int day = Integer.parseInt(date[Constants.DAY_INDEX]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - Constants.MONTH_CORRECTOR, day);
        return calendar;
    }

    public static String getFormattedDate(Calendar date){
        Formatter formatter = new Formatter(Locale.ENGLISH);
        return formatter.format(Constants.DATE_REGEX, date, date, date).toString();
    }
}
