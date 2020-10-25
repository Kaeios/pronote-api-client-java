package fr.litarvan.pronote.request.pronote;

import fr.litarvan.pronote.data.contents.Contents;
import fr.litarvan.pronote.data.contents.LessonContent;
import fr.litarvan.pronote.request.RequestBuilder;
import fr.litarvan.pronote.request.parameters.DateRequest;
import fr.litarvan.pronote.request.Request;

public class LessonsContentsRequest extends Request<Contents> {

    public LessonsContentsRequest() {
        super(new RequestBuilder<Contents>()
                .withName("contents")
                .withSerializedClass(LessonContent.class)
                .withReturnClass(Contents.class)
                .addRequestParameters(new DateRequest())
        );
    }

}
