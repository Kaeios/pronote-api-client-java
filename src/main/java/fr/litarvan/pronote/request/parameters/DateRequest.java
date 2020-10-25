package fr.litarvan.pronote.request.parameters;

public class DateRequest implements ParameterizedRequest {

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public int getParametersCount() {
        return 2;
    }

    @Override
    public String[] buildParameters(String... parameters) {

        String[] result = new String[Math.min(parameters.length * 2, 4)];

        if (parameters.length > 0 && parameters[0] != null) {
            result[0] = "from";
            result[1] = "\"" + parameters[0] + "\"";
        }

        if (parameters.length > 1 && parameters[1] != null) {
            result[2] = "to";
            result[3] = "\"" + parameters[1] + "\"";
        }

        return result;
    }

}
