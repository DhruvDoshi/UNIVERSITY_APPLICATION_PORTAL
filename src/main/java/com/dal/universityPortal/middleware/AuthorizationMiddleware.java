package com.dal.universityPortal.middleware;

import com.dal.universityPortal.model.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AuthorizationMiddleware implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        return user.getTypeEnum().isRouteAllowed(request.getRequestURI());
    }
}
