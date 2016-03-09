package quizaApp.Model;

/**
 * Created by suryaduggi on 3/5/16.
 */
public class Option {
	private int option_id;
    private String optionString;
    private boolean answer;

    public Option(int option_id, String option, boolean is_true) {
		// TODO Auto-generated constructor stub
    	this.option_id = option_id;
    	this.optionString = option;
    	this.answer = is_true;
	}

    public Option(String option, boolean is_true) {
        // TODO Auto-generated constructor stub
        this.optionString = option;
        this.answer = is_true;
    }

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
