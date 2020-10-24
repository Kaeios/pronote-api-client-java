package fr.litarvan.pronote.request;

import fr.litarvan.pronote.PronoteAPI;
import fr.litarvan.pronote.data.homeworks.Homework;
import fr.litarvan.pronote.data.homeworks.Homeworks;
import fr.litarvan.pronote.server.request.RequestException;

import java.io.IOException;

public class HomeWorkRequest {

    public static String buildQuery(String from) {

        return new QueryBuilder()
                .function("homeworks", "from", "\"" + from + "\"")
                .elements(Homework.class)
                .build()
                .replace(",to,", ",for,");
    }

    public static String buildQuery(String from, String to) {

        return new QueryBuilder()
                .function("homeworks", "from", "\"" + from + "\"", "to", "\"" + to + "\"")
                .elements(Homework.class)
                .build()
                .replace(",to,", ",for,");
    }

    public static Homeworks fetch(PronoteAPI api, String from, String to) throws IOException, RequestException {

        String homeworks = api.fetch(buildQuery(from, to)).toString().replace(",for,", ",to,");
        return PronoteAPI.gson.fromJson(homeworks, Homeworks.class);
    }

    public static Homeworks fetch(PronoteAPI api, String from) throws IOException, RequestException {

        String homeworks = api.fetch(buildQuery(from)).toString().replace(",for,", ",to,");

        return PronoteAPI.gson.fromJson(homeworks, Homeworks.class);
    }

}
