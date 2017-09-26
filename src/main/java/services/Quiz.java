package services;

import java.util.Arrays;
import java.util.Date;

public class Quiz {
    private String id;
    private String name;
    private Date startTime;
    private Question[] questions;
    private int score;

    public Quiz(){

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

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

    public String getDemBoys(){
        String out = "";
        for(int i = 0; i < questions.length; i++){
            out += questions[i].toString() + "\n";
        }
        return out;
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
