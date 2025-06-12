package com.pramodvaddiraju.jobpulse.security;

import com.pramodvaddiraju.jobpulse.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public JwtAuthFilter(JwtUtil jwtUtil, UserRepository userRepository) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        // Step 1: Read the Authorization header
        String authHeader = request.getHeader("Authorization");

        String token = null;
        String userEmail = null;

        // Step 2: Extract token and email
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7); // remove "Bearer "
            userEmail = jwtUtil.getEmailFromToken(token);
        }

        // Step 3: Validate token and set authentication
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (jwtUtil.isTokenValid(token)) {
                // Token is valid, set authentication manually
                var user = userRepository.findByEmail(userEmail).get();

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                user.getEmail(), null, null); // No roles yet

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Set authenticated user in the context
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        // Step 4: Continue filter chain
        filterChain.doFilter(request, response);
    }
}
