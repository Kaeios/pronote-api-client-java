package fr.litarvan.pronote.data.contents;

import fr.litarvan.pronote.data.Data;

import java.util.List;

public class Contents implements Data {

    private List<LessonContent> contents;

    public List<LessonContent> getContents() {
        return contents;
    }

}
