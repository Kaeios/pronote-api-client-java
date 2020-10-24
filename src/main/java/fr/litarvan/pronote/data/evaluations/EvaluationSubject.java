package fr.litarvan.pronote.data.evaluations;

import fr.litarvan.pronote.data.Data;

public class EvaluationSubject implements Data {

    private String name;
    private String teacher;
    private String color;
    private Evaluation[] evaluations;

    public String getName() {
        return name;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getColor() {
        return color;
    }

    public Evaluation[] getEvaluations() {
        return evaluations;
    }

}
