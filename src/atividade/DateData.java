package atividade;

import java.time.LocalDateTime;

public class DateData {

    public static String displayDate(LocalDateTime dateData) {

        String month = "";
        String day = "";

        if (dateData.getMonthValue() < 10) {
            month = "0" + dateData.getMonthValue();

        } else {
            month = String.valueOf(dateData.getMonthValue());
        }

        if (dateData.getDayOfMonth() < 10) {
            day = "0" + dateData.getDayOfMonth();

        } else {
            day = String.valueOf(dateData.getDayOfMonth());
        }


        return dateData.getYear() + "/" + month + "/" + day;
    }

    public static String displayTime(LocalDateTime dateData) {

        String hour = "";
        String minute = "";

        if (dateData.getHour() < 10) {
            hour = "0" + dateData.getHour();
            ;
        } else {
            hour = String.valueOf(dateData.getHour());
        }

        if (dateData.getMinute() < 10) {
            minute = "0" + dateData.getMinute();
            ;
        } else {
            minute = String.valueOf(dateData.getMinute());
        }
        return hour + ":" + minute;
    }

    public static void GetCurrentDate() {
        LocalDateTime now = LocalDateTime.now();
    }
}
