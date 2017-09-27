package services;

public class Alternative {
    private String text;
    private boolean correct;

    public Alternative(){

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String isCorrect() {
        return correct ? "Correct" : "Wrong";
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Override
    public String toString() {
        return "Alternative{" +
                "text='" + text + '\'' +
                ", correct=" + correct +
                '}';
    }
}
