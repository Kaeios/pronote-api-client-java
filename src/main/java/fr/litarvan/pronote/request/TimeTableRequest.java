package fr.litarvan.pronote.request;

import com.google.gson.JsonObject;
import fr.litarvan.pronote.PronoteAPI;
import fr.litarvan.pronote.data.timetable.Lesson;
import fr.litarvan.pronote.data.timetable.Timetable;
import fr.litarvan.pronote.server.request.RequestException;

import java.io.IOException;

public class TimeTableRequest {

    public static String buildQuery(String from) {

        return new QueryBuilder()
                .function("timetable", "from", "\"" + from + "\"")
                .elements(Lesson.class)
                .build();
    }

    public static String buildQuery(String from, String to) {

        return new QueryBuilder()
                .function("timetable", "from", "\"" + from + "\"", "to", "\"" + to + "\"")
                .elements(Lesson.class)
                .build();
    }

    public static Timetable fetch(PronoteAPI api, String from, String to) throws IOException, RequestException {

        JsonObject timetable = api.fetch(buildQuery(from, to));
        return PronoteAPI.gson.fromJson(timetable, Timetable.class);
    }

    public static Timetable fetch(PronoteAPI api, String from) throws IOException, RequestException {

        JsonObject timetable = api.fetch(buildQuery(from));
        return PronoteAPI.gson.fromJson(timetable, Timetable.class);
    }

}
