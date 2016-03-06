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
	
	public int validateUsers(String userName, String passWord){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, user, password);
			this.statement = connection.prepareStatement("select `privilage` from `quizaapp`.`users` where `user_name` = ? and `password` = ?");
			statement.setObject(1, userName);
			statement.setObject(2, passWord);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				System.out.println(resultSet.getString(1));
			}
		}catch(SQLException | ClassNotFoundException e){
			Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
		}finally{
			try {
				if(resultSet != null)
					resultSet.close();
				if(statement != null)
					statement.close();
				if(connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.WARNING, e.getMessage(), e);
			}
		}
		return -1;
	}
	
	public String[] returnListQuiz(){
		String[] resultString = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, user, password);
			this.statement = connection.prepareStatement("select quiz_name from quiz");
			resultSet = statement.executeQuery();
			resultSet.last();
			int numRows = resultSet.getRow();
			resultSet.first();
			resultString = new String[numRows];
			int i = 0;
			while(resultSet.next()){
				resultString[i] = resultSet.getString(1);
				i++;
			}
		}catch(SQLException | ClassNotFoundException e){
			Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
		}finally{
			try {
				if(resultSet != null)
					resultSet.close();
				if(statement != null)
					statement.close();
				if(connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.WARNING, e.getMessage(), e);
			}
		}
		return resultString;
	}
	
	
	public static void main(String []arg){
		DBconnect db = new DBconnect();
		db.validateUsers("Surya", "Teja");
	}
}
