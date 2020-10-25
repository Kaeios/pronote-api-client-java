package fr.litarvan.pronote.request;

import com.google.gson.JsonObject;
import fr.litarvan.pronote.PronoteAPI;
import fr.litarvan.pronote.request.parameters.ParameterizedRequest;
import fr.litarvan.pronote.server.request.RequestException;

import java.io.IOException;
import java.util.*;

public abstract class Request<T> {

    private final String name;
    private final Class<?> serializedClass;
    private final Class<T> returnClass;
    private final List<ParameterizedRequest> requestParameters;
    private final List<Replacement> replacements;
    private final boolean subPart;

    public Request(RequestBuilder<T> builder) {
        this.name = builder.getName();
        this.serializedClass = builder.getSerializedClass();
        this.returnClass = builder.getReturnClass();
        this.requestParameters = builder.getRequestParameters();
        this.replacements = builder.getReplacements();
        this.subPart = builder.needSubPart();
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

        requestParameters.sort(Comparator.comparingInt(ParameterizedRequest::getPriority));

        for (ParameterizedRequest behavior : requestParameters) {

            String[] behaviorParameters = behavior.buildParameters(Arrays.copyOfRange(parameters, i, i + behavior.getParametersCount()));

            i += behavior.getParametersCount();

            for (String behaviorParameter : behaviorParameters) {

                if (behaviorParameter == null || j >= finalParameters.length) {
                    continue;
                }

                finalParameters[j] = behaviorParameter;
                ++j;
            }

        }

        return finalParameters;
    }

}
