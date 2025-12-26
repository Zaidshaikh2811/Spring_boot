package com.child1.hospital.config;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Logging implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Request received at " + System.currentTimeMillis());
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Response sent at " + System.currentTimeMillis());
    }
}
