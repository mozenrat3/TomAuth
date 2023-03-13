package com.example.testapp.service;

import com.example.testapp.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    User findById(int id);

    User findUserByLoginPassword(String login, String password);

    String readUserByLogin(String login);

    Integer readUserById(Integer id);

    boolean deleteUserByLogin(String login);

    String readUserByEmail(String email);

    boolean add(User user);
}
