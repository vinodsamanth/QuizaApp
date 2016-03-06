package quizaApp.Model;

/**
 * Created by suryaduggi on 3/5/16.
 */
public class Option {
    private String optionString;
    private boolean answer;

    public String getOptionString() {
        return optionString;
    }

    public void setOptionString(String optionString) {
        this.optionString = optionString;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
