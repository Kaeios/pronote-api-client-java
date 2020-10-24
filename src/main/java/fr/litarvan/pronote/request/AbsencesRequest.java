package fr.litarvan.pronote.request;

import com.google.gson.JsonObject;
import fr.litarvan.pronote.PronoteAPI;
import fr.litarvan.pronote.data.absences.Absences;
import fr.litarvan.pronote.data.homeworks.Homework;
import fr.litarvan.pronote.data.homeworks.Homeworks;
import fr.litarvan.pronote.server.request.RequestException;

import java.io.IOException;

public class AbsencesRequest {

    public static String buildQuery(String period, String from) {

        return new QueryBuilder()
                .function("absences", "period", "\"" + period + "\"", "from", "\"" + from + "\"")
                .elements(Absences.class)
                .build();
    }

    public static String buildQuery(String period, String from, String to) {

        return new QueryBuilder()
                .function("absences", "period", "\"" + period + "\"", "from", "\"" + from + "\"", "to", "\"" + to + "\"")
                .elements(Absences.class)
                .build();
    }

    public static Absences fetch(PronoteAPI api, String period, String from) throws IOException, RequestException {

        JsonObject absences = api.fetch(buildQuery(period, from)).getAsJsonObject("absences");
        return PronoteAPI.gson.fromJson(absences, Absences.class);
    }

    public static Absences fetch(PronoteAPI api, String period, String from, String to) throws IOException, RequestException {

        JsonObject absences = api.fetch(buildQuery(period, from, to)).getAsJsonObject("absences");
        return PronoteAPI.gson.fromJson(absences, Absences.class);
    }

}
