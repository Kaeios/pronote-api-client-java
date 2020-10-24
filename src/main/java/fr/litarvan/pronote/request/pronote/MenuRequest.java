package fr.litarvan.pronote.request.pronote;

import fr.litarvan.pronote.data.menus.MenuDay;
import fr.litarvan.pronote.data.menus.Menu;
import fr.litarvan.pronote.request.DateRequest;
import fr.litarvan.pronote.request.Request;

import java.util.Collections;

public class MenuRequest extends Request<Menu> {

    public MenuRequest() {
        super("menu", MenuDay.class, Menu.class, Collections.singletonList(new DateRequest()));
    }

}
