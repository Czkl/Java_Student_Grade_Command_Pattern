package com.tw.version2;

import java.io.Serializable;

public class Student2 implements Serializable {
    private String name;
    private String sno;
    private Score2 score;
    private String nation;
    private Integer kclass;


    public Student2(String name, String sno, String nation,Integer kclass) {
        this.name = name;
        this.sno = sno;
        this.nation = nation;
        this.kclass = kclass;
    }

    public Student2(String name, String sno) {
        this.name = name;
        this.sno = sno;
    }

    public Student2(String name, String sno, Score2 score) {
        this.name = name;
        this.sno = sno;
        this.score = score;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Integer getKclass() {
        return kclass;
    }

    public void setKclass(Integer kclass) {
        this.kclass = kclass;
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

    public Score2 getScore() {
        return score;
    }

    public void setScore(Score2 score) {
        this.score = score;
    }

    public float getAverage_score() {
        return  getTotal_score() / 4;
    }

    public int getTotal_score() {
        Score2 score2 = getScore();
        int total_score = score2.getMath() + score2.getLanguage() + score2.getEnglish() + score2.getProgramme();
        if (nation.equals("少数民族")) {
           return total_score + 10;
        }
        return total_score;
    }
}
