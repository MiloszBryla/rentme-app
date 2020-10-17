package com.codecool.config;



import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.codecool.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private static final String TOKEN_HEADER = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer ";
    private final UserService userService;
    private final JwtController jwtController;
    private final String secret;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager,
                                  UserService userService,
                                  String secret,
                                  JwtController jwtController) {
        super(authenticationManager);
        this.userService = userService;
        this.secret = secret;
        this.jwtController = jwtController;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws IOException, ServletException {
        UsernamePasswordAuthenticationToken authentication = getAuthentication(request, response, filterChain);
        if (authentication == null) {
            return;
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);

    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request, HttpServletResponse response,
                                                                  FilterChain filterChain) throws IOException, ServletException {
        String token = request.getHeader(TOKEN_HEADER);

        if(token == null){
            token = getTokenFromCookie(request, response, filterChain);
            System.out.println("JwtAuthorization");
            logger.info(token);
        }
        if (token != null) {
            if(token.startsWith(TOKEN_PREFIX)){
                token = token.replace(TOKEN_PREFIX, "");
            }
            String userName = JWT.require(Algorithm.HMAC256(secret))
                    .build()
                    .verify(token)
                    .getSubject();
            if (userName != null) {
                UserDetails userDetails = null;
                try{
                    userDetails = userService.loadUserByUsername(userName);
                } catch (UsernameNotFoundException ex){
                    // jwtController.logout(response);
                    filterChain.doFilter(request, response);
                    return null;
                }

                return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities());
            }
        }

        return null;
    }

    private String getTokenFromCookie(HttpServletRequest request, HttpServletResponse response,
                                      FilterChain chain) throws IOException, ServletException {
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 0) {
            chain.doFilter(request, response);
            return null;
        }

        Cookie tokenCookie = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("Authorization")) {
                tokenCookie = cookie;
            }
        }

        if (tokenCookie == null) {
            chain.doFilter(request, response);
            return null;
        }
        return tokenCookie.getValue();
    }
}