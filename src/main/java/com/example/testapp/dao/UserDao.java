package com.example.testapp.dao;

import com.example.testapp.model.User;

import java.util.List;

public interface UserDao {

    //CRUD
    //create read update delete findAll findBySalary findByLoginAndEmail readById

    List<User> findAllUsers();

    User findById(int id);

    User findUserByLoginPassword(String login, String password);

    String readUserByLogin(String login);

    Integer readUserById(Integer id);

    boolean deleteUserByLogin(String login);

    String readUserByEmail(String email);

    boolean add(User user);
}
