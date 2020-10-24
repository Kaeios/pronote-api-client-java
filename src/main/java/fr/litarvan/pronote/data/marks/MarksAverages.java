package fr.litarvan.pronote.data.marks;

import fr.litarvan.pronote.data.Data;

public class MarksAverages implements Data {

    private float student;
    private float studentClass;

    public MarksAverages() {
    }

    public MarksAverages(float student, float studentClass) {
        this.student = student;
        this.studentClass = studentClass;
    }

    public float getStudent() {
        return student;
    }

    public float getStudentClass() {
        return studentClass;
    }

}
