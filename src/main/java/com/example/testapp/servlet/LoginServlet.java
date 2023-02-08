package com.example.testapp.servlet;

import com.example.testapp.model.User;
import com.example.testapp.model.UserOperations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static com.example.testapp.model.SearchVariables.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    //Hello
    //Hi
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = "/WEB-INF/jsp/login.jsp";

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
        //req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = UserOperations.getUserByLoginPassword(login, password);
        if (user == null) {
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(req, resp);
        } else {
            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("password", password);
            resp.sendRedirect(req.getContextPath() + "/welcome");
        }

    }

}