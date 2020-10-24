package fr.litarvan.pronote.request.pronote;

import fr.litarvan.pronote.data.timetable.Lesson;
import fr.litarvan.pronote.data.timetable.Timetable;
import fr.litarvan.pronote.request.DateRequest;
import fr.litarvan.pronote.request.Request;

import java.util.Collections;

public class TimeTableRequest extends Request<Timetable> {

    public TimeTableRequest() {
        super("timetable", Lesson.class, Timetable.class, Collections.singletonList(new DateRequest()));
    }

}
