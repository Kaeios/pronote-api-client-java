package fr.litarvan.pronote.request.pronote;

import fr.litarvan.pronote.data.informations.Info;
import fr.litarvan.pronote.request.Request;
import fr.litarvan.pronote.data.informations.Infos;
import fr.litarvan.pronote.request.RequestBuilder;

public class InfosRequest extends Request<Infos> {

    public InfosRequest() {
        super(new RequestBuilder<Infos>()
                .withName("infos")
                .withSerializedClass(Info.class)
                .withReturnClass(Infos.class)
        );
    }

}
