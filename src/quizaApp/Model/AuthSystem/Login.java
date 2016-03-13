package quizaApp.Model.AuthSystem;

import quizaApp.Model.DBConnectModule.DBconnect;
import quizaApp.Model.quizKit.Professor;
import quizaApp.Model.quizKit.Student;
import quizaApp.Model.quizKit.User;

/**
 * Created by suryaduggi on 3/5/16.
 */
public class Login extends DBconnect {

	private String userName = "Surya";
	private String passCode = "Teja";
	private int id = 1234;
	private int privilage = 0;
	private DBconnect db;

	public Login() {
		db = new DBconnect();

	}

	public User validateData(String userName, String passCode) {
		User user = null;
		int privilage = db.validateUsers(userName, passCode);
		if (privilage == 0) {
			System.out.println(db.getUserID(userName,passCode));
			user = new Student(db.getUserID(userName,passCode), userName, privilage);
		} else if (privilage == 1) {
			System.out.println(db.getUserID(userName,passCode));
			user = new Professor(db.getUserID(userName, passCode), userName, privilage);
		}

		return user;
	}

}
