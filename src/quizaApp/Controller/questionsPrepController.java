package quizaApp.Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.util.Callback;
import quizaApp.Main;
import quizaApp.Model.DBconnect;
import quizaApp.Model.Option;
import quizaApp.Model.Professor;
import quizaApp.Model.Question;
import quizaApp.Model.Quiz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by suryaduggi on 3/6/16.
 */
public class questionsPrepController implements Initializable {
     private final Quiz proceedQuiz;
     private final Professor professor;
     private int qcount = 1;
     private DBconnect db;

    @FXML
    private Label questionLabel;
    @FXML
    private TextArea questionTextArea;
    @FXML
    private TextField optionOne;
    @FXML
    private TextField optionTwo;
    @FXML
    private TextField optionThree;
    @FXML
    private TextField optionFour;
    @FXML
    private ComboBox correctAnsCombo;
    @FXML
    private int correctans;
    private Question[] questions;

    public questionsPrepController(Quiz proceedQuiz, Professor professor) {
         this.proceedQuiz = proceedQuiz;
         this.professor = professor;
         questions=new Question[proceedQuiz.getNoOfQuestions()];
         db = new DBconnect();
    }

    public void SaveAndContinue()
    {
        qcount++;
        Option[] optArray = new Option[4];
        Question question;
        if(proceedQuiz.getNoOfQuestions()<qcount)
        {
            optArray[0] = new Option(optionOne.getText(),false);
            optArray[1] = new Option(optionTwo.getText(),false);
            optArray[2] = new Option(optionThree.getText(),false);
            optArray[3] = new Option(optionFour.getText(),false);
            optArray[correctans-1].setAnswer(true);
            question = new Question(questionTextArea.getText(),optArray);
            questions[qcount-2]=question;
            System.out.println(qcount);
            proceedQuiz.setQuestions(questions);
            // need to save and process to other menu or window
            db.creatQuiz(proceedQuiz);
            this.loadProfController();
        }
        else
        {
            optArray[0] = new Option(optionOne.getText(),false);
            optArray[1] = new Option(optionTwo.getText(),false);
            optArray[2] = new Option(optionThree.getText(),false);
            optArray[3] = new Option(optionFour.getText(),false);
            optArray[correctans-1].setAnswer(true);
            question = new Question(questionTextArea.getText(),optArray);
            questions[qcount-2]=question;

        }
        questionLabel.setText("Question "+qcount);
        questionTextArea.clear();
        optionOne.clear();
        optionTwo.clear();
        optionThree.clear();
        optionFour.clear();
        
        

    }

    private void loadProfController() {
		// TODO Auto-generated method stub
    	final ProfController ProfController = new ProfController(professor);
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

	@Override
    public void initialize(URL location, ResourceBundle resources) {

        correctAnsCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                correctans = Integer.parseInt(newValue.toString());
            }
        });
    }
}
