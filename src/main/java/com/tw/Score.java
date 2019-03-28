package com.tw;

public class Score {

    private int math;
    private int language;
    private int english;
    private int programme;

    private float average_score;
    private int total_score;

    public Score() {
    }

    public Score(int math, int language, int english, int programme) {
        this.math = math;
        this.language = language;
        this.english = english;
        this.programme = programme;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getProgramme() {
        return programme;
    }

    public void setProgramme(int programme) {
        this.programme = programme;
    }

    public float getAverage_score() {
        average_score = getTotal_score() / 4;
        return average_score;
    }

    public int getTotal_score() {
        total_score = math + language + english + programme;
        return total_score;
    }


}
