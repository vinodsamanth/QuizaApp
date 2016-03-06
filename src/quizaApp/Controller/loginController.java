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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import quizaApp.Main;
import quizaApp.Model.Login;
import quizaApp.Model.Student;
import quizaApp.Model.User;

public abstract class loginController implements Initializable {
	@FXML
	private TextField userName;
	@FXML
	private PasswordField passWord;
	@FXML
	private Button loginButton;
	@FXML
	private Label errorMessage;
    
    final Login login;
    

    public loginController(Login login) {
		// TODO Auto-generated constructor stub
    	this.login = login;
	}

	@FXML protected void processLogin() {
		
		
		System.out.println("Login");
		if(userName.getText().equals("") || passWord.getText().equals(""))
			return;
		User user = login.validateData(userName.getText(), passWord.getText());
		
        if(user == null){
            errorMessage.setText("Username/password combination is invalid.");
        }
        else{
        	if(user instanceof Student){
        		final studentController StudentController = new studentController(user);
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
        	else{
        		final ProfController ProfController = new ProfController(user);
        		FXMLLoader loader = new FXMLLoader();
        		loader.setLocation(Main.class.getResource("/quizaApp/view/Prof.fxml"));
        		loader.setControllerFactory(new Callback<Class<?>, Object>() {
					
					@Override
					public Object call(Class<?> arg0) {
						// TODO Auto-generated method stub
						return ProfController;
					}
				});
        		TitledPane rootLayout= null;
				try {
					rootLayout = (TitledPane) loader.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		Scene scene = new Scene(rootLayout);
        		Main.mainStage.setScene(scene);
        	}
        	
        }
    }
	@Override public void initialize(URL url, ResourceBundle rb) {
        userName.setPromptText("username");
        passWord.setPromptText("password");
}
}

