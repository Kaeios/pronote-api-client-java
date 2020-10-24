package fr.litarvan.pronote.request;

public interface RequestBehavior {

    int getParametersCount();

    String[] buildParameters(String... parameters);

}
