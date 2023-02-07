package com.example.testapp.servlet;

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

//        final HttpSession session = req.getSession();
//        final String state = (String) session.getAttribute("state");
//        if (state != null) {
//            req.setAttribute("dataForView", session.getAttribute("state"));
//        }
        String path = "/WEB-INF/jsp/login.jsp";

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
        //req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);

    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
////        final String login = req.getParameter("auth_login");
////        final String password = req.getParameter("auth_pass");
////        final HttpSession session = req.getSession();
////        final String currentState = (String) session.getAttribute("state");
////        if (currentState != null) {
////            //Update old state value to new.
////            session.setAttribute("state", currentState + " : " + login);
////            session.setAttribute("state", currentState + " : " + password);
////        } else {
////            //Init state value.
////            session.setAttribute("state", login);
////            session.setAttribute("state", password);
////        }
////        doGet(req, resp);
//
////        String login = req.getParameter("login");
////        req.setAttribute("login",login);
//
//
//       req.getRequestDispatcher(JSP_PATH + WELCOME_PAGE + ".jsp").forward(req, resp);
//
//
//    }

    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
    }
}