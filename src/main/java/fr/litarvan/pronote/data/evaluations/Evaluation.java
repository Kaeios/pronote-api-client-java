package fr.litarvan.pronote.data.evaluations;

import fr.litarvan.pronote.data.Data;

public class Evaluation implements Data {

    private String id;
    private String name;
    private long date;
    private float coefficient;
    private EvaluationLevel[] levels;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getDate() {
        return date;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public EvaluationLevel[] getLevels() {
        return levels;
    }

}
