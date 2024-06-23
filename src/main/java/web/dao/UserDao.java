package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAll();

    void newUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);
}
