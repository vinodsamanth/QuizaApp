package quizaApp.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import quizaApp.Model.DBconnect;
import quizaApp.Model.Professor;

public class ShowResultController {

	private final DBconnect db;
    private final Professor professor;
	public ShowResultController(Professor professor) {
		// TODO Auto-generated constructor stub
		this.professor = professor;
		db = new DBconnect();
	}


}
