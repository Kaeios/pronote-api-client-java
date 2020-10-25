package fr.litarvan.pronote.request.pronote;

import fr.litarvan.pronote.data.timetable.Lesson;
import fr.litarvan.pronote.data.timetable.Timetable;
import fr.litarvan.pronote.request.RequestBuilder;
import fr.litarvan.pronote.request.parameters.DateRequest;
import fr.litarvan.pronote.request.Request;

public class TimeTableRequest extends Request<Timetable> {

    public TimeTableRequest() {
        super(new RequestBuilder<Timetable>()
                .withName("timetable")
                .withSerializedClass(Lesson.class)
                .withReturnClass(Timetable.class)
                .addRequestParameters(new DateRequest())
        );
    }

}
