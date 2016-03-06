package quizaApp.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import quizaApp.Model.Option;
import quizaApp.Model.Question;
import quizaApp.Model.Quiz;
import quizaApp.Model.Student;

public class startquizController implements Initializable {
	
	final Student student;
	final Quiz quiz;
	final Question[] questions;
	private Option[] options;

	@FXML
	private Label questionName;
	@FXML
	private Label optionOne;
	@FXML
	private Label optionTwo;
	@FXML
	private Label optionThree;
	@FXML
	private Label optionFour;
	
	@FXML
	private RadioButton rOne;
	@FXML
	private RadioButton rTwo;
	@FXML
	private RadioButton rThree;
	@FXML
	private RadioButton rFour;
	@FXML
	private Button previous;
	@FXML
	private Button next;
	@FXML
	private Button end;
	@FXML
	private Button finalSubmit;
	
	public startquizController(Student student, Quiz quiz) {
		// TODO Auto-generated constructor stub
		this.student = student;
		this.quiz = quiz;
		this.questions = quiz.getQuestions();
	}
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		options = questions[0].getOptions();
		questionName.setText(questions[0].getQuestion());
		optionOne.setText(options[0].getOptionString());
		optionTwo.setText(options[1].getOptionString());
		optionThree.setText(options[2].getOptionString());
		optionFour.setText(options[3].getOptionString());
	}
	

}
