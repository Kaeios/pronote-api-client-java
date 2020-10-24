package fr.litarvan.pronote.data.absences;

import fr.litarvan.pronote.data.Data;

public class SubjectAbsence implements Data {

    private String subject;
    private float hoursAssisted;
    private float hoursMissed;
//    private SubjectAbsence[] subs;

    public String getSubject() {
        return subject;
    }

    public float getHoursAssisted() {
        return hoursAssisted;
    }

    public float getHoursMissed() {
        return hoursMissed;
    }

//    public SubjectAbsence[] getSubs() {
//        return subs;
//    }

}
