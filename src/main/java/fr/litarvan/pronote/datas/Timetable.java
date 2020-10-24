package fr.litarvan.pronote.datas;

import com.google.gson.JsonObject;
import fr.litarvan.pronote.PronoteAPI;
import fr.litarvan.pronote.QueryBuilder;
import fr.litarvan.pronote.RequestException;

import java.io.IOException;
import java.util.List;

public class Timetable implements Data {

    private List<Lesson> timetable;

    public List<Lesson> getTimetable() {
        return timetable;
    }

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
        QueryBuilder builder = Timetable.getTimetable(from, to);
        JsonObject timetable = api.fetch(builder.build());
        return PronoteAPI.gson.fromJson(timetable, Timetable.class);
    }

    public static Timetable fetch(PronoteAPI api, String from) throws IOException, RequestException {
        QueryBuilder builder = Timetable.getTimetable(from);
        JsonObject timetable = api.fetch(builder.build());
        return PronoteAPI.gson.fromJson(timetable, Timetable.class);
    }

}
