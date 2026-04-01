package com.example.notes.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Component
public class RequestValidationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().equals("/api/csrf-token")) {
            filterChain.doFilter(request, response);
            return;
        }
        String header = request.getHeader("X-Valid-Request");
        if(header == null || !header.equals("true")){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Inavlid request");
        return ;
        }
        filterChain.doFilter(request, response);
    }
}
