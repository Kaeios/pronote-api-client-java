package fr.litarvan.pronote.request.pronote;

import fr.litarvan.pronote.request.PeriodRequest;
import fr.litarvan.pronote.request.Request;
import fr.litarvan.pronote.data.marks.Marks;

import java.util.Collections;

public class MarksRequest extends Request<Marks> {

    public MarksRequest() {
        super("marks", Marks.class, Marks.class, Collections.singletonList(new PeriodRequest()), true);
    }

}
