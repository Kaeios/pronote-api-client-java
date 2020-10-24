package fr.litarvan.pronote.data.timetable;

import fr.litarvan.pronote.data.Data;

import java.util.List;

public class Timetable implements Data {

    private List<Lesson> timetable;

    public List<Lesson> getTimetable() {
        return timetable;
    }

}
