package quizaApp.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuButton;
import quizaApp.Model.Professor;

public class postController implements Initializable {
	private ObservableList<CheckMenuItem> selectlist = FXCollections.observableArrayList();
	public postController(Professor professor) {
		// TODO Auto-generated constructor stub
	}
	@FXML
	public Button post;
	@FXML
	public MenuButton selectQuiz;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		String[] SelectList = {"value1","value2","value3","value4","value5"};
		for(int i = 0; i < 5; i++){
			selectlist.add(new CheckMenuItem(SelectList[i]));
		}
		selectQuiz.getItems().addAll(selectlist);
	}
	

}
