package fr.litarvan.pronote.data.evaluations;

import fr.litarvan.pronote.data.Data;

public class EvaluationLevel implements Data {

    private String name;
    private EvaluationLevelValue value;
    private String prefixes;

    public String getName() {
        return name;
    }

    public EvaluationLevelValue getValue() {
        return value;
    }

    public String getPrefixes() {
        return prefixes;
    }

}
