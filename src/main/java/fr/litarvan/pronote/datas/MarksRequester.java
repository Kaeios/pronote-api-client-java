package fr.litarvan.pronote.datas;

import com.google.gson.JsonObject;
import fr.litarvan.pronote.PronoteAPI;
import fr.litarvan.pronote.QueryBuilder;
import fr.litarvan.pronote.RequestException;
import fr.litarvan.pronote.data.Marks;

import java.io.IOException;

public class MarksRequester {

    public static QueryBuilder getMarks(String period) {
        return new QueryBuilder()
                .function("marks", "period", "\""+ period +"\"")
                .elements(Marks.class);
    }

    public static Marks fetch(PronoteAPI api, String period) throws IOException, RequestException {
        QueryBuilder builder = MarksRequester.getMarks(period);
        JsonObject marks = PronoteAPI.gson.fromJson(api.fetch(builder.build()), JsonObject.class).getAsJsonObject("marks");
        return PronoteAPI.gson.fromJson(marks, Marks.class);
    }

}
