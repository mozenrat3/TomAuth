package com.example.testapp.dao;

import com.example.testapp.model.User;

import java.util.List;

public interface UserDao {

    //CRUD
    //create read update delete findAll findBySalary findByLoginAndEmail readById

    List<User> getAllUsers();

    User getById(int id);

    User getUserByLoginPassword(String login, String password);

    String getUserByLogin(String login);

    Integer getUserById(Integer id);

    boolean deleteUserByLogin(String login);

    String getUserByEmail(String email);

    boolean add(User user);
}
