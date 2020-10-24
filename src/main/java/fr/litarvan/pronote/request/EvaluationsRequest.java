package fr.litarvan.pronote.request;

import fr.litarvan.pronote.PronoteAPI;
import fr.litarvan.pronote.data.evaluations.Evaluation;
import fr.litarvan.pronote.data.evaluations.EvaluationSubject;
import fr.litarvan.pronote.data.evaluations.Evaluations;
import fr.litarvan.pronote.server.request.RequestException;

import java.io.IOException;

public class EvaluationsRequest {

    public static String buildQuery(String period) {

        return new QueryBuilder()
                .function("evaluations", "period", "\"" + period + "\"")
                .elements(EvaluationSubject.class)
                .build()
                .replace("aShort", "short")
                .replace("aLong", "long");
    }

    public static Evaluations fetch(PronoteAPI api, String period) throws IOException, RequestException {

        String homeworks = api.fetch(buildQuery(period)).toString()
                .replace("short", "aShort")
                .replace("long", "aLong");

        return PronoteAPI.gson.fromJson(homeworks, Evaluations.class);
    }

}
