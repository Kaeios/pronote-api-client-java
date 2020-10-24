package fr.litarvan.pronote.request;

import com.google.gson.JsonObject;
import fr.litarvan.pronote.PronoteAPI;
import fr.litarvan.pronote.data.informations.Info;
import fr.litarvan.pronote.server.request.RequestException;
import fr.litarvan.pronote.data.informations.Infos;

import java.io.IOException;

public class InfosRequest {

    public static Infos fetch(PronoteAPI api) throws IOException, RequestException {
        String query = new QueryBuilder()
                .value("infos")
                .elements(Info.class)
                .build();

        JsonObject infos = api.fetch(query);
        return PronoteAPI.gson.fromJson(infos, Infos.class);
    }

}
