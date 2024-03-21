package atividade;

import java.time.LocalDateTime;

public class Main {

    public static LocalDateTime todayDateTime;

    public static User user;

    public static void main(String[] args) {

        onStartApplication();
    }

    private static void onStartApplication() {

        if (SaveSystem.loadEvents()) {
            displayMenuOptions();
        }
        else {
            Register.getNewUserData();
            displayMenuOptions();
        }
    }

    public static void displayMenuOptions() {
        System.out.println(" ");
        System.out.println("##### " + user.getName().toUpperCase() + ", WELCOME TO YOUR PERSONAL EVENT MANAGEMENT SYSTEM #####");
        System.out.println(" ");
        System.out.println("##### MENU #####");
        System.out.println(" ");
        System.out.println("1: Register new event.");
        System.out.println("2: My Events.");
        System.out.println("3: Close application.");
        System.out.println(" ");

        System.out.println("##### TEST #####");
        System.out.println(" ");
        System.out.println("All test events are created with presence not confirmed.");
        System.out.println(" ");
        System.out.println("4: Add a past event.");
        System.out.println("5: Add a future event.");
        System.out.println("6: Add a 'happening now' event.");
        System.out.println("7: Reset application.");
        System.out.println(" ");
        System.out.println("Choose an option: ");

        TryGetValues.tryGetMenuOption(7);
    }

    public static void dealMenuChoice(int option) {

        switch (option) {
            case 1:
                registerNewEventMenu();
                break;
            case 2:
                enterMyEventsMenu();
                break;
            case 3:
                exitApplication();
                break;
            case 4:
                Test.registerPastEvent();
                break;
            case 5:
                Test.registerFutureEvent();
                break;
            case 6:
                Test.registerHappeningNowEvent();
                break;
            case 7:
                SaveSystem.deleteFile();
                onStartApplication();
                break;
            default:
                System.out.println("invalid option:");
                displayMenuOptions();
                break;
        }
    }

    private static void registerNewEventMenu() {

        Register.getNewEventData();
    }

    private static void enterMyEventsMenu() {

        if (user.getAllEvents().isEmpty()) {
            System.out.println(" ");
            System.out.println("You don't have any registered events.");
            backToMenuOptions();
        } else {

            System.out.println(" ");
            System.out.println("1. All events.");
            System.out.println("2. Next events.");
            System.out.println("3. Past events.");
            System.out.println("4. Events with confirmed participation.");
            System.out.println("5. Events with participation not confirmed.");
            System.out.println("6. Back to menu options.");

            TryGetValues.tryGetOption(6);

            int option = TryGetValues.choice;

            switch (option) {
                case 1:
                    DisplayEvent.displayAllEvents();
                    break;
                case 2:
                    DisplayEvent.displayNextEvents();
                    break;
                case 3:
                    DisplayEvent.displayPastEvents();
                    break;
                case 4:
                    DisplayEvent.displayJoinedEvents();
                    break;
                case 5:
                    DisplayEvent.displayNotJoinedEvents();
                    break;
                case 6:
                    displayMenuOptions();
                    break;
            }

        }
    }

    public static void exitApplication() {
        System.out.println("##### APPLICATION CLOSED #####");
        System.exit(0);
    }

    public static void backToMenuOptions() {
        System.out.println(" ");
        System.out.println("1. Back to menu options.");
        System.out.println("2. Exit application.");

        TryGetValues.tryGetOption(2);

        int finalOption = TryGetValues.choice;

        if (finalOption == 1) {
            displayMenuOptions();
        } else {
            exitApplication();
        }
    }

}

