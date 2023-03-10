package com.example.testapp.service;

public class ServiceFactory {

    private final static ServiceFactory INSTANCE = new ServiceFactory();
    private ServiceFactory(){}

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public UserService createUserService(){
        return UserServiceImpl.getInstance();
    }
}
