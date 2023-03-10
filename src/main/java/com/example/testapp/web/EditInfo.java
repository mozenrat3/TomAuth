package com.example.testapp.web;

import com.example.testapp.model.User;
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
import java.util.Objects;

@WebServlet("/editinfo")
public class EditInfo extends HttpServlet {
    private final UserService userService = ServiceFactory.getInstance().createUserService();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/WEB-INF/jsp/editinfo.jsp";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        User user = userService.findById(Integer.parseInt(userId));
        int id = Integer.parseInt(userId);
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String newpassword = req.getParameter("newpassword");
        String confirmpassword = req.getParameter("confirmpassword");
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
        if ((userService.readUserByLogin(login) != null && !Objects.equals(user.getLogin(), login))) {
            req.setAttribute("error", "This is login exist in system");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/jsp/editinfo.jsp");
            disp.include(req,resp);
        }
        else if ((!newpassword.equals(confirmpassword))||(newpassword.equals(password))||(userService.readUserByEmail(email) != null && !Objects.equals(user.getEmail(), email))) {
            if((!newpassword.equals(confirmpassword))){
                req.setAttribute("error", "new password dont equal confirm password");
                RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/jsp/editinfo.jsp");
                disp.include(req,resp);
            } else if (newpassword.equals(password)) {
                req.setAttribute("error", "new password equal password");
                RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/jsp/editinfo.jsp");
                disp.include(req,resp);
            } else {
                req.setAttribute("error", "This is email exist in system");
                RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/jsp/editinfo.jsp");
                disp.include(req,resp);
            }

            }
            else {
            user.setPassword(newpassword);
            user.setLogin(login);
            user.setEmail(email);
            user.setBirthday(birthday);
            user.setName(name);
            user.setPatronymic(patronymic);
            user.setSurname(surname);
            user.setRole(role);
            resp.sendRedirect(req.getContextPath() + "/userinfo");
            }
        }
    }

