package quizaApp.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.util.Callback;
import quizaApp.Main;
import quizaApp.Model.Quiz;
import quizaApp.Model.Student;

public class showquizController implements Initializable {
	final Student student;
	final Quiz quiz;
	
	public showquizController(Student student, Quiz quiz) {
		// TODO Auto-generated constructor stub
		this.student = student;
		this.quiz = quiz;
		System.out.println("Show Quiz controlled QUizID : "+quiz.getqID());
	}
	@FXML
	public Label quizInfo;
	@FXML
	public Button start;
	
	@FXML
	public void startQuiz(){
		//System.out.println("Start Quiz");
		final startquizController startQuizController = new startquizController(student, quiz);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/quizaApp/view/StudentStartQuiz.fxml"));
		loader.setControllerFactory(new Callback<Class<?>, Object>() {
			
			@Override
			public Object call(Class<?> arg0) {
				// TODO Auto-generated method stub
				return startQuizController;
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
		//System.out.println(quiz.getqDescription());
		quizInfo.setText(quiz.getqDescription());
	}

}
