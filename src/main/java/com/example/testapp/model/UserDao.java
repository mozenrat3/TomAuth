package com.example.testapp.model;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getById(int id);

    User getUserByLoginPassword(String login, String password);

    String getUserByLogin(String login);

    Integer getUserById(Integer id);

    boolean deleteUserByLogin(String login);

    String getUserByEmail(String email);

    boolean add(User user);
}
