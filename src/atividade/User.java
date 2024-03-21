package atividade;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String name, email, city;
    private int age;

    private ArrayList<Event> events = new ArrayList<>();

    private ArrayList<Event> joinedEvents = new ArrayList<>();


    private ArrayList<Event> notJoinedEvents = new ArrayList<>();

    private ArrayList<Event> nextEvents = new ArrayList<>();

    private ArrayList<Event> pastEvents = new ArrayList<>();

    public User() {
        name = "defaultName";
        age = 0;
        email = "defaultEmail";
        city = "defaultCity";
    }

    public ArrayList<Event> getAllEvents() {
        return events;
    }

    public ArrayList<Event> getJoinedEvents() {
        return joinedEvents;
    }

    public ArrayList<Event> getNotJoinedEvents() {
        return notJoinedEvents;
    }

    public ArrayList<Event> getNextEvents() {
        return nextEvents;
    }

    public ArrayList<Event> getPastEvents() {
        return pastEvents;
    }

    public void resetPastEvents() {
        pastEvents = new ArrayList<>();
    }

    public void resetNextEvents() {
        nextEvents = new ArrayList<>();
    }

    public void resetJoinedEvents() {
        joinedEvents = new ArrayList<>();
    }

    public void resetNotJoinedEvents() {
        notJoinedEvents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public User(String _name, int _age, String _email, String _city) {
        name = _name;
        age = _age;
        email = _email;
        city = _city;
    }

    public static User registerNewUser(String name, int age, String email, String city) {
        return new User(name, age, email, city);
    }
}
