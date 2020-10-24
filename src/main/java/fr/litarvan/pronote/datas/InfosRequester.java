package fr.litarvan.pronote.datas;

import com.google.gson.JsonObject;
import fr.litarvan.pronote.PronoteAPI;
import fr.litarvan.pronote.QueryBuilder;
import fr.litarvan.pronote.RequestException;
import fr.litarvan.pronote.data.Infos;

import java.io.IOException;

public class InfosRequester {

    public static Infos fetch(PronoteAPI api) throws IOException, RequestException {
        QueryBuilder builder =  new QueryBuilder()
                .value("infos")
                .elements(Info.class);

        JsonObject infos = api.fetch(builder.build());
        return PronoteAPI.gson.fromJson(infos, Infos.class);
    }

}
