package com.example.testapp.servlet;

import com.example.testapp.model.User;
import com.example.testapp.model.UserDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/useradd")
public class UserAdd extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/WEB-INF/jsp/useradd.jsp";

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String patronymic = req.getParameter("patronymic");
        String birthday = req.getParameter("birthday");
        User.ROLE role;
        UserDaoImpl impl = new UserDaoImpl();
        if (req.getParameter("role1") != null) {
            role = User.ROLE.valueOf("USER");
        } else {
            role = User.ROLE.valueOf("ADMIN");
        }

        if (impl.getUserByLogin(login) != null && impl.getUserByEmail(email) != null) {
            req.setAttribute("error", "u entered email and login, that exists in system,please choose a new email and login");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/jsp/useradd.jsp");
            disp.include(req, resp);
        } else if (impl.getUserByEmail(email) != null) {
            req.setAttribute("error", "u entered email, that exists in system,please choose a new email");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/jsp/useradd.jsp");
            disp.include(req, resp);

        } else if (impl.getUserByLogin(login) != null) {
            req.setAttribute("error", "u entered login, that exists in system,please choose a new login");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/jsp/useradd.jsp");
            disp.include(req, resp);
        } else if (impl.getUserById(id) != null) {
            req.setAttribute("error", "u entered id, that exists in system,please choose a new id");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/jsp/useradd.jsp");
            disp.include(req, resp);
        } else {
            User user = new User(id, login, password, email, surname, name, patronymic, birthday, role);
            impl.add(user);
            resp.sendRedirect(req.getContextPath() + "/userinfo");
        }


        // Пишем проверки на несовпадение логинов, емэйлов как-то делаем авто добавляемый id,или на несовпадение их
        //Потом еще добавить id в юзер инфо и чекнуть, что будет если нового юзера добавить
        //User.ROLE role = User.ROLE.valueOf(req.getParameter("role"));

        //  req.getSession().setAttribute("user", user);
    }
}
