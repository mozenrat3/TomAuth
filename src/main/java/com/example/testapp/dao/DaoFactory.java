package com.example.testapp.dao;

public class DaoFactory {

    private final static DaoFactory INSTANCE = new DaoFactory();
    private DaoFactory(){
    }
    public static DaoFactory getInstance() {
        return INSTANCE;
    }

    public UserDao createUserDao(){
        return UserDaoImpl.getInstance();
    }

}
