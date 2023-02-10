package com.example.testapp.servlet;

import com.example.testapp.model.User;
import com.example.testapp.model.UserOperations;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userinfo")
public class UserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/userinfo.jsp").forward(req, resp);
        User user = UserOperations.getById(1);
        System.out.println("hey bitches my name is  "+ user.getName());
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

    }
}
