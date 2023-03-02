

package com.example.testapp.servlet;

import com.example.testapp.model.User;
import com.example.testapp.model.UserDaoImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import static com.example.testapp.model.SearchVariables.*;
import static java.lang.Boolean.TRUE;
import static java.util.Objects.nonNull;

@WebFilter(value = "/*", filterName = "startfilter")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        ServletContext context = fConfig.getServletContext();

        context.getFilterRegistration("startfilter");
         context.getFilterRegistration("authfilter");
    }


    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain)
            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse resp = (HttpServletResponse) response;
        req.setAttribute("executeSecondFilter", true);
        String servletPath = req.getServletPath();
        final HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(servletPath.equals("/index.jsp")){
            req.setAttribute("executeSecondFilter", false);
            // filterChain.doFilter(request, response);
        }
        if (servletPath.equals("/login") || user != null || servletPath.contains("css")) {
            filterChain.doFilter(request, response);
        }else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }

    }

    @Override
    public void destroy() {

    }
}





