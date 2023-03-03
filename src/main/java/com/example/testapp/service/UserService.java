package com.example.testapp.service;

import com.example.testapp.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getById(int id);

    User getUserByLoginPassword(String login, String password);

    String getUserByLogin(String login);

    Integer getUserById(Integer id);

    boolean deleteUserByLogin(String login);

    String getUserByEmail(String email);

    boolean add(User user);
}
