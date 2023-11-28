package com.social.project.demo.security.filter;

import com.social.project.demo.security.service.UserDetailsServiceImpl;
import com.social.project.demo.security.util.JwtTokenUtil;
import com.social.project.demo.security.util.UserDetailsExtractor;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthorizationFilter extends OncePerRequestFilter {
    private static final String BEARER_TOKEN_PREFIX = "Bearer ";
    private static final String BEARER_TOKEN_NOT_FOUND_MESSAGE =
            "Did not process authentication request since failed to find "
                    + BEARER_TOKEN_PREFIX + "token " + HttpHeaders.AUTHORIZATION + " header";
    private static final Runnable EXPIRED_OR_INVALID_JWT_TOKEN_ACTION = () -> {
        throw new BadCredentialsException("Expired or invalid JWT token");
    };
    private final UserDetailsExtractor userDetailsExtractor;

    public JwtAuthorizationFilter(
            UserDetailsExtractor userDetailsExtractor
    ) {
        this.userDetailsExtractor = userDetailsExtractor;
    }

    @Override
    public void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        var token = resolveToken(request);

        if (token == null) {
            logger.error(BEARER_TOKEN_NOT_FOUND_MESSAGE);
            filterChain.doFilter(request, response);
            return;
        }


        userDetailsExtractor.extractFromToken(token)
                .map(this::createAuthentication)
                .ifPresentOrElse(this::authenticate, EXPIRED_OR_INVALID_JWT_TOKEN_ACTION);
        filterChain.doFilter(request, response);
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (bearerToken != null && bearerToken.startsWith(BEARER_TOKEN_PREFIX)) {
            return bearerToken.substring(BEARER_TOKEN_PREFIX.length());
        }
        return null;
    }

    public UsernamePasswordAuthenticationToken createAuthentication(UserDetails userDetails) {
        return new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );
    }

    public void authenticate(UsernamePasswordAuthenticationToken authentication) {
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
