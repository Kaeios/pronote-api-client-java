package fr.litarvan.pronote.request.pronote;

import fr.litarvan.pronote.data.absences.Absences;
import fr.litarvan.pronote.request.*;

import java.util.Arrays;

public class AbsencesRequest extends Request<Absences> {

    public AbsencesRequest() {
        super("absences", Absences.class, Absences.class, Arrays.asList(new PeriodRequest(), new DateRequest()),  true);
    }

}
