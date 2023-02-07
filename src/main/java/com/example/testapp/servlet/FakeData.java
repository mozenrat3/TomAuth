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

        info.get().add(new User(1, "DimaAdm", "1", ADMIN));
        info.get().add(new User(2, "DimaUser1", "2", USER));
        info.get().add(new User(3, "DimaUser2", "3", USER));
        info.get().add(new User(4, "1", "1", USER));

        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        servletContext.setAttribute("info", info);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        info = null;
    }
}
