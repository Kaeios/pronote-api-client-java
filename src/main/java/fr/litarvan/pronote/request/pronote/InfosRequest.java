package fr.litarvan.pronote.request.pronote;

import fr.litarvan.pronote.data.informations.Info;
import fr.litarvan.pronote.request.Request;
import fr.litarvan.pronote.data.informations.Infos;

import java.util.Collections;

public class InfosRequest extends Request<Infos> {

    public InfosRequest() {
        super("infos", Info.class, Infos.class, Collections.emptyList());
    }

}
