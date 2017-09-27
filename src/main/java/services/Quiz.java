package services;

import java.util.Arrays;
import java.util.Date;

public class Quiz {
    private String id;
    private String name;
    private Date startTime;
    private Question[] questions;
    private int score;
    private String nickname = "";

    public Quiz(){

    }

    public int getScore() {
        return score;
    }

    public void incScore(int score) {
        this.score += score;
    }

    public void cleanScore(){score = 0;}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                ", questions=" + Arrays.toString(questions) +
                '}';
    }
}
