package atividade;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class Event implements Comparable<Event>, Serializable {
    String name;
    String address;
    Category category;
    String description;
    boolean join;
    LocalDate date;
    LocalTime initialTime;
    LocalTime finalTime;
    LocalDateTime dateTime;

    public Event(String _name, String _address, Category _category, String _description, LocalDate _date, LocalTime _initialTime, LocalTime _finalTime, LocalDateTime _dateTime, boolean _join) {
        name = _name;
        address = _address;
        category = _category;
        description = _description;
        date = _date;
        initialTime = _initialTime;
        finalTime = _finalTime;
        join = _join;
        dateTime = _dateTime;
    }

    public static Event registerNewEvent(String name, String address, Category category, String description, LocalDate date, LocalTime initialTime, LocalTime finalTime, LocalDateTime dateTime, boolean join) {

        return new Event(name, address, category, description, date, initialTime, finalTime, dateTime, join);
    }

    @Override
    public int compareTo(Event o) {
        return dateTime.compareTo(o.dateTime);
    }
}
