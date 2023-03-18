package com.proj.MusicPlayer.filter;

import com.proj.MusicPlayer.services.UserDetailService;
import com.proj.MusicPlayer.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

   @Autowired
   private UserDetailService userDetailService;

   @Autowired
   private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Am ")){
            jwt = authorizationHeader.substring(3);
            username = jwtUtil.extractUserByUsername(jwt);
        }else {
            response.getWriter().write("Authorization header not found");
            response.encodeRedirectURL("");
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() != null){
            UserDetails userDetails = this.userDetailService.loadUserByUsername(username);

            if (jwtUtil.validateToken(jwt,userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }

        }else {

        }

        filterChain.doFilter(request,response);
    }
}
