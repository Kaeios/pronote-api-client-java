package fr.litarvan.pronote.request.pronote;

import fr.litarvan.pronote.data.evaluations.EvaluationSubject;
import fr.litarvan.pronote.data.evaluations.Evaluations;
import fr.litarvan.pronote.request.*;

import java.util.Arrays;
import java.util.Collections;

public class EvaluationsRequest extends Request<Evaluations> {

    public EvaluationsRequest() {
        super("evaluations", EvaluationSubject.class, Evaluations.class,
                Collections.singletonList(new PeriodRequest()),
                Arrays.asList(new Replacement("aShort", "short"), new Replacement("aLong", "long")));
    }

}
