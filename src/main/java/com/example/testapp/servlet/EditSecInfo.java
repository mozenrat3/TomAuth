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

@WebServlet("/editsecondaryinfo")
public class EditSecInfo extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/WEB-INF/jsp/editsecondaryinfo.jsp";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        User user = UserOperations.getById(Integer.parseInt(userId));
        int id = Integer.parseInt(userId);
        String email = req.getParameter("email");
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String patronymic = req.getParameter("patronymic");
        String birthday = req.getParameter("birthday");
        User.ROLE role;
        if (req.getParameter("role1") != null) {
            role = User.ROLE.valueOf("USER");
        } else {
            role = User.ROLE.valueOf("ADMIN");
        }
        PrintWriter out = resp.getWriter();

        if ((UserOperations.getUserByEmail(email) != null && !Objects.equals(user.getEmail(), email))) {
            out.println("u entered login, that exists in system,please choose a new login");
            resp.sendRedirect(req.getContextPath() + "/" + "editsecondaryinfo?userId=" + id);
        } else {
            user.setEmail(email);
            user.setBirthday(birthday);
            user.setName(name);
            user.setPatronymic(patronymic);
            user.setSurname(surname);
            user.setRole(role);
//            UserOperations userOperations = new UserOperations();
//            userOperations.add(user);
            resp.sendRedirect(req.getContextPath() + "/userinfo");
        }
        // Пишем проверки на несовпадение логинов, емэйлов как-то делаем авто добавляемый id,или на несовпадение их
        //Потом еще добавить id в юзер инфо и чекнуть, что будет если нового юзера добавить
        //User.ROLE role = User.ROLE.valueOf(req.getParameter("role"));

        //  req.getSession().setAttribute("user", user);
    }
}