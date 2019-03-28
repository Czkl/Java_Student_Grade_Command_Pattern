package com.tw;

public class Student {
    private String name;
    private String sno;
    private Score score;

    public Student(String name, String sno) {
        this.name = name;
        this.sno = sno;
    }

    public Student(String name, String sno, Score score) {
        this.name = name;
        this.sno = sno;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

}
