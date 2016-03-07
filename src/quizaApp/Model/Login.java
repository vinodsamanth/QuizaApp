package quizaApp.Model;

/**
 * Created by suryaduggi on 3/5/16.
 */
public class Login extends DBconnect {

	private String userName = "Surya";
	private String passCode = "Teja";
	private int id = 1234;
	private int privilage = 0;
	private DBconnect db;

	Login() {
		db = new DBconnect();

	}

	public User validateData(String userName, String passCode) {
		User user = null;
		int privilage = db.validateUsers(userName, passCode);
		if (privilage == 0) {
			user = new Student(id, userName, privilage);
		} else if (privilage == 1) {
			user = new Professor(id, userName, privilage);
		}

		return user;
	}

}
