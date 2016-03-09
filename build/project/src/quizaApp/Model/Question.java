package quizaApp.Model;

/**
 * Created by suryaduggi on 3/5/16.
 */
public class Question {
    private int qId;
    private String question;
    private Option[] options;

    public Question(int questionID, String question) {
		// TODO Auto-generated constructor stub
    	this.qId = questionID;
    	this.question = question;
	}

    public Question(String question,Option[] options) {
        // TODO Auto-generated constructor stub
        this.options = options;
        this.question = question;
    }

	public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getqId() {
        return qId;
    }

    public void setqId(int qId) {
        this.qId = qId;
    }

    public Option[] getOptions() {
        return options;
    }

    public void setOptions(Option[] options) {
        this.options = options;
    }

    public void submitAnswer() {

    }

}
