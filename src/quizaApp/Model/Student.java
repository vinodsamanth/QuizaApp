package quizaApp.Model;

/**
 * Created by suryaduggi on 3/5/16.
 */
public class Student extends User {

    Student(int id,String name,int privilage)
    {
        this.setId(id);
        this.setName(name);
        this.setPrivilage(privilage);
    }
}
