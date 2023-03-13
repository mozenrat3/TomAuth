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
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public User findUserByLoginPassword(String login, String password) {
        return userDao.findUserByLoginPassword(login, password);
    }

    @Override
    public String readUserByLogin(String login) {
        return userDao.readUserByLogin(login);
    }

    @Override
    public Integer readUserById(Integer id) {
        return userDao.readUserById(id);
    }

    @Override
    public boolean deleteUserByLogin(String login) {
        return userDao.deleteUserByLogin(login);
    }

    @Override
    public String readUserByEmail(String email) {
        return userDao.readUserByEmail(email);
    }

    @Override
    public boolean add(User user) {
        return userDao.add(user);
    }
}
