package quizaApp;
	
//import application.Main;
import quizaApp.Controller.loginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	

	final QuizaApp quizaApp = QuizaApp();
	public static Stage mainStage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			mainStage = primaryStage;
			
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/quizaApp/Controller/login.fxml"));
			loader.setControllerFactory(new javafx.util.Callback<Class<?>, Object>() {
				
				@Override
				public Object call(Class<?> param) {
					return new loginController(quizaApp.login);
					
				}
			});
			BorderPane root = (BorderPane) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setTitle("Login Page");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
