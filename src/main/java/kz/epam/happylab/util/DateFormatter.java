package kz.epam.happylab.util;

import kz.epam.happylab.action.LoginAction;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormatter {
    private final static Logger logger = Logger.getLogger(LoginAction.class);
    private static final String RU_FORMAT_DATE="dd.MM.yy";
    private static final String EN_FORMAT_DATE="MM/dd/yy";
    private static final String DB_FORMAT_DATE="yyyy-MM-dd";

    public static String formatDate(String date)
    {
        String pattern = RU_FORMAT_DATE;

        if(date.contains("/")){
            pattern = EN_FORMAT_DATE;
        }

        SimpleDateFormat fromUser = new SimpleDateFormat(pattern);
        SimpleDateFormat dbFormat = new SimpleDateFormat(DB_FORMAT_DATE);

        String reformattedStr = new String();
        try {
            reformattedStr = dbFormat.format(fromUser.parse(date));
        } catch (ParseException e) {
           logger.error(e);
        }

        return reformattedStr;
    }

}
