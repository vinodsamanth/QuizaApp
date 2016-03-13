package quizaApp.UserInterface;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import quizaApp.Main;
import quizaApp.Model.quizKit.Professor;
import quizaApp.Model.quizKit.Quiz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class createquizController implements Initializable {
	
	private final Professor professor;

	@FXML
	public TextField quizName;
	@FXML
	public ComboBox questionCombo;
	@FXML
	public ComboBox timeCombo;
	@FXML
	public TextArea descriptionLabel;

	public int timeInt = 0;
	public int questionInt = 0;

	public createquizController(Professor professor) {
		this.professor = professor;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		questionCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				questionInt = Integer.parseInt(newValue.toString());
			}
		});

		timeCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				timeInt = Integer.parseInt(newValue.toString());
			}
		});

	}

	public void sumbitQuiz()
	{
		Quiz proceedQuiz = new Quiz(quizName.getText(),questionInt,timeInt,descriptionLabel.getText());
		final questionsPrepController questionPrep = new questionsPrepController(proceedQuiz,professor);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/quizaApp/view/questionsPrep.fxml"));
		loader.setControllerFactory(new Callback<Class<?>, Object>() {

			@Override
			public Object call(Class<?> arg0) {
				// TODO Auto-generated method stub
				return questionPrep;
			}
		});
		
		AnchorPane rootLayout= null;
		
		try {
			rootLayout = (AnchorPane) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(rootLayout);
		Main.mainStage.setScene(scene);
	}
}
