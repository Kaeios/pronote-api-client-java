package fr.litarvan.pronote.request;

import com.google.gson.JsonObject;
import fr.litarvan.pronote.PronoteAPI;
import fr.litarvan.pronote.data.timetable.Lesson;
import fr.litarvan.pronote.data.timetable.Timetable;
import fr.litarvan.pronote.server.request.RequestException;

import java.io.IOException;

public class TimeTableRequest {

    public static QueryBuilder getTimetable(String of) {
        return new QueryBuilder()
                .function("timetable", "from", "\""+ of +"\"")
                .elements(Lesson.class);
    }

    public static QueryBuilder getTimetable(String from, String to) {
        return new QueryBuilder()
                .function("timetable", "from", "\""+ from +"\"", "to", "\""+ to +"\"")
                .elements(Lesson.class);
    }

    public static Timetable fetch(PronoteAPI api, String from, String to) throws IOException, RequestException {
        QueryBuilder builder = getTimetable(from, to);
        JsonObject timetable = api.fetch(builder.build());
        return PronoteAPI.gson.fromJson(timetable, Timetable.class);
    }

    public static Timetable fetch(PronoteAPI api, String from) throws IOException, RequestException {
        QueryBuilder builder = getTimetable(from);
        JsonObject timetable = api.fetch(builder.build());
        return PronoteAPI.gson.fromJson(timetable, Timetable.class);
    }

}
