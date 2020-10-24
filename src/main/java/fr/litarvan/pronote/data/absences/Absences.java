package fr.litarvan.pronote.data.absences;

import fr.litarvan.pronote.data.Data;

public class Absences implements Data {

    private Absence[] absences;
    private Delay[] delays;
    private Punishment[] punishments;
    private OtherEvent[] other;
    private SubjectAbsence[] totals;

    public Absence[] getAbsences() {
        return absences;
    }

    public Delay[] getDelays() {
        return delays;
    }

    public Punishment[] getPunishments() {
        return punishments;
    }

    public OtherEvent[] getOther() {
        return other;
    }

    public SubjectAbsence[] getTotals() {
        return totals;
    }

}
