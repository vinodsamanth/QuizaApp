package quizaApp.Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import quizaApp.Model.Professor;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class createquizController implements Initializable {

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
         System.out.println("This is submit");
	}
}
