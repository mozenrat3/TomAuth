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
        String password = req.getParameter("password");
        String newpassword = req.getParameter("newpassword");
        String confirmpassword = req.getParameter("comfirmpassword");
        String seslogin = (String) req.getSession().getAttribute("login");
        String sespassword = (String) req.getSession().getAttribute("password");
        UserServiceImpl impl = new UserServiceImpl();
        User user = impl.getUserByLoginPassword(seslogin, sespassword);
        if (seslogin.equals(login) && sespassword.equals(password)) {
            if (newpassword.equals(confirmpassword)) {
                user.setPassword(newpassword);
                req.getSession().setAttribute("password", newpassword);
                req.getRequestDispatcher("/WEB-INF/jsp/loginedit.jsp").forward(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/loginedit");
            }

        } else {
            resp.sendRedirect(req.getContextPath() + "/loginedit");
        }

    }

}
