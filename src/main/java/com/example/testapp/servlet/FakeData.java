package com.example.testapp.servlet;

import com.example.testapp.model.User;
import com.example.testapp.model.UserOperations;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.atomic.AtomicReference;

import static com.example.testapp.model.User.ROLE.ADMIN;
import static com.example.testapp.model.User.ROLE.USER;

@WebListener
public class FakeData implements ServletContextListener {
    private AtomicReference<UserOperations> info;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        info = new AtomicReference<>(new UserOperations());

        info.get().add(new User(1, "1", "1", "test", "sh","dima","serg","2000, Month.NOVEMBER, 20", USER));

        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        servletContext.setAttribute("info", info);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        info = null;
    }
}
