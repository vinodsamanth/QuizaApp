package quizaApp.Controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public abstract class ProfController implements Initializable {
 private Button CreateQuiz;
 private Button PostQuiz;
 private Button ViewResult;
 private Label ErrorMessage;
 public ProfController(Login login) {
		// TODO Auto-generated constructor stub
 	this.login = login;
	}
}
