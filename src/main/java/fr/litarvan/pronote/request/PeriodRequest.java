package fr.litarvan.pronote.request;

public class PeriodRequest implements RequestBehavior {

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
