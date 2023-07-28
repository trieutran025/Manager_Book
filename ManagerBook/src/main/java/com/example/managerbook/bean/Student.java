package com.example.managerbook.bean;

public class Student {
    private int idStudent ;
    private String codeStudent ;
    private String nameStudent;
    private String classStudent;

    public Student(int idStudent, String codeStudent, String nameStudent, String classStudent) {
        this.idStudent = idStudent;
        this.codeStudent = codeStudent;
        this.nameStudent = nameStudent;
        this.classStudent = classStudent;
    }

    public Student() {
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(String codeStudent) {
        this.codeStudent = codeStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(String classStudent) {
        this.classStudent = classStudent;
    }
}
