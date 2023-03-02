package com.example.testapp.model;

import java.util.ArrayList;
import java.util.List;

import static com.example.testapp.model.User.ROLE.ADMIN;
import static com.example.testapp.model.User.ROLE.USER;

public class UserDaoImpl implements UserDao {
   private final static List<User> store = new ArrayList<User>();
    @Override
    public List<User> getAllUsers() {
        return store;
    }

    @Override
    public User getById(int id) {
        User result = new User();
        result.setId(-1);

        for (User user : store) {
            if (user.getId() == id) {
                result = user;
            }
        }

        return result;
    }

    @Override
    public User getUserByLoginPassword(final String login, final String password) {


        for (User user : store) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public String getUserByLogin(final String login) {


        for (User user : store) {
            if (user.getLogin().equals(login)) {
                return user.getLogin();
            }
        }

        return null;
    }

    @Override
    public Integer getUserById(final Integer id) {


        for (User user : store) {
            if (user.getId() == id) {
                return user.getId();
            }
        }

        return null;
    }

        @Override
    public boolean deleteUserByLogin(final String login) {
        for (User user : store) {
            if (user.getLogin().equals(login)) {

                return store.remove(user);
            }
        }
        return false;
    }


    @Override
    public String getUserByEmail(final String email) {


        for (User user : store) {
            if (user.getEmail().equals(email)) {
                return user.getEmail();
            }
        }

        return null;
    }

    @Override
    public boolean add(final User user) {

        for (User u : store) {
            if (u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword())) {
                return false;
            }
        }

        return store.add(user);
    }
}
//    public UserDaoImpl() {
//        User user1 = new User(1, "hellologin1", "Parampam_3", "test1@mail.ru", "shev", "dima", "serg", "2002-01-06", ADMIN);
//        User user2 = new User(2, "hellologin2", "Parampam_3", "test2@mail.ru", "kovz", "vlad", "dmitr", "2010-06-01", USER);
//        User user3 = new User(3, "hellologin3", "Parampam_3", "test3@mail.ru", "tkach", "alex", "igor", "2000-01-11", USER);
//        User user4 = new User(4, "hellologin4", "Parampam_3", "test4@mail.ru", "kirov", "vadim", "alexe", "2000-12-07", USER);
//        User user5 = new User(5, "hellologin5", "Parampam_3", "test5@mail.ru", "glad", "vlad", "vadimov", "2000-10-26", USER);
//        User user6 = new User(6, "hellologin6", "Parampam_3", "test6@mail.ru", "nemc", "vlad", "ghgh", "2000-04-14", USER);
//        User user7 = new User(7, "hellologin7", "Parampam_3", "test7@mail.ru", "grech", "vitya", "ghhgh", "2000-12-28", USER);
//        store.add(user1);
//        store.add(user2);
//        store.add(user3);
//        store.add(user4);
//        store.add(user5);
//        store.add(user6);
//        store.add(user7);
//    }