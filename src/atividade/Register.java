package atividade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Register {

    public static void getNewEventData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("##### PLEASE, REGISTER A NEW EVENT #####");
        System.out.println(" ");
        System.out.println("Name:");

        String newName = scanner.nextLine();

        if (ValidateValues.isInvalidString(newName)) {
            do {
                System.out.println("Please, enter a valid event name:");
                newName = scanner.nextLine();
            } while (ValidateValues.isInvalidString(newName));
        }

        System.out.println("Address:");
        String newAddress = scanner.nextLine();

        if (ValidateValues.isInvalidString(newAddress)) {
            do {
                System.out.println("Please, enter a valid address:");
                newAddress = scanner.nextLine();
            } while (ValidateValues.isInvalidString(newAddress));
        }

        System.out.println("Event Category:");
        System.out.println("1: " + Category.social);
        System.out.println("2: " + Category.business);
        System.out.println("3: " + Category.religious);
        System.out.println("4: " + Category.academics);
        System.out.println("5: " + Category.cultural);
        System.out.println("6: " + Category.entertainment);
        System.out.println("7: " + Category.sports);

        Category newCategory = TryGetValues.tryGetCategoryOption();

        System.out.println("Description:");

        String newDescription = scanner.nextLine();

        if (ValidateValues.isInvalidString(newDescription)) {
            do {
                System.out.println("Please, enter a valid event description:");
                newDescription = scanner.nextLine();
            } while (ValidateValues.isInvalidString(newDescription));
        }

        System.out.println(" ");
        System.out.println("DATE (yyyy-mm-dd)");

        String newDate = scanner.nextLine();
        if (ValidateValues.isInvalidDate(newDate)) {
            do {
                System.out.println("Please, enter a valid event date (yyyy-mm-dd):");
                newDate = scanner.nextLine();
            } while (ValidateValues.isInvalidDate(newDate));
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(newDate, formatter);


        System.out.println("INITIAL TIME: (hh:mm)");

        String newInitialTime = scanner.nextLine();
        if (ValidateValues.isInvalidTime(newInitialTime)) {
            do {
                System.out.println("Please, enter a valid event initial time (hh:mm):");
                newInitialTime = scanner.nextLine();
            } while (ValidateValues.isInvalidTime(newInitialTime));
        }


        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime initialTime = LocalTime.parse(newInitialTime, formatterTime);

        System.out.println("FINAL TIME (hh:mm):");

        String newFinalTime = scanner.nextLine();
        if (ValidateValues.isInvalidTime(newFinalTime)) {
            do {
                System.out.println("Please, enter a valid event final time (hh:mm):");
                newFinalTime = scanner.nextLine();
            } while (ValidateValues.isInvalidTime(newFinalTime));
        }

        LocalTime finalTime = LocalTime.parse(newFinalTime, formatterTime);

        System.out.println("Do you want to mark your participation in this event?");
        System.out.println("1. Yes.");
        System.out.println("2. No.");

        TryGetValues.tryGetOption(2);

        int joinOption = TryGetValues.choice;

        boolean newJoin = ValidateValues.validateOption(joinOption);

        LocalDateTime newDateTime = LocalDateTime.of(date, initialTime);

        Event newEvent = Event.registerNewEvent(newName, newAddress, newCategory, newDescription, date, initialTime, finalTime, newDateTime, newJoin);

        Main.user.getAllEvents().add(newEvent);

        if (newJoin) {
            Main.user.getJoinedEvents().add(newEvent);
        } else {
            Main.user.getNotJoinedEvents().add(newEvent);
        }

        SaveSystem.saveEvents(Main.user);

        System.out.println("Your event has been registered successfully.");

        Main.backToMenuOptions();
    }

    public static void getNewUserData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("##### PLEASE, REGISTER A NEW USER #####");
        System.out.println(" ");
        System.out.println("Name:");

        String newName = scanner.nextLine();

        while (!ValidateValues.isValidString(newName)) {
            System.out.println("Please, enter a valid name:");
            newName = scanner.nextLine();
        }

        System.out.println("Age:");

        int newAge = 0;

        TryGetValues.tryGetAge(newAge);

        System.out.println("E-mail: ");
        String newEmail = scanner.nextLine();

        while (!ValidateValues.isValidEmail(newEmail)) {
            System.out.println("Please, enter a valid e-mail:");
            newEmail = scanner.nextLine();
        }

        System.out.println("City:");
        String newCity = scanner.nextLine();

        while (!ValidateValues.isValidCity(newCity)) {
            System.out.println("Please, enter a valid city:");
            newCity = scanner.nextLine();
        }

        Main.user = User.registerNewUser(newName, newAge, newEmail, newCity);

        SaveSystem.saveEvents(Main.user);
    }

}
