package com.dal.universityPortal.middleware;

import com.dal.universityPortal.model.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AuthorizationMiddleware implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        boolean isAuthorized = user.getTypeEnum().isRouteAllowed(request.getRequestURI());
        if (isAuthorized) {
            return true;
        }
        response.sendRedirect("/error/unauthorized");
        return false;
    }
}
