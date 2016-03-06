package quizaApp.Model;

/**
 * Created by suryaduggi on 3/5/16.
 */
public class Login extends DBconnect {

    private String userName = "Surya";
    private String passCode = "Teja";
    private int id = 1234;
    private int privilage = 0;
    private int preference = 0;

    public User validateData(String userName, String passCode)
    {
        User user;
        if(userName==this.userName && passCode==this.passCode && preference == 0) {
            user = new Student(id,userName, preference);
        }
        else {
            user = new Professor(id,userName,preference);
        }
        return user;
    }
}
