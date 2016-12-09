package models.users;

/**
 * Created by wdd on 09/12/16.
 */

import  java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.validation.*;

public class User extends Model {
    @Id
    private String email;

    @Constraints.Required
    private String role;

    @Constraints.Required
    private String name;

    @Constraints.Required
    private String password;

    public User(){
    }

    private static Finder<String, User> find = new Finder<String, User>(User.class);

    public static List<User> findAll(){
        return User.getFind().all();
    }

    public static User authenticate(String email, String password) {
        return find.where().eq("email", email).eq("password", password).findUnique();

    }

    public static Finder<String, User> getFind() {
        return find;
    }

    public static void setFind(Finder<String, User> find) {
        User.find = find;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
