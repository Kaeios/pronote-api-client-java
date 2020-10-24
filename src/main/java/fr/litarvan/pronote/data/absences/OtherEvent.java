package fr.litarvan.pronote.data.absences;

import fr.litarvan.pronote.data.Data;

public class OtherEvent implements Data {

    private String kind;
    private long date;
    private String giver;
    private String comment;
    private String subject;

    public String getKind() {
        return kind;
    }

    public long getDate() {
        return date;
    }

    public String getGiver() {
        return giver;
    }

    public String getComment() {
        return comment;
    }

    public String getSubject() {
        return subject;
    }

}
