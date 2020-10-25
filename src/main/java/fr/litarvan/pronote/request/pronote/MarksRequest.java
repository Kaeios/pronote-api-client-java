package fr.litarvan.pronote.request.pronote;

import fr.litarvan.pronote.request.RequestBuilder;
import fr.litarvan.pronote.request.parameters.PeriodRequest;
import fr.litarvan.pronote.request.Request;
import fr.litarvan.pronote.data.marks.Marks;

public class MarksRequest extends Request<Marks> {

    public MarksRequest() {
        super(new RequestBuilder<Marks>()
                .withName("marks")
                .withSerializedClass(Marks.class)
                .withReturnClass(Marks.class)
                .addRequestParameters(new PeriodRequest())
                .needSubPart(true)
        );
    }

}
