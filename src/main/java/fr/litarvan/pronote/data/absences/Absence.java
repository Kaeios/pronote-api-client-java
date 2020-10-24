package fr.litarvan.pronote.data.absences;

import fr.litarvan.pronote.data.Data;

public class Absence implements Data {

    private long from;
    private long to;
    private boolean justified;
    private boolean solved;
    private float hours;
    private String reason;

    public long getFrom() {
        return from;
    }

    public long getTo() {
        return to;
    }

    public boolean isJustified() {
        return justified;
    }

    public boolean isSolved() {
        return solved;
    }

    public float getHours() {
        return hours;
    }

    public String getReason() {
        return reason;
    }

}
