package fr.litarvan.pronote.request.pronote;

import fr.litarvan.pronote.data.contents.Contents;
import fr.litarvan.pronote.data.contents.LessonContent;
import fr.litarvan.pronote.request.DateRequest;
import fr.litarvan.pronote.request.Request;

import java.util.Collections;

public class LessonsContentsRequest extends Request<Contents> {

    public LessonsContentsRequest() {
        super("contents", LessonContent.class, Contents.class, Collections.singletonList(new DateRequest()));
    }

}
