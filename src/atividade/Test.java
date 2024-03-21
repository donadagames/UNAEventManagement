package atividade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

public class Test {

    public static void registerPastEvent() {
        String newString = "NEW PAST TEST EVENT_"+ getRandomNumber();
        LocalDate newDate = LocalDate.parse("2020-10-10");
        LocalTime newInitialTime = LocalTime.parse("10:00");
        LocalTime newFinalTime = LocalTime.parse("15:00");
        LocalDateTime newDateTime = LocalDateTime.of(newDate, newInitialTime);
        Event newEvent = Event.registerNewEvent(newString, newString, Category.cultural, newString, newDate, newInitialTime, newFinalTime, newDateTime, false);
        saveTestEvents(newEvent);
    }

    public static void registerFutureEvent() {

        String newString = "NEW FUTURE TEST EVENT_" + getRandomNumber();
        LocalDate newDate = LocalDate.parse("2030-10-10");
        LocalTime newInitialTime = LocalTime.parse("10:00");
        LocalTime newFinalTime = LocalTime.parse("15:00");
        LocalDateTime newDateTime = LocalDateTime.of(newDate, newInitialTime);
        Event newEvent = Event.registerNewEvent(newString, newString, Category.cultural, newString, newDate, newInitialTime, newFinalTime, newDateTime, false);
        saveTestEvents(newEvent);
    }

    public static void registerHappeningNowEvent() {

        String newString = "HAPPENING NOW EVENT TEST_" + getRandomNumber();
        LocalDate nowDate = LocalDate.now();
        LocalTime nowInitialTime = LocalTime.now();
        LocalTime nowFinalTime = LocalTime.of(nowInitialTime.getHour() + 4, nowInitialTime.getMinute());
        LocalDateTime nowDateTime = LocalDateTime.of(nowDate, nowInitialTime);

        Event newEvent = Event.registerNewEvent(newString, "UNA", Category.cultural, "HAPPENING NOW TEST EVENT", nowDate, nowInitialTime, nowFinalTime, nowDateTime, false);
        saveTestEvents(newEvent);

    }

    private static void saveTestEvents(Event event) {
        Main.user.getNotJoinedEvents().add(event);
        Main.user.getAllEvents().add(event);
        SaveSystem.saveEvents(Main.user);
        Main.backToMenuOptions();
    }

    private static String getRandomNumber() {
        String allNumbers = "123456789";
        StringBuilder saltNumber = new StringBuilder();
        Random rnd = new Random();
        while (saltNumber.length() < 5) {
            int index = (int) (rnd.nextFloat() * allNumbers.length());
            saltNumber.append(allNumbers.charAt(index));
        }
        return saltNumber.toString();
    }
}
