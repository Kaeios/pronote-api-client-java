package fr.litarvan.pronote.request.pronote;

import fr.litarvan.pronote.data.menus.MenuDay;
import fr.litarvan.pronote.data.menus.Menu;
import fr.litarvan.pronote.request.RequestBuilder;
import fr.litarvan.pronote.request.parameters.DateRequest;
import fr.litarvan.pronote.request.Request;

public class MenuRequest extends Request<Menu> {

    public MenuRequest() {
        super(new RequestBuilder<Menu>()
                .withName("menu")
                .withSerializedClass(MenuDay.class)
                .withReturnClass(Menu.class)
                .addRequestParameters(new DateRequest())
        );
    }

}
