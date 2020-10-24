package fr.litarvan.pronote.request;

import com.google.gson.JsonObject;
import fr.litarvan.pronote.PronoteAPI;
import fr.litarvan.pronote.data.menus.MenuDay;
import fr.litarvan.pronote.data.menus.MenuMealEntry;
import fr.litarvan.pronote.data.menus.Menus;
import fr.litarvan.pronote.server.request.RequestException;

import java.io.IOException;

public class MenusRequest {

    public static String buildQuery(String from) {

        return new QueryBuilder()
                .function("menu", "from", "\"" + from + "\"")
                .elements(MenuDay.class)
                .build();
    }

    public static String buildQuery(String from, String to) {

        return new QueryBuilder()
                .function("menu", "from", "\"" + from + "\"", "to", "\"" + to + "\"")
                .elements(MenuDay.class)
                .build();
    }

    public static Menus fetch(PronoteAPI api, String from) throws IOException, RequestException {

        JsonObject menus = api.fetch(buildQuery(from));
        return PronoteAPI.gson.fromJson(menus, Menus.class);
    }

    public static Menus fetch(PronoteAPI api, String from, String to) throws IOException, RequestException {

        JsonObject menus = api.fetch(buildQuery(from, to));
        return PronoteAPI.gson.fromJson(menus, Menus.class);
    }

}
