package fr.litarvan.pronote.request.parameters;

public class PeriodRequest implements ParameterizedRequest {

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public int getParametersCount() {
        return 1;
    }

    @Override
    public String[] buildParameters(String... parameters) {

        String[] result = new String[Math.min(parameters.length * 2, 2)];

        if (parameters.length > 0) {
            result[0] = "period";
            result[1] = "\"" + parameters[0] + "\"";
        }

        return result;
    }

}
