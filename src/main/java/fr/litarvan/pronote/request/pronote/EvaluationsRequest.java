package fr.litarvan.pronote.request.pronote;

import fr.litarvan.pronote.data.evaluations.EvaluationSubject;
import fr.litarvan.pronote.data.evaluations.Evaluations;
import fr.litarvan.pronote.request.*;
import fr.litarvan.pronote.request.parameters.PeriodRequest;

public class EvaluationsRequest extends Request<Evaluations> {

    public EvaluationsRequest() {
        super(new RequestBuilder<Evaluations>()
                .withName("evaluations")
                .withSerializedClass(EvaluationSubject.class)
                .withReturnClass(Evaluations.class)
                .addRequestParameters(new PeriodRequest())
                .addReplacements(new Replacement("aShort", "short"))
                .addReplacements(new Replacement("aLong", "long"))
        );
    }

}
