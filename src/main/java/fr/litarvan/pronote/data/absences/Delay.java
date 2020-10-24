package fr.litarvan.pronote.data.absences;

import fr.litarvan.pronote.data.Data;

public class Delay implements Data {

    private long date;
    private boolean justified;
    private boolean solved;
    private String justification;
    private int minutesMissed;
    private String reason;

    public long getDate() {
        return date;
    }

    public boolean isJustified() {
        return justified;
    }

    public boolean isSolved() {
        return solved;
    }

    public String getJustification() {
        return justification;
    }

    public int getMinutesMissed() {
        return minutesMissed;
    }

    public String getReason() {
        return reason;
    }

}
