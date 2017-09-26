package services;

import java.util.Arrays;

public class Question {
    private String question;
    private String imageURL;
    private Alternative[] alternatives;
    private int secondsLeft;

    public int getSecondsLeft() {
        return secondsLeft;
    }

    public void setSecondsLeft(int secondsLeft) {
        this.secondsLeft = secondsLeft;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Alternative[] getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(Alternative[] alternatives) {
        this.alternatives = alternatives;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", alternatives=" + Arrays.toString(alternatives) +
                ", secondsLeft=" + secondsLeft +
                '}';
    }
}
