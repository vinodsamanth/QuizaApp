package quizaApp.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
//import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;
import javafx.util.Callback;
import quizaApp.Main;
import quizaApp.Model.DBconnect;
import quizaApp.Model.Quiz;
import quizaApp.Model.Student;
//import quizaApp.Model.User;

public class studentController implements Initializable{
	
	private ObservableList<CheckMenuItem> list = FXCollections.observableArrayList();
	
	final Student student;
	@FXML
	private Label studentUsername;
	@FXML
	private Button takeQuiz;

	@FXML
	private MenuButton listQuiz;
	
	

	public studentController(Student student) {
		// TODO Auto-generated constructor stub
		this.student = student;
	}
	@FXML protected void Takequiz(){
		DBconnect db = new DBconnect();
		String quiz_name = null;
		for(MenuItem item : listQuiz.getItems()) {
            CheckMenuItem checkMenuItem = (CheckMenuItem) item;
            if(checkMenuItem.isSelected()) {
                quiz_name = checkMenuItem.getText();
                System.out.println(checkMenuItem.getText());
            }
        }
		if(quiz_name == null)
			return;
		Quiz quiz = db.returnQuiz(quiz_name);
//		System.out.println("StudentController quiz_id: "+quiz.getqID());
		final showquizController showQuizController = new showquizController(student , quiz);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/quizaApp/view/Studentshowquiz.fxml"));
		loader.setControllerFactory(new Callback<Class<?>, Object>() {
			
			@Override
			public Object call(Class<?> arg0) {
				// TODO Auto-generated method stub
				return showQuizController;
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
		studentUsername.setText("Welcome "+student.getName());
		
		
		//Query database and add String quizList[]
//		String[] quizList = {"value1","value2","value3","value4","value5"};
		DBconnect db = new DBconnect();
		String[] quizList = db.returnListQuiz();
		for(int i = 0; i < quizList.length; i++){
			list.add(new CheckMenuItem(quizList[i]));
		}
		listQuiz.getItems().addAll(list);
	}

}
