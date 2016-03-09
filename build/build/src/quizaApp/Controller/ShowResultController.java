package quizaApp.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import quizaApp.Main;
import quizaApp.Model.DBconnect;
import quizaApp.Model.Professor;

public class ShowResultController implements Initializable {

	private final DBconnect db;
    private final Professor professor;
    
    private ObservableList<CheckMenuItem> list = FXCollections.observableArrayList();
    
	public ShowResultController(Professor professor) {
		// TODO Auto-generated constructor stub
		this.professor = professor;
		db = new DBconnect();
	}

	@FXML
	private Button showResult;
	@FXML
	private ComboBox<String> resultSelection;
	
	String selectedOption;

	@FXML
	public void showResult(){
		System.out.println("Show Result");
		final GraphResultShowController graphResultShowController = new GraphResultShowController(selectedOption,professor);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/quizaApp/view/GraphResultShow.fxml"));
		loader.setControllerFactory(new Callback<Class<?>, Object>() {
			
			@Override
			public Object call(Class<?> arg0) {
				// TODO Auto-generated method stub
				return graphResultShowController;
			}
		});
		AnchorPane rootLayout = null;
		try {
			rootLayout = (AnchorPane) loader.load();
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
		
		DBconnect db = new DBconnect();
		String[] quizList = db.returnListQuiz();
		/*for(int i = 0; i < quizList.length; i++){
			list.add(new CheckMenuItem(quizList[i]));
		}*/
		resultSelection.getItems().addAll(quizList);
		
		resultSelection.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
	            @Override
	            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
	                selectedOption = newValue.toString();
	            }
	        });
		
	}

}
