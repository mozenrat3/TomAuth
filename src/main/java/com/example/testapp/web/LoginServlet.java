package com.example.testapp.web;

import com.example.testapp.model.User;
import com.example.testapp.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/WEB-INF/jsp/login.jsp";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserServiceImpl impl = new UserServiceImpl();
        User user = impl.getUserByLoginPassword(login, password);
        if (user == null) {
                req.setAttribute("error", "user is`nt exist, please enter your data correctly");

           // RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            disp.include(req,resp);
           // dispatcher.forward(req, resp);
        } else {
            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("password", password);
            resp.sendRedirect(req.getContextPath() + "/welcome");
        }

    }

}