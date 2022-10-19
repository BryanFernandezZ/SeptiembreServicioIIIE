package com.idat.SetiembreIIIE.security;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TokenFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailService service;

    @Autowired
    private TokenUtil util;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String tokenHeader = request.getHeader("Authorization");

        String token = null;
        String username = null;

        if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {

            token = tokenHeader.substring(7);

            try {
                username = util.getUsernameFromToken(token);
            } catch (IllegalArgumentException e) {
                logger.warn("Token invalido");
            } catch (ExpiredJwtException e) {
                logger.warn("Token expirado");
            }
        } else {
            logger.warn("Token invalido");
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails user = this.service.loadUserByUsername(username);
            if (util.validateToken(token, user)) {
                UsernamePasswordAuthenticationToken usernameToken =
                        new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                usernameToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernameToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
