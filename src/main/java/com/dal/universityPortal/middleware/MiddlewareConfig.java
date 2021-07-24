package com.dal.universityPortal.middleware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class MiddlewareConfig implements WebMvcConfigurer {
    private final List<String> excludedPaths = Arrays.asList("/registration", "/login", "/logout", "/error/*", "/reset_password", "/reset_password/*");
    private final String universityAuthorizedOnlyPaths = "/university/add_staff";

    @Autowired
    AuthenticationMiddleware authenticationMiddleware;

    @Autowired
    AuthorizationMiddleware authorizationMiddleware;

    @Autowired
    UniversityAuthorizationMiddleware universityAuthorizationMiddleware;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationMiddleware).excludePathPatterns(excludedPaths);
        registry.addInterceptor(authorizationMiddleware).excludePathPatterns(excludedPaths);
        registry.addInterceptor(universityAuthorizationMiddleware).addPathPatterns(universityAuthorizedOnlyPaths);

    }
}
