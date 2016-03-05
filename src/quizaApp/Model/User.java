package quizaApp.Model;

/**
 * Created by suryaduggi on 3/5/16.
 */
public abstract class User {
    private int id;
    private String name;
    private int privilage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrivilage() {
        return privilage;
    }

    public void setPrivilage(int privilage) {
        this.privilage = privilage;
    }
}
