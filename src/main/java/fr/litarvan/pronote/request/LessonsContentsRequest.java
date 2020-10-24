package fr.litarvan.pronote.request;

import com.google.gson.JsonObject;
import fr.litarvan.pronote.PronoteAPI;
import fr.litarvan.pronote.data.contents.Contents;
import fr.litarvan.pronote.data.contents.LessonContent;
import fr.litarvan.pronote.data.timetable.Lesson;
import fr.litarvan.pronote.data.timetable.Timetable;
import fr.litarvan.pronote.server.request.RequestException;

import java.io.IOException;

public class LessonsContentsRequest {

    public static String buildQuery(String of) {

        return new QueryBuilder()
                .function("contents", "from", "\"" + of + "\"")
                .elements(LessonContent.class)
                .build();
    }

    public static String buildQuery(String from, String to) {

        return new QueryBuilder()
                .function("contents", "from", "\"" + from + "\"", "to", "\"" + to + "\"")
                .elements(LessonContent.class)
                .build();
    }

    public static Contents fetch(PronoteAPI api, String from, String to) throws IOException, RequestException {

        JsonObject contents = api.fetch(buildQuery(from, to));
        return PronoteAPI.gson.fromJson(contents, Contents.class);
    }

    public static Contents fetch(PronoteAPI api, String from) throws IOException, RequestException {

        JsonObject contents = api.fetch(buildQuery(from));
        return PronoteAPI.gson.fromJson(contents, Contents.class);
    }

}
