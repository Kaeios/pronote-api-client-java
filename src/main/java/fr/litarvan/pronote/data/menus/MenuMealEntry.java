package fr.litarvan.pronote.data.menus;

import fr.litarvan.pronote.data.Data;

public class MenuMealEntry implements Data {

    private String name;
    private MenuMealLabel[] labels;

    public String getName() {
        return name;
    }

    public MenuMealLabel[] getLabels() {
        return labels;
    }

}
