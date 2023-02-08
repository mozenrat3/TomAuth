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

@WebServlet("/loginedit")
public class EditServlet extends HttpServlet {
    //Hello
    //Hi
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = "/WEB-INF/jsp/loginedit.jsp";

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
        //req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //   String login = (String) req.getSession().getAttribute(user.);
        String login = req.getParameter("login");
        String password = req.getParameter("newpassword");
        String login2 = (String) req.getSession().getAttribute("login");
        String password2 = (String) req.getSession().getAttribute("password");
        User user = UserOperations.getUserByLoginPassword(login2, password2);
        if (login2.equals(login)) {
            user.setPassword(password);
            req.getSession().setAttribute("password", password);
            req.getRequestDispatcher("/WEB-INF/jsp/loginedit.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }

    }

}
