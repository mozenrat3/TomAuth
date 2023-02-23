package com.example.testapp.model;

import java.util.ArrayList;
import java.util.List;

public  class UserOperations {
    private static final List<User> store = new ArrayList<>();

    // private static final int count = store.size();
    public static int getCount() {
        return store.size();
    }

    public static List<User> getAllUsers() {
        return store;
    }

    public static User getById(int id) {
        User result = new User();
        result.setId(-1);

        for (User user : store) {
            if (user.getId() == id) {
                result = user;
            }
        }

        return result;
    }

    public static User getUserByLoginPassword(final String login, final String password) {


        for (User user : store) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

    public static User getUserByLogin2(final String login) {


        for (User user : store) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }

        return null;
    }

    public static String getUserByLogin(final String login) {


        for (User user : store) {
            if (user.getLogin().equals(login)) {
                return user.getLogin();
            }
        }

        return null;
    }
    public static Integer getUserById(final Integer id) {


        for (User user : store) {
            if (user.getId()==id) {
                return user.getId();
            }
        }

        return null;
    }
    public static  boolean deleteUserByLogin(final String login) {
        for (User user : store) {
            if (user.getLogin().equals(login)) {

                return store.remove(user);
            }
        }
        return false;
    }

    //написать при удалении юзера,все за ним превращаются в null
    public static String getUserByEmail(final String email) {


        for (User user : store) {
            if (user.getEmail().equals(email)) {
                return user.getEmail();
            }
        }

        return null;
    }

    public boolean add(final User user) {

        for (User u : store) {
            if (u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword())) {
                return false;
            }
        }

        return store.add(user);
    }
}
