package com.dal.universityPortal.middleware;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import static java.util.Objects.isNull;

@Service
public class PaymentMiddleware implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        HttpSession session = request.getSession();
        if (isNull(session.getAttribute("user"))) {
            response.sendRedirect("/loadPayment");
            return false;
        }
        return true;
    }
}
