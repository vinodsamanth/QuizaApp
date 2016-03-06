package quizaApp.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.corba.se.impl.util.Version;

public class DBconnect {

	public Connection connection;
	public PreparedStatement statement;
	public ResultSet resultSet;
	private String url;
	private String user;
	private String password;

	public DBconnect() {
		// TODO Auto-generated constructor stub
		this.url = "jdbc:mysql://localhost:3306/quizaapp";
		this.user = "root";
		this.password = "password";
	}

	public int validateUsers(String userName, String passWord) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, user, password);
			this.statement = connection
					.prepareStatement("select `privilage` from `quizaapp`.`users` where `user_name` = ? and `password` = ?");
			statement.setObject(1, userName);
			statement.setObject(2, passWord);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}
		} catch (SQLException | ClassNotFoundException e) {
			Logger lgr = Logger.getLogger(Version.class.getName());
			lgr.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				Logger lgr = Logger.getLogger(Version.class.getName());
				lgr.log(Level.WARNING, e.getMessage(), e);
			}
		}
		return -1;
	}

	public String[] returnListQuiz() {
		String[] resultString = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, user, password);
			this.statement = connection
					.prepareStatement("select quiz_name from quiz");
			resultSet = statement.executeQuery();
			resultSet.last();
			int numRows = resultSet.getRow();
			System.out.println(numRows);
			resultSet.beforeFirst();
			resultString = new String[numRows];
			int i = 0;
			while (resultSet.next()) {
				resultString[i] = resultSet.getString(1);
				i++;
			}
		} catch (SQLException | ClassNotFoundException e) {
			Logger lgr = Logger.getLogger(Version.class.getName());
			lgr.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				Logger lgr = Logger.getLogger(Version.class.getName());
				lgr.log(Level.WARNING, e.getMessage(), e);
			}
		}
		return resultString;
	}

	public void creatQuiz(String quiz_name, int no_of_questions, int time,
			String time_frame, String quiz_description) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, user, password);
			this.statement = connection
					.prepareStatement("INSERT INTO `quizaapp`.`quiz`(`quiz_name`,`no_of_questions`,`time`,`time_frame`,`quiz_description`) VALUES ( ? , ? , ? , ? , ?)");
			statement.setString(1, quiz_name);
			statement.setInt(2, no_of_questions);
			statement.setInt(3, time);
			statement.setString(4, time_frame);
			statement.setString(5, quiz_description);
			statement.execute();
		} catch (SQLException | ClassNotFoundException e) {
			Logger lgr = Logger.getLogger(Version.class.getName());
			lgr.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				Logger lgr = Logger.getLogger(Version.class.getName());
				lgr.log(Level.WARNING, e.getMessage(), e);
			}
		}
	}

	public Question[] returnQuestionList(int quiz_id) {
		Question[] questionList = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, user, password);
			this.statement = connection
					.prepareStatement("select * from questions where quiz_id = ?");
			statement.setObject(1, quiz_id);
			resultSet = statement.executeQuery();
			resultSet.last();
			int numRows = resultSet.getRow();
			System.out.println(numRows);
			resultSet.beforeFirst();
			questionList = new Question[numRows];
			int i = 0;
			while (resultSet.next()) {
				int questionID = resultSet.getInt(1);
				String question = resultSet.getString(2);
				questionList[i] = new Question(questionID, question);
				i++;
			}
		} catch (SQLException | ClassNotFoundException e) {
			Logger lgr = Logger.getLogger(Version.class.getName());
			lgr.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				Logger lgr = Logger.getLogger(Version.class.getName());
				lgr.log(Level.WARNING, e.getMessage(), e);
			}
		}
		/*
		 * for(Question question : questionList)
		 * System.out.println(question.getQuestion());
		 */
		return questionList;
	}

	public void createQuestion(Question question, int quiz_id) {
		int question_id = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, user, password);
			this.statement = connection
					.prepareStatement("INSERT INTO `quizaapp`.`questions`(`question`,`quiz_id`) VALUES ( ? , ? )");
			statement.setString(1, question.getQuestion());
			statement.setInt(2, quiz_id);
			statement.execute();
			this.statement = connection.prepareStatement("Select question_id from `quizaapp`.`questions` where `question` = ? ");
			statement.setString(1, question.getQuestion());
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				question_id = resultSet.getInt(1);
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			Logger lgr = Logger.getLogger(Version.class.getName());
			lgr.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				Logger lgr = Logger.getLogger(Version.class.getName());
				lgr.log(Level.WARNING, e.getMessage(), e);
			}
		}
		for(Option option : question.getOptions()){
			this.createOption(option, question_id);
		}
	}

	public Option[] returnOptions(int question_id) {
		Option[] optionList = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, user, password);
			this.statement = connection
					.prepareStatement("select * from options where question_id = ?");
			statement.setObject(1, question_id);
			resultSet = statement.executeQuery();
			resultSet.last();
			int numRows = resultSet.getRow();
			System.out.println(numRows);
			resultSet.beforeFirst();
			optionList = new Option[numRows];
			int i = 0;
			while (resultSet.next()) {
				int option_id = resultSet.getInt(1);
				String option = resultSet.getString(2);
				boolean is_true = resultSet.getBoolean(4);
				optionList[i] = new Option(option_id, option, is_true);
				i++;
			}
		} catch (SQLException | ClassNotFoundException e) {
			Logger lgr = Logger.getLogger(Version.class.getName());
			lgr.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				Logger lgr = Logger.getLogger(Version.class.getName());
				lgr.log(Level.WARNING, e.getMessage(), e);
			}
		}
		/*
		 * for(Option question : optionList)
		 * System.out.println(question.getOptionString());
		 */
		return optionList;
	}

	public void createOption(Option option, int question_id){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, user, password);
			this.statement = connection.prepareStatement("INSERT INTO `quizaapp`.`options`(`option`,`question_id`,`is_true`) VALUES ( ? , ? , ?)");
			statement.setString(1, option.getOptionString());
			statement.setInt(2, question_id);
			statement.setBoolean(2, option.isAnswer());
			statement.execute();
		} catch (SQLException | ClassNotFoundException e) {
			Logger lgr = Logger.getLogger(Version.class.getName());
			lgr.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				Logger lgr = Logger.getLogger(Version.class.getName());
				lgr.log(Level.WARNING, e.getMessage(), e);
			}
		}
	}
	
	public static void main(String[] arg) {
		DBconnect db = new DBconnect();
		//db.createQuestion("What day is it today" , 4);
	}
}
