package quizaApp.Model;

/**
 * Created by suryaduggi on 3/5/16.
 */
public class Quiz {
    private int qID;
    private int qName;
    private int noOfQuestions;
    private long time;
    private long timeFrame;
    private Question[] questions;

    // Start of getter setter
    public int getqID() {
        return qID;
    }

    public void setqID(int qID) {
        this.qID = qID;
    }

    public int getqName() {
        return qName;
    }

    public void setqName(int qName) {
        this.qName = qName;
    }

    public int getNoOfQuestions() {
        return noOfQuestions;
    }

    public void setNoOfQuestions(int noOfQuestions) {
        this.noOfQuestions = noOfQuestions;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(long timeFrame) {
        this.timeFrame = timeFrame;
    }

    public Question[] getQuestions() {
        return questions;
    }
//     End of getter and setter
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
