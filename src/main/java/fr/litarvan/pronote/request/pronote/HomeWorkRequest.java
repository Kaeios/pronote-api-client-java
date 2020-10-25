package fr.litarvan.pronote.request.pronote;

import fr.litarvan.pronote.data.homeworks.Homework;
import fr.litarvan.pronote.data.homeworks.Homeworks;
import fr.litarvan.pronote.request.*;
import fr.litarvan.pronote.request.parameters.DateRequest;

public class HomeWorkRequest extends Request<Homeworks> {

    public HomeWorkRequest() {
        super(new RequestBuilder<Homeworks>()
                .withName("homeworks")
                .withSerializedClass(Homework.class)
                .withReturnClass(Homeworks.class)
                .addRequestParameters(new DateRequest())
                .addReplacements(new Replacement(",to,", ",for,"))
        );
    }

}
