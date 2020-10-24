package fr.litarvan.pronote.data.contents;

import fr.litarvan.pronote.data.Data;
import fr.litarvan.pronote.data.FileUpload;

public class LessonContent implements Data {

    private String subject;
    private String[] teachers;
    private long from;
    private long to;
    private String color;
    private String title;
    private String description;
//    private String htmlDescription;
    private FileUpload[] files;
//    private String category;

    public String getSubject() {
        return subject;
    }

    public String[] getTeachers() {
        return teachers;
    }

    public long getFrom() {
        return from;
    }

    public long getTo() {
        return to;
    }

    public String getColor() {
        return color;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

//    public String getHtmlDescription() {
//        return htmlDescription;
//    }

    public FileUpload[] getFiles() {
        return files;
    }

//    public String getCategory() {
//        return category;
//    }

}
