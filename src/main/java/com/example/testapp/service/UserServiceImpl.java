package com.example.testapp.service;

import com.example.testapp.dao.UserDaoImpl;
import com.example.testapp.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoImpl impl = new UserDaoImpl();

    @Override
    public List<User> getAllUsers() {
        return impl.getAllUsers();
    }

    @Override
    public User getById(int id) {
        return impl.getById(id);
    }

    @Override
    public User getUserByLoginPassword(String login, String password) {
        return impl.getUserByLoginPassword(login, password);
    }

    @Override
    public String getUserByLogin(String login) {
        return impl.getUserByLogin(login);
    }

    @Override
    public Integer getUserById(Integer id) {
        return impl.getUserById(id);
    }

    @Override
    public boolean deleteUserByLogin(String login) {
        return impl.deleteUserByLogin(login);
    }

    @Override
    public String getUserByEmail(String email) {
        return impl.getUserByEmail(email);
    }

    @Override
    public boolean add(User user) {
        return impl.add(user);
    }
}
