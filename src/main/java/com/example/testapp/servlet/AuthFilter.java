

package com.example.testapp.servlet;

import com.example.testapp.model.User;
import com.example.testapp.model.UserOperations;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import static com.example.testapp.model.SearchVariables.*;
import static java.util.Objects.nonNull;

@WebFilter({"/login","/welcome"})
public class AuthFilter implements Filter {
    public AuthFilter() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain)

            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse resp = (HttpServletResponse) response;

        final String login = req.getParameter("login");

        final String password = req.getParameter("password");

        @SuppressWarnings("unchecked") final AtomicReference<UserOperations> info = (AtomicReference<UserOperations>) req.getServletContext().getAttribute("info");

        final HttpSession session = req.getSession();
        String servletPath = req.getServletPath();
        if (nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("password"))) {
            //  System.out.println("non null session");
            final User.ROLE role = (User.ROLE) session.getAttribute("role");

            moveToMainPage(req, resp, role);


        } else if (info.get().userIsExist(login, password)) {

            final User.ROLE role = info.get().getRoleByLoginPassword(login, password);
            // System.out.println("null session");
            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("role", role);

            moveToMainPage(req, resp, role);

        } else {
            //    System.out.println("nonauth");
            moveToMainPage(req, resp, User.ROLE.UNAUTH);
        }
    }

    private void moveToMainPage(final HttpServletRequest req,
                                final HttpServletResponse resp,
                                final User.ROLE role)
            throws ServletException, IOException {


        if (role.equals(User.ROLE.ADMIN) || role.equals(User.ROLE.USER)) {
            req.getRequestDispatcher(JSP_PATH + WELCOME_PAGE + ".jsp").forward(req, resp);
            //      resp.sendRedirect(req.getContextPath() + "/welcome");
        } else {

            // resp.sendRedirect(req.getContextPath()+"/login");
            req.getRequestDispatcher(JSP_PATH + LOGIN_PAGE + ".jsp").forward(req, resp);
        }


    }
    @Override
   public void init(FilterConfig fConfig)throws ServletException{

   }
}



