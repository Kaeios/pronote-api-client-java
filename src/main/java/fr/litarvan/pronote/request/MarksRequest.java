package fr.litarvan.pronote.request;

import com.google.gson.JsonObject;
import fr.litarvan.pronote.PronoteAPI;
import fr.litarvan.pronote.server.request.RequestException;
import fr.litarvan.pronote.data.marks.Marks;

import java.io.IOException;

public class MarksRequest {

    public static String builderQuery(String period) {
        return new QueryBuilder()
                .function("marks", "period", "\"" + period + "\"")
                .elements(Marks.class)
                .build();
    }

    public static Marks fetch(PronoteAPI api, String period) throws IOException, RequestException {

        JsonObject marks = PronoteAPI.gson.fromJson(api.fetch(builderQuery(period)), JsonObject.class).getAsJsonObject("marks");
        return PronoteAPI.gson.fromJson(marks, Marks.class);
    }

}
