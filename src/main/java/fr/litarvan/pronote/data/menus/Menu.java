package fr.litarvan.pronote.data.menus;

import fr.litarvan.pronote.data.Data;

import java.util.List;

public class Menu implements Data {

    private List<MenuMealEntry> menu;

    public List<MenuMealEntry> getMenu() {
        return menu;
    }

}
