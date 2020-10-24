package fr.litarvan.pronote.request.pronote;

import fr.litarvan.pronote.data.homeworks.Homework;
import fr.litarvan.pronote.data.homeworks.Homeworks;
import fr.litarvan.pronote.request.*;

import java.util.Collections;

public class HomeWorkRequest extends Request<Homeworks> {

    public HomeWorkRequest() {
        super("homeworks", Homework.class, Homeworks.class,
                Collections.singletonList(new DateRequest()),
                Collections.singletonList(new Replacement(",to,", ",for,")));
    }

}
