package com.example.testapp.web;

import com.example.testapp.service.ServiceFactory;
import com.example.testapp.model.User;
import com.example.testapp.service.UserService;

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

    private final UserService userService = ServiceFactory.getInstance().createUserService();

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
        User user = userService.findUserByLoginPassword(login, password);
        if (user == null) {
            req.setAttribute("error", "user is`nt exist, please enter your data correctly");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            disp.include(req, resp);
        } else {
            req.getSession().setAttribute("role", user.getRole());
            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("password", password);
            resp.sendRedirect(req.getContextPath() + "/welcome");
        }

    }

}