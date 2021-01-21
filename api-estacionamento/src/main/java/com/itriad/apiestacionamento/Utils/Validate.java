package com.itriad.apiestacionamento.Utils;

import java.text.DateFormatSymbols;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public final class Validate {


    public static String weekDay() {
        Calendar c = new GregorianCalendar();
        return new DateFormatSymbols().getWeekdays()[c.get(Calendar.DAY_OF_WEEK)];
    }

    public static boolean validaHoraEntrada(LocalTime localTime) {
        return localTime.getHour() >= 8 && (localTime.getHour() <= 18 || localTime.getMinute() <= 0);
    }

}
