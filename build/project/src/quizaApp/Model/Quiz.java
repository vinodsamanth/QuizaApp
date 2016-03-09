package quizaApp.Model;

/**
 * Created by suryaduggi on 3/5/16.
 */
public class Quiz {
    private int qID;
    private String qDescription;
    private String qName;
    private int noOfQuestions;
    private int time;
    private String timeFrame;
    private Question[] questions;
    private int qcount = 0;

    public Quiz(int quiz_id, String name, int noquestions, int time, String time_frame, String quiz_description, boolean is_taken){
    	this.qID = quiz_id;
        this.qName = name;
        this.noOfQuestions = noquestions;
        this.time = time;
        this.timeFrame = time_frame;
        this.qDescription = quiz_description;
        questions = new Question[noquestions];
    }

    public Quiz(String name, int noquestions, int time, String qDescription){
        this.qName = name;
        this.noOfQuestions = noquestions;
        this.time = time;
        this.qDescription = qDescription;
        questions = new Question[noquestions];
    }



    public String getqDescription() {
        return qDescription;
    }

    public void setqDescription(String qDescription) {
        this.qDescription = qDescription;
    }

    public int getqID() {
        return qID;
    }

    public void setqID(int qID) {
        this.qID = qID;
    }

    public String getqName() {
        return qName;
    }

    public void setqName(String qName) {
        this.qName = qName;
    }

    public int getNoOfQuestions() {
        return noOfQuestions;
    }

    public void setNoOfQuestions(int noOfQuestions) {
        this.noOfQuestions = noOfQuestions;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(String timeFrame) {
        this.timeFrame = timeFrame;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }

    public void startQuiz() {
        //Need some implementation
    }

    public void endQuiz() {

    }

    public void openQuiz() {

    }

    public void submitAnswers() {

    }

    public boolean isTaken() {

        return false;
    }

    public void showResult() {

        }


}
