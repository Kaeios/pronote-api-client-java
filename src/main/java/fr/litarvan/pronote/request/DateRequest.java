package fr.litarvan.pronote.request;

import java.util.Arrays;

public class DateRequest implements RequestBehavior {

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
