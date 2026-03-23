package com.kaustubh.botmakers.security;

import com.kaustubh.botmakers.util.Jwtutil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final Jwtutil jwtutil;

    private final CustomuserDetailService customuserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader!=null && authHeader.startsWith("Bearer ")){
            String token = authHeader.substring(7);

            if (jwtutil.validateToken(token)){
                String email = jwtutil.extractEmail(token);

                if (email!=null && SecurityContextHolder.getContext().getAuthentication()==null){
                    UserDetails userDetails = customuserDetailService.loadUserByUsername(email);

                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);


                }
            }
        }

        filterChain.doFilter(request,response);

    }
}
