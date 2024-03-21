package atividade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ValidateValues {
    private static final char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final char[] emailChars = {'@', ' '};

    public static boolean isValidAge(int age) {

        return age > 0 && age < 130;
    }

    public static boolean isValidEmail(String email) {
        int count_at = 0;
        int count_spaces = 0;

        char[] emailCharacters = email.toCharArray();
        for (int i = 0; i <= emailCharacters.length - 1; i++) {
            if (emailCharacters[i] == emailChars[0]) {
                count_at++;
            }
            if (emailCharacters[i] == emailChars[1]) {
                count_spaces++;
            }
        }
        return count_at == 1 && count_spaces == 0;
    }

    public static boolean isValidCity(String city) {
        int count = 0;

        char[] cityCharacters = city.toCharArray();

        for (int i = 0; i <= cityCharacters.length - 1; i++) {
            for (int j = 0; j <= numbers.length - 1; j++) {
                if (cityCharacters[i] == numbers[j]) {
                    count++;
                }
            }
        }
        return count == 0;
    }

    public static boolean isValidString(String string) {
        int count = 0;

        char[] cityCharacters = string.toCharArray();

        for (int i = 0; i <= cityCharacters.length - 1; i++) {
            for (int j = 0; j <= numbers.length - 1; j++) {
                if (cityCharacters[i] == numbers[j]) {
                    count++;
                }
            }
        }
        return count == 0 && cityCharacters.length >= 2;
    }

    public static boolean isInvalidString(String string) {
        int count = 0;

        char[] stringCharacters = string.toCharArray();
        for (int i = 0; i <= stringCharacters.length - 1; i++) {
            if (stringCharacters[i] == ' ') {
                count++;
            }
        }
        return count == stringCharacters.length; // && stringCharacters.length <= 5;
    }

    public static boolean isInvalidOption(int option, int maxOption) {

        return option <= 0 || option > maxOption;
    }

    public static boolean validateOption(int option) {
        return option == 1;
    }

    public static boolean isInvalidDate(String date) {

        try {
            LocalDate localDate = LocalDate.parse(date);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean isInvalidTime(String time) {
        try {
            LocalTime localTime = LocalTime.parse(time);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean eventIsHappeningNow(Event event) {
        LocalDateTime finalDateTime = LocalDateTime.of(event.date, event.finalTime);
        LocalDateTime nowDateTime = LocalDateTime.now();
        return event.dateTime.isBefore(nowDateTime) && finalDateTime.isAfter(nowDateTime);
    }
}
