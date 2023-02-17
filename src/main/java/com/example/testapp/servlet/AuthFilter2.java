package com.example.testapp.servlet;
import com.example.testapp.model.User;
import com.example.testapp.model.UserOperations;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter(value = "/*",filterName = "authfilter")
public class AuthFilter2 implements Filter {
    static List<String>  userUrls = List.of("/login", "/welcome","/logout","/css/login.css");
    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    }
    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain)

            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse resp = (HttpServletResponse) response;
        String servletPath = req.getServletPath();
        final HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (req.getAttribute("executeSecondFilter") == null || !((Boolean) req.getAttribute("executeSecondFilter"))) {

           filterChain.doFilter(req, resp);
        }
        else {
            if(!userUrls.contains(servletPath)){
                if(user.getRole() == User.ROLE.USER){

                    resp.sendRedirect(req.getContextPath()+"/welcome");
                }
                else {
                    filterChain.doFilter(req,resp);
                }
            }
            else {
                filterChain.doFilter(req,resp);
            }
        }

    }
    @Override
    public void destroy() {
    }

}





