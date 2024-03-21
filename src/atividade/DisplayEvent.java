package atividade;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class DisplayEvent {

    public static void displayAllEvents() {

        if (Main.user.getAllEvents().isEmpty()) {
            System.out.println(" ");
            System.out.println("You don't have any registered events.");
            Main.backToMenuOptions();

        } else {

            sortEventsByClosestDateTime(Main.user.getAllEvents());

            System.out.println(" ");
            System.out.println("ALL EVENTS");
            System.out.println(" ");
            int index = 1;

            for (int i = 0; i <= Main.user.getAllEvents().size() - 1; i++) {
                System.out.println(index + "." + Main.user.getAllEvents().get(i).name);
                index++;
            }

            System.out.println(" ");
            System.out.println("Choose the event index to select it.");

            TryGetValues.tryGetOption(Main.user.getAllEvents().size());
            int option = TryGetValues.choice;

            displayEvent(Main.user.getAllEvents().get(option - 1));
        }
    }

    public static void displayNextEvents() {

        if (Main.user.getAllEvents().isEmpty()) {
            System.out.println(" ");
            System.out.println("You don't have any registered events.");
            Main.backToMenuOptions();

        } else {

            populatePastAndNextEventsArrayLists();

            if (Main.user.getNextEvents().isEmpty()) {
                System.out.println(" ");
                System.out.println("You have no upcoming events.");
                Main.backToMenuOptions();
            } else {

                sortEventsByClosestDateTime(Main.user.getNextEvents());

                System.out.println(" ");
                System.out.println("NEXT EVENTS");
                System.out.println(" ");
                int index = 1;

                for (int i = 0; i <= Main.user.getNextEvents().size() - 1; i++) {
                    System.out.println(index + "." + Main.user.getNextEvents().get(i).name);
                    index++;
                }

                System.out.println(" ");
                System.out.println("Choose the event index to select it.");

                TryGetValues.tryGetOption(Main.user.getNextEvents().size());
                int option = TryGetValues.choice;

                displayEvent(Main.user.getNextEvents().get(option - 1));
            }

        }
    }

    public static void displayPastEvents() {

        if (Main.user.getAllEvents().isEmpty()) {
            System.out.println(" ");
            System.out.println("You don't have any registered events.");
            Main.backToMenuOptions();

        } else {

            populatePastAndNextEventsArrayLists();

            if (Main.user.getPastEvents().isEmpty()) {
                System.out.println(" ");
                System.out.println("You have no past events.");
                Main.backToMenuOptions();
            } else {

                sortEventsByClosestDateTime(Main.user.getPastEvents());

                System.out.println(" ");
                System.out.println("PAST EVENTS");
                System.out.println(" ");
                int index = 1;

                for (int i = 0; i <= Main.user.getPastEvents().size() - 1; i++) {
                    System.out.println(index + "." + Main.user.getPastEvents().get(i).name);
                    index++;
                }

                System.out.println(" ");
                System.out.println("Choose the event index to select it.");

                TryGetValues.tryGetOption(Main.user.getPastEvents().size());
                int option = TryGetValues.choice;

                displayEvent(Main.user.getPastEvents().get(option - 1));
            }
        }

    }

    public static void displayJoinedEvents() {
        if (Main.user.getAllEvents().isEmpty()) {
            System.out.println(" ");
            System.out.println("You don't have any registered events.");
            Main.backToMenuOptions();

        } else {
            if (Main.user.getJoinedEvents().isEmpty()) {
                System.out.println(" ");
                System.out.println("You do not have a registered presence at any event.");
                Main.backToMenuOptions();

            } else {

                sortEventsByClosestDateTime(Main.user.getJoinedEvents());

                System.out.println(" ");
                System.out.println("EVENTS WITH CONFIRMED PARTICIPATION");
                System.out.println(" ");
                int index = 1;
                for (int i = 0; i <= Main.user.getJoinedEvents().size() - 1; i++) {
                    System.out.println(index + "." + Main.user.getJoinedEvents().get(i).name);
                    index++;
                }

                System.out.println(" ");
                System.out.println("Would you like to cancel your attendance in any of these events?");

                System.out.println(" ");
                System.out.println("1. Yes.");
                System.out.println("2. Cancel all.");
                System.out.println("3. No.");

                TryGetValues.tryGetOption(3);
                int finalOption = TryGetValues.choice;

                if (finalOption == 3) {
                    Main.displayMenuOptions();
                } else if (finalOption == 1) {
                    System.out.println(" ");
                    System.out.println("Choose the event index to select it and cancel your attendance.");

                    TryGetValues.tryGetOption(Main.user.getJoinedEvents().size());
                    int option = TryGetValues.choice;

                    Event event = Main.user.getJoinedEvents().get(option - 1);

                    System.out.println(" ");
                    System.out.println("You have canceled your attendance at the " + event.name + " event.");

                    event.join = false;
                    Main.user.getNotJoinedEvents().add(event);
                    Main.user.getJoinedEvents().remove(event);
                    Main.backToMenuOptions();
                } else {

                    int size = Main.user.getJoinedEvents().size();

                    for (int i = 0; i < size; i++) {
                        Event event = Main.user.getJoinedEvents().get(i);
                        event.join = false;
                        Main.user.getNotJoinedEvents().add(event);
                        System.out.println("You have canceled your attendance at the " + event.name + " event.");
                    }
                    System.out.println(" ");
                    System.out.println("You have canceled your attendance at the all events.");

                    Main.user.resetJoinedEvents();

                    Main.backToMenuOptions();
                }

            }
        }
    }

    public static void displayNotJoinedEvents() {
        if (Main.user.getAllEvents().isEmpty()) {
            System.out.println(" ");
            System.out.println("You don't have any registered events.");
            Main.backToMenuOptions();
        } else {

            if (Main.user.getNotJoinedEvents().isEmpty()) {
                System.out.println(" ");
                System.out.println("You confirmed your presence at all registered events.");
                Main.backToMenuOptions();

            } else {

                sortEventsByClosestDateTime(Main.user.getNotJoinedEvents());

                System.out.println(" ");
                System.out.println("EVENTS WITH NOT CONFIRMED PARTICIPATION");
                System.out.println(" ");
                int index = 1;
                for (int i = 0; i <= Main.user.getNotJoinedEvents().size() - 1; i++) {
                    System.out.println(index + "." + Main.user.getNotJoinedEvents().get(i).name);
                    index++;
                }
                System.out.println(" ");
                System.out.println("Do you want to confirm your attendance in any of these events?");

                System.out.println(" ");
                System.out.println("1. Yes.");
                System.out.println("2. Confirm all.");
                System.out.println("3. No.");

                TryGetValues.tryGetOption(3);

                int finalOption = TryGetValues.choice;

                if (finalOption == 3) {
                    Main.displayMenuOptions();
                } else if (finalOption == 1) {
                    System.out.println(" ");
                    System.out.println("Choose the event index to select it and confirm your attendance.");

                    TryGetValues.tryGetOption(Main.user.getNotJoinedEvents().size());
                    int option = TryGetValues.choice;

                    Event event = Main.user.getNotJoinedEvents().get(option - 1);

                    System.out.println(" ");
                    System.out.println("You have confirmed your attendance at the " + event.name + " event.");

                    event.join = true;
                    Main.user.getJoinedEvents().add(event);
                    Main.user.getNotJoinedEvents().remove(event);
                    Main.backToMenuOptions();
                } else {

                    int size = Main.user.getNotJoinedEvents().size();

                    for (int i = 0; i < size; i++) {
                        Event event = Main.user.getNotJoinedEvents().get(i);
                        event.join = true;
                        Main.user.getJoinedEvents().add(event);
                        System.out.println("You have confirmed your attendance at the " + event.name + " event.");
                    }
                    System.out.println(" ");
                    System.out.println("You have confirmed your attendance at all events.");

                    Main.user.resetNotJoinedEvents();

                    Main.backToMenuOptions();
                }
            }
        }
    }

    public static void displayEvent(Event event) {
        System.out.println(" ");
        System.out.println("Title: " + event.name);
        System.out.println("Description: " + event.description);
        System.out.println("Address: " + event.address);
        System.out.println("Category: " + event.category);
        System.out.println("Date: " + event.date);
        System.out.println("Initial Time: " + event.initialTime);
        System.out.println("Final Time: " + event.finalTime);

        if(ValidateValues.eventIsHappeningNow((event)))
        {
            System.out.println(" ");
            System.out.println("THIS EVENT IS HAPPENING NOW!");
        }

        if (event.join) {
            System.out.println(" ");
            System.out.println("You have already attended this event. Do you want to cancel your attendance?");

            System.out.println(" ");
            System.out.println("1. Yes.");
            System.out.println("2. No.");

            TryGetValues.tryGetOption(2);
            int finalOption = TryGetValues.choice;

            if (finalOption == 2) {
                Main.backToMenuOptions();
            } else {
                System.out.println(" ");
                System.out.println("You have canceled your attendance at the" + event.name + "event.");

                event.join = false;
                Main.user.getNotJoinedEvents().add(event);
                Main.user.getJoinedEvents().remove(event);
                Main.backToMenuOptions();
            }

        } else {
            System.out.println(" ");
            System.out.println("Your presence is not confirmed for this event. Do you want to confirm?");

            System.out.println(" ");
            System.out.println("1. Yes.");
            System.out.println("2. No.");

            TryGetValues.tryGetOption(2);
            int finalOption = TryGetValues.choice;
            if (finalOption == 2) {
                Main.backToMenuOptions();
            } else {
                System.out.println(" ");
                System.out.println("You have confirmed your presence at the" + event.name + "event.");

                event.join = true;
                Main.user.getJoinedEvents().add(event);
                Main.user.getNotJoinedEvents().remove(event);
                Main.backToMenuOptions();
            }
        }
        Main.backToMenuOptions();
    }

    private static void populatePastAndNextEventsArrayLists() {
        Main.user.resetNextEvents();
        Main.user.resetPastEvents();
        Main.todayDateTime = LocalDateTime.now();

        for (int i = 0; i < Main.user.getAllEvents().size(); i++) {
            Event event = Main.user.getAllEvents().get(i);
            if (event.dateTime.isAfter(Main.todayDateTime)) {
                Main.user.getNextEvents().add(event);
            } else {
                Main.user.getPastEvents().add(event);
            }
        }
    }

    private static void sortEventsByClosestDateTime(ArrayList<Event> list) {
        Collections.sort(list);
        Collections.reverse(list);
    }
}
