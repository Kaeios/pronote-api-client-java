package fr.litarvan.pronote.request;

import com.google.gson.JsonObject;
import fr.litarvan.pronote.PronoteAPI;
import fr.litarvan.pronote.server.request.RequestException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Request<T> {

    private final String name;
    private final Class<?> serializedClass;
    private final Class<T> returnClass;
    private final List<RequestBehavior> behaviors;
    private final List<Replacement> replacements;
    private final boolean subPart;

    protected Request(String name, Class<?> serializedClass, Class<T> returnClass, List<RequestBehavior> behaviors, List<Replacement> replacements, boolean subPart) {
        this.name = name;
        this.serializedClass = serializedClass;
        this.returnClass = returnClass;
        this.behaviors = behaviors;
        this.replacements = replacements;
        this.subPart = subPart;
    }

    protected Request(String name, Class<?> serializedClass, Class<T> returnClass, List<RequestBehavior> behaviors, List<Replacement> replacements) {
        this.name = name;
        this.serializedClass = serializedClass;
        this.returnClass = returnClass;
        this.behaviors = behaviors;
        this.replacements = replacements;
        this.subPart = false;
    }

    protected Request(String name, Class<?> serializedClass, Class<T> returnClass, List<RequestBehavior> behaviors, boolean subPart) {
        this.name = name;
        this.serializedClass = serializedClass;
        this.returnClass = returnClass;
        this.behaviors = behaviors;
        this.replacements = new ArrayList<>();
        this.subPart = subPart;
    }

    protected Request(String name, Class<?> serializedClass, Class<T> returnClass, List<RequestBehavior> behaviors) {
        this.name = name;
        this.serializedClass = serializedClass;
        this.returnClass = returnClass;
        this.behaviors = behaviors;
        this.replacements = new ArrayList<>();
        this.subPart = false;
    }

    public T fetch(PronoteAPI api, String... parameters) throws IOException, RequestException {

        JsonObject fetch = api.fetch(buildQuery(parameters));
        String json = fetch.toString();

        if (subPart) {
            json = fetch.getAsJsonObject(name).toString();
        }

        for (Replacement replacement : this.replacements) {
            json = replacement.toApi(json);
        }

        return PronoteAPI.gson.fromJson(json, returnClass);
    }

    private String buildQuery(String[] parameters) {

        String build = new QueryBuilder()
                .value(name)
                .elements(serializedClass)
                .build();

        if (parameters.length != 0) {
            build = new QueryBuilder()
                    .function(name, buildParameters(parameters))
                    .elements(serializedClass)
                    .build();
        }

        for (Replacement replacement : this.replacements) {
            build = replacement.toServer(build);
        }

        return build;
    }

    private String[] buildParameters(String[] parameters) {

        int i = 0;
        int j = 0;
        String[] finalParameters = new String[parameters.length * 2];

        for (RequestBehavior behavior : behaviors) {

            String[] behaviorParameters = behavior.buildParameters(Arrays.copyOfRange(parameters, i, i + behavior.getParametersCount()));

            i += behavior.getParametersCount();

            System.out.println(Arrays.toString(behaviorParameters));
            for (String behaviorParameter : behaviorParameters) {

                if (behaviorParameter == null) {
                    continue;
                }

                finalParameters[j] = behaviorParameter;
                ++j;
            }

        }

        return finalParameters;
    }

}
