package com.example.testapp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession session = req.getSession();
        session.invalidate();
//        session.removeAttribute("login");
//        session.removeAttribute("password");
//        session.removeAttribute("role");
        resp.sendRedirect(super.getServletContext().getContextPath());
      //  resp.sendRedirect(req.getContextPath() + "/login" + ".jhtml");
    }

}