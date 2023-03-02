package com.example.testapp.servlet;

import com.example.testapp.model.User;
import com.example.testapp.model.UserDaoImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.atomic.AtomicReference;

import static com.example.testapp.model.User.ROLE.ADMIN;
import static com.example.testapp.model.User.ROLE.USER;

@WebListener
public class FakeData implements ServletContextListener {
    private AtomicReference<UserDaoImpl> info;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        info = new AtomicReference<>(new UserDaoImpl());

        info.get().add(new User(1, "hellologin1", "Parampam_3", "test1@mail.ru", "shev", "dima", "serg", "2002-01-06", ADMIN));
        info.get().add(new User(2, "hellologin2", "Parampam_3", "test2@mail.ru", "kovz", "vlad", "dmitr", "2010-06-01", USER));
        info.get().add(new User(3, "hellologin3", "Parampam_3", "test3@mail.ru", "tkach", "alex", "igor", "2000-01-11", USER));
        info.get().add(new User(4, "hellologin4", "Parampam_3", "test4@mail.ru", "kirov", "vadim", "alexe", "2000-12-07", USER));
        info.get().add(new User(5, "hellologin5", "Parampam_3", "test5@mail.ru", "glad", "vlad", "vadimov", "2000-10-26", USER));
        info.get().add(new User(6, "hellologin6", "Parampam_3", "test6@mail.ru", "nemc", "vlad", "ghgh", "2000-04-14", USER));
        info.get().add(new User(7, "hellologin7", "Parampam_3", "test7@mail.ru", "grech", "vitya", "ghhgh", "2000-12-28", USER));
        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        servletContext.setAttribute("info", info);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        info = null;
    }
}
