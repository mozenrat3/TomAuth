package com.example.testapp.service;

import com.example.testapp.dao.UserDao;
import com.example.testapp.dao.UserDaoImpl;
import com.example.testapp.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserServiceImpl(){
    }
    private static class SingletonHolder {
        public static final UserServiceImpl HOLDER_INSTANCE = new UserServiceImpl();
    }
    public static UserServiceImpl getInstance() {
        return UserServiceImpl.SingletonHolder.HOLDER_INSTANCE;
    }
    private final UserDaoImpl impl = UserDaoImpl.getInstance();

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
