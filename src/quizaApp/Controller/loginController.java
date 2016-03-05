package quizaApp.Controller;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
//import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import quizaApp.Main;


public abstract class loginController implements Initializable {
	private TextField username;
	private PasswordField password;
    private Button Login;
    private Label errorMessage;
    

    public loginController(Login login) {
		// TODO Auto-generated constructor stub
    	this.login = login;
	}

	@FXML protected void processLogin() {
		
		Object user = login.validateUser(username.getText(), password.getText());
		
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
        		AnchorPane rootLayout = (AnchorPane) loader.load();
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
        		AnchorPane rootLayout = (AnchorPane) loader.load();
        		Scene scene = new Scene(rootLayout);
        		Main.mainStage.setScene(scene);
        	}
        	
        }
    }
	@Override public void initialize(URL url, ResourceBundle rb) {
        username.setPromptText("username");
        password.setPromptText("password");
}
}

