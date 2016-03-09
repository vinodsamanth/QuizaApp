package quizaApp.Controller;

import java.io.IOException;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.util.Callback;
import quizaApp.Main;
import quizaApp.Model.Professor;

//import javafx.fxml.Initializable;
/*import javafx.scene.control.Button;
import javafx.scene.control.Label;*/

public class ProfController {
	final Professor professor;
 @FXML
 private Button CreateQuiz;
 @FXML
 private Button PostQuiz;
 @FXML
 private Button ViewResult;
 @FXML
 private Label profUsername;

 //private Label ErrorMessage;
 public ProfController(Professor professor) {
	this.professor=professor;
	 // TODO Auto-generated constructor stub
	}

 @FXML
 protected void Createquiz(){
	 final createquizController createquizController = new createquizController(professor);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/quizaApp/view/profCreatequiz.fxml"));
		loader.setControllerFactory(new Callback<Class<?>, Object>() {
			
			@Override
			public Object call(Class<?> arg0) {
				// TODO Auto-generated method stub
				return createquizController;
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
 @FXML protected void ViewResult(){
	 final ShowResultController ShowResultController = new ShowResultController(professor);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/quizaApp/view/ProfViewResult.fxml"));
		loader.setControllerFactory(new Callback<Class<?>, Object>() {
			
			@Override
			public Object call(Class<?> arg0) {
				// TODO Auto-generated method stub
				return ShowResultController;
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
 @FXML protected void Postquiz(){
	 final postController postController = new postController(professor);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/quizaApp/view/ProfessorPost.fxml"));
		loader.setControllerFactory(new Callback<Class<?>, Object>() {
			
			@Override
			public Object call(Class<?> arg0) {
				// TODO Auto-generated method stub
				return postController;
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

	public void Viewresult(Event event) {



	}
}


