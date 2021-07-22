package com.dal.universityPortal.middleware;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class MiddlewareConfig implements WebMvcConfigurer {
    private final List<String> excludedPaths = Arrays.asList("/registration", "/login", "/logout", "/loadPayment", "/savePayment");
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthenticationMiddleware()).excludePathPatterns(excludedPaths);
        registry.addInterceptor(new AuthorizationMiddleware()).excludePathPatterns(excludedPaths);
        registry.addInterceptor(new PaymentMiddleware()).excludePathPatterns(excludedPaths);
    }
}
