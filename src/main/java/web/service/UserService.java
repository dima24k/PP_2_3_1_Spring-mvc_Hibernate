package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    void newUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);
}
