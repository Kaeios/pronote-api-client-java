package fr.litarvan.pronote.request.pronote;

import fr.litarvan.pronote.data.absences.Absences;
import fr.litarvan.pronote.request.*;
import fr.litarvan.pronote.request.parameters.DateRequest;
import fr.litarvan.pronote.request.parameters.PeriodRequest;

public class AbsencesRequest extends Request<Absences> {

    public AbsencesRequest() {
        super(new RequestBuilder<Absences>()
                .withName("absences")
                .withSerializedClass(Absences.class)
                .withReturnClass(Absences.class)
                .addRequestParameters(new PeriodRequest())
                .addRequestParameters(new DateRequest())
                .needSubPart(true)
        );
    }

}
