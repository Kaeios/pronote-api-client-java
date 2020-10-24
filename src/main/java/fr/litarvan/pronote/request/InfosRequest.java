package fr.litarvan.pronote.request;

import com.google.gson.JsonObject;
import fr.litarvan.pronote.PronoteAPI;
import fr.litarvan.pronote.data.informations.Info;
import fr.litarvan.pronote.server.request.RequestException;
import fr.litarvan.pronote.data.informations.Infos;

import java.io.IOException;

public class InfosRequest {

    public static Infos fetch(PronoteAPI api) throws IOException, RequestException {
        QueryBuilder builder =  new QueryBuilder()
                .value("infos")
                .elements(Info.class);

        JsonObject infos = api.fetch(builder.build());
        return PronoteAPI.gson.fromJson(infos, Infos.class);
    }

}
