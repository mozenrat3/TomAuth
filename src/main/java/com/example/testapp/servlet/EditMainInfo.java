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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/editmaininfo")
public class EditMainInfo extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/WEB-INF/jsp/editmaininfo.jsp";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        User user = UserOperations.getById(Integer.parseInt(userId));
        int id = Integer.parseInt(userId);
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String newpassword = req.getParameter("newpassword");
        String confirmpassword = req.getParameter("confirmpassword");

        PrintWriter out = resp.getWriter();

        if ((UserOperations.getUserByLogin(login) != null && !Objects.equals(user.getLogin(), login))) {
            out.println("u entered login, that exists in system,please choose a new login");
            resp.sendRedirect(req.getContextPath() + "/" + "editmaininfo?userId=" + id);
        } else {
            if (newpassword.equals(confirmpassword) && !newpassword.equals(password)) {
                user.setPassword(newpassword);
                user.setLogin(login);
                resp.sendRedirect(req.getContextPath() + "/userinfo");
            }
            else {
                resp.sendRedirect(req.getContextPath() + "/" + "editmaininfo?userId=" + id);
            }
        }
        // Пишем проверки на несовпадение логинов, емэйлов как-то делаем авто добавляемый id,или на несовпадение их
        //Потом еще добавить id в юзер инфо и чекнуть, что будет если нового юзера добавить
        //User.ROLE role = User.ROLE.valueOf(req.getParameter("role"));

        //  req.getSession().setAttribute("user", user);
    }
}
