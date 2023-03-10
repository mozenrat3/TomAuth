package com.example.testapp.service;

import com.example.testapp.dao.DaoFactory;
import com.example.testapp.dao.UserDao;
import com.example.testapp.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = DaoFactory.getInstance().createUserDao();
    private UserServiceImpl(){
    }
    private static class SingletonHolder {
        public static final UserServiceImpl HOLDER_INSTANCE = new UserServiceImpl();
    }
    public static UserServiceImpl getInstance() {
        return UserServiceImpl.SingletonHolder.HOLDER_INSTANCE;
    }
   // private final UserDaoImpl impl = UserDaoImpl.getInstance();

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public User getUserByLoginPassword(String login, String password) {
        return userDao.getUserByLoginPassword(login, password);
    }

    @Override
    public String getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    @Override
    public Integer getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public boolean deleteUserByLogin(String login) {
        return userDao.deleteUserByLogin(login);
    }

    @Override
    public String getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public boolean add(User user) {
        return userDao.add(user);
    }
}
