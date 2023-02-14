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
import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

@WebServlet("/userdelete")
public class UserDelete extends HttpServlet {
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
        if (!login.equals(req.getSession().getAttribute("login"))) {
            UserOperations.deleteUserByLogin(login);
            resp.sendRedirect(req.getContextPath() + "/userinfo");
        } else {
//                resp.setContentType("text/html;charset=UTF-8");
//                PrintWriter out = resp.getWriter();
//                out.println("<script language = 'javascript'> alert ('Is this current user!') </ script>");
            resp.sendRedirect(req.getContextPath() + "/userdelete");
        }
        // resp.sendRedirect(req.getContextPath() + "/userinfo");
    }
}
