package fr.litarvan.pronote.request.parameters;

public interface ParameterizedRequest {

    int getPriority();

    int getParametersCount();

    String[] buildParameters(String... parameters);

}
