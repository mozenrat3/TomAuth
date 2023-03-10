package com.example.testapp.web;
import com.example.testapp.service.ServiceFactory;
import com.example.testapp.service.UserService;
import com.example.testapp.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userdelete")
public class UserDelete extends HttpServlet {
    private final UserService userService = ServiceFactory.getInstance().createUserService();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/WEB-INF/jsp/userdelete.jsp";

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");

        if(userService.getUserByLogin(login) == null){
            req.setAttribute("error", "This user does`nt exist");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/jsp/userdelete.jsp");
            disp.include(req,resp);
        } else if (login.equals(req.getSession().getAttribute("login"))) {
            req.setAttribute("error", "Is this the current user, u can`t delete yourself");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/jsp/userdelete.jsp");
            disp.include(req,resp);
        }
        else{
            userService.deleteUserByLogin(login);
            resp.sendRedirect(req.getContextPath() + "/userinfo");
        }

    }
}
