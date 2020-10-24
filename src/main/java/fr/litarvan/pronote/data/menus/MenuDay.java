package fr.litarvan.pronote.data.menus;

import fr.litarvan.pronote.data.Data;

public class MenuDay implements Data {

    private long date;
    private MenuMealEntry[][] meals;

    public long getDate() {
        return date;
    }

    public MenuMealEntry[][] getMeals() {
        return meals;
    }

}
