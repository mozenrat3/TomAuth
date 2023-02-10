package com.example.testapp.model;

import java.util.ArrayList;
import java.util.List;

public class UserOperations {
    private static final List<User> store = new ArrayList<>();
  // private static final int count = store.size();
    public static   int getCount(){
        return  store.size();
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

    public boolean add(final User user) {

        for (User u : store) {
            if (u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword())) {
                return false;
            }
        }

        return store.add(user);
    }

//    public User.ROLE getRoleByLoginPassword(final String login, final String password) {
//        User.ROLE result = User.ROLE.UNAUTH;
//
//        for (User user : store) {
//            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
//                result = user.getRole();
//            }
//        }
//
//        return result;
//    }

    public boolean userIsExist(final String login, final String password) {

        boolean result = false;

        for (User user : store) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = true;
                break;
            }
        }

        return result;
    }
}
