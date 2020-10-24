package fr.litarvan.pronote.data.absences;

import fr.litarvan.pronote.data.Data;

public class Punishment implements Data {

    private long date;
    private boolean isExclusion;
    private boolean isDuringLesson;
    private String homework;
    private String circumstances;
    private String giver;
    private String reason;
    private Detention detention;

    public long getDate() {
        return date;
    }

    public boolean isExclusion() {
        return isExclusion;
    }

    public boolean isDuringLesson() {
        return isDuringLesson;
    }

    public String getHomework() {
        return homework;
    }

    public String getCircumstances() {
        return circumstances;
    }

    public String getGiver() {
        return giver;
    }

    public String getReason() {
        return reason;
    }

    public Detention getDetention() {
        return detention;
    }

}
