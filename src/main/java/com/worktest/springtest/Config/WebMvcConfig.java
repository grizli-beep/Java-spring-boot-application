package com.worktest.springtest.Config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.Enumeration;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurationSupport {

    public static class CorsInterceptor implements HandlerInterceptor {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
            response.addHeader("Access-Control-Allow-Credentials", "true");
            response.addHeader("Access-Control-Allow-Origin", "*");
            if (HttpMethod.OPTIONS.matches(request.getMethod())) {
                Enumeration<String> accessControlAllowHeaders = request.getHeaders("Access-Control-Request-Headers");
                if (accessControlAllowHeaders != null) {
                    while (accessControlAllowHeaders.hasMoreElements()) {
                        String accessControlHeader = accessControlAllowHeaders.nextElement();
                        response.addHeader("Access-Control-Allow-Headers", accessControlHeader);
                    }
                }
                Enumeration<String> accessControlRequestMethod = request.getHeaders("Access-Control-Request-Method");
                if (accessControlRequestMethod != null) {
                    while (accessControlRequestMethod.hasMoreElements()) {
                        String accessControlMethod = accessControlRequestMethod.nextElement();
                        response.addHeader("Access-Control-Allow-Methods", accessControlMethod);
                    }
                }
            }
            return true;
        }
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        CorsInterceptor corsInterceptor = new CorsInterceptor();
        registry.addInterceptor(corsInterceptor);
    }
}