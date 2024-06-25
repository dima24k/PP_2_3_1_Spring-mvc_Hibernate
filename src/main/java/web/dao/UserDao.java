package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    User getUser(Long id);

    List<User> getAll();

    void newUser(User user);

    void updateUser(User user,Long id);

    void deleteUser(Long id);
}
