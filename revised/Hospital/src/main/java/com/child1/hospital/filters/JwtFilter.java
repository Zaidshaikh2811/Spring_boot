package com.child1.hospital.filters;


import com.child1.hospital.utils.JWTUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JWTUtil jwtUtil;
    private final UserDetailsService userDetailsService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String jwt = authHeader.substring(7);

            try{
               String username= jwtUtil.validateTokenAndGetUsername(jwt);

               if(SecurityContextHolder.getContext().getAuthentication() == null){
                   System.out.println("Valid JWT Token for user: " + username);
                   UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                   if (!jwtUtil.validateToken(jwt, userDetails)) {
                       response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                       response.getWriter().write("Invalid or expired JWT");
                       return;
                   }
                   UsernamePasswordAuthenticationToken authToken =
                           new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                   authToken.setDetails(
                           new WebAuthenticationDetailsSource()
                           .buildDetails(request)
                   );

                   SecurityContextHolder.getContext().setAuthentication(authToken);

               }

            }
            catch (Exception e){
                System.out.println("Invalid JWT Token: " + e.getMessage());
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().println("Invalid JWT Token");
                return;
            } 
        }
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getServletPath();
        return path.startsWith("/api/v1/auth");
    }
}
