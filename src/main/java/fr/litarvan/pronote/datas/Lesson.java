package fr.litarvan.pronote.datas;

public class Lesson
{
    private String subject;
    private String teacher;
    private String room;

    private long from;
    private long to;

    private boolean isAway;
    private boolean isCancelled;

    private String color;

    public Lesson()
    {
    }

    public Lesson(String subject, String teacher, String room, long from, long to, boolean away, boolean cancelled)
    {
        this.subject = subject;
        this.teacher = teacher;
        this.room = room;
        this.from = from;
        this.to = to;
        this.isAway = away;
        this.isCancelled = cancelled;
    }

    public String getSubject()
    {
        return subject;
    }

    public String getTeacher()
    {
        return teacher;
    }

    public String getRoom()
    {
        return room;
    }

    public long getFrom()
    {
        return from;
    }

    public long getTo()
    {
        return to;
    }

    public boolean isAway()
    {
        return isAway;
    }

    public boolean isCancelled()
    {
        return isCancelled;
    }

    public String getColor() {
        return color;
    }
}
