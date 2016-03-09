package quizaApp.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Callback;
import quizaApp.Main;
import quizaApp.Model.DBconnect;
import quizaApp.Model.Option;
import quizaApp.Model.Question;
import quizaApp.Model.Quiz;
import quizaApp.Model.Student;

public class startquizController implements Initializable {
	
	final Student student;
	final Quiz quiz;
	final Question[] questions;
	private Option[] options;
	BooleanProperty isLast;
	int[] selected;
	int numCorrect;
	int min = 0;
	int sec = 0;
	ScheduledExecutorService bgthread;
	
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
	private Label timeLabel;
	@FXML
	private Button next;
	@FXML
	private Button finalSubmit;
	
	public int count;
	StringProperty timejfx = new SimpleStringProperty("");
	
	public startquizController(Student student, Quiz quiz) {
		// TODO Auto-generated constructor stub
		this.student = student;
		this.quiz = quiz;
		this.min = quiz.getTime();
		this.questions = quiz.getQuestions();
		this.selected = new int[quiz.getNoOfQuestions()];
		for(int i=0; i<selected.length ; i++){
			selected[i] = -1;
		}
		this.isLast = new SimpleBooleanProperty(true);
		this.numCorrect = 0;
		System.out.println("Printing Selected");
		for(int select : selected){
			System.out.println(select);
		}

		this.bgthread = Executors.newSingleThreadScheduledExecutor();

		this.bgthread.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {

				if(sec==0)
				{
					if(min==0){
						
						Platform.runLater(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								submitQuiz();
							}
						});
						bgthread.shutdown();
					}
					else
					{
						sec = 60;
						min--;
					}

				}
				else
				{
					sec--;
				}
				Platform.runLater(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						timejfx.set("Time: "+min+":"+sec);
					}
				});
				
			}

		}, 0, 1, TimeUnit.SECONDS);

	}
	
	@FXML
	public void nextQuestion(){
			if(rOne.isSelected()){
				selected[count] = 0;
				rOne.setSelected(false);
			}
			else if(rTwo.isSelected()){
				selected[count] = 1;
				rTwo.setSelected(false);
			}
			else if(rThree.isSelected()){
				selected[count] = 2;
				rThree.setSelected(false);
			}
			else if(rFour.isSelected()){
				selected[count] = 3;
				rFour.setSelected(false);
			}
		//System.out.println(selected[count]);
		count++;
		//System.out.println(count+ " : " + quiz.getNoOfQuestions());
		if(count == quiz.getNoOfQuestions()-1){
			isLast.set(false);
		}
		options = questions[count].getOptions();
		questionName.setText(questions[count].getQuestion());
		optionOne.setText(options[0].getOptionString());
		optionTwo.setText(options[1].getOptionString());
		optionThree.setText(options[2].getOptionString());
		optionFour.setText(options[3].getOptionString());
	}
	
	@FXML
	public void submitQuiz(){
			System.out.println("submit quiz");
			if(rOne.isSelected()){
				selected[count] = 0;
				rOne.setSelected(false);
			}
			else if(rTwo.isSelected()){
				selected[count] = 1;
				rTwo.setSelected(false);
			}
			else if(rThree.isSelected()){
				selected[count] = 2;
				rThree.setSelected(false);
			}
			else if(rFour.isSelected()){
				selected[count] = 3;
				rFour.setSelected(false);
			}
		System.out.println("Printing Result");
		for(int i = 0; i < quiz.getNoOfQuestions(); i++){
			options = questions[i].getOptions();
			
			//System.out.println(selected[i]+":"+options[selected[i]].getOptionString());
			if(selected[i] != -1 && options[selected[i]].isAnswer()){
				numCorrect++;
			}
		}
		System.out.println("numCorrect :"+numCorrect);
		DBconnect db = new DBconnect();
		System.out.println("Quiz ID : " + quiz.getqID());
		db.addResult(quiz.getqID(), student.getId(), numCorrect);
		System.out.println("After db update");
		
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Score Window");
		alert.setHeaderText(null);
		alert.setContentText("You scored "+numCorrect+"/"+quiz.getNoOfQuestions());

		alert.showAndWait();
		this.loadStudentController();
	}
	

	private void loadStudentController() {
		// TODO Auto-generated method stub
		final studentController StudentController = new studentController(student);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/quizaApp/view/Student.fxml"));
		loader.setControllerFactory(new Callback<Class<?>, Object>() {
			
			@Override
			public Object call(Class<?> arg0) {
				// TODO Auto-generated method stub
				return StudentController;
			}
		});
		TitledPane rootLayout = null;
		try {
			rootLayout = (TitledPane) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(rootLayout);
		Main.mainStage.setScene(scene);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		next.visibleProperty().bind(isLast);
		count = 0;
		options = questions[count].getOptions();
		questionName.setText(questions[count].getQuestion());
		optionOne.setText(options[0].getOptionString());
		optionTwo.setText(options[1].getOptionString());
		optionThree.setText(options[2].getOptionString());
		optionFour.setText(options[3].getOptionString());
		timeLabel.textProperty().bind(timejfx);
	}
	

}
