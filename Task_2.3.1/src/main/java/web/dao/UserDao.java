package web.dao;

import web.model.User;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();
    public void saveUser(User user);

    public User getUser(long id);

    public void deleteUser(long id);

//    static List <User> users = new ArrayList<>();
//
//   public static void addUser(User user){users.add(user);};
//    List<User> getAllUsers();
}
