package fr.litarvan.pronote.request;

import fr.litarvan.pronote.request.parameters.ParameterizedRequest;

import java.util.ArrayList;
import java.util.List;

public class RequestBuilder<T> {

    private String name;
    private Class<?> serializedClass;
    private Class<T> returnClass;
    private List<ParameterizedRequest> requestParameters = new ArrayList<>();
    private List<Replacement> replacements = new ArrayList<>();
    private boolean subPart = false;

    public RequestBuilder<T> withName(String name) {
        this.name = name;
        return this;
    }

    public RequestBuilder<T> withSerializedClass(Class<?> serializedClass) {
        this.serializedClass = serializedClass;
        return this;
    }

    public RequestBuilder<T> withReturnClass(Class<T> returnClass) {
        this.returnClass = returnClass;
        return this;
    }

    public RequestBuilder<T> withRequestParameters(List<ParameterizedRequest> requestParameters) {
        this.requestParameters = requestParameters;
        return this;
    }

    public RequestBuilder<T> addRequestParameters(ParameterizedRequest requestParameters) {
        this.requestParameters.add(requestParameters);
        return this;
    }

    public RequestBuilder<T> withReplacements(List<Replacement> replacements) {
        this.replacements = replacements;
        return this;
    }

    public RequestBuilder<T> addReplacements(Replacement replacement) {
        this.replacements.add(replacement);
        return this;
    }

    public RequestBuilder<T> needSubPart(boolean subPart) {
        this.subPart = subPart;
        return this;
    }

    public String getName() {
        return name;
    }

    public Class<?> getSerializedClass() {
        return serializedClass;
    }

    public Class<T> getReturnClass() {
        return returnClass;
    }

    public List<ParameterizedRequest> getRequestParameters() {
        return requestParameters;
    }

    public List<Replacement> getReplacements() {
        return replacements;
    }

    public boolean needSubPart() {
        return subPart;
    }

}
