package org.sid.secservice.filtres;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sid.secservice.entities.AppUser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class JwtAuthentificationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JwtAuthentificationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request, HttpServletResponse response ) throws AuthenticationException {
        System.out.println("attemptAuthentication");
       String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
       // System.out.println(AppUser);
        UsernamePasswordAuthenticationToken authenticationToken =new
                UsernamePasswordAuthenticationToken(username,password);
        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        System.out.println("successfulAuthentification");
        User user =(User) authResult.getPrincipal();
        Algorithm algo1 = Algorithm.HMAC256("mySecret123");
        String jwtAccessToken= JWT.create()
                .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis()+300*60*1000))
                                .withIssuer(request.getRequestURL().toString())
                                        .withClaim("roles",user.getAuthorities().stream().map(ga ->ga.getAuthority()).collect(Collectors.toList()))
                                                .sign(algo1);

        String jwtRefreshToken= JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+15*60*1000))
                .withIssuer(request.getRequestURL().toString())
                .sign(algo1);
        Map<String,String> idToken = new HashMap<>();
        idToken.put("accesToken",jwtAccessToken);
        idToken.put("refreshToken",jwtRefreshToken);
        response.setContentType("application/json");

       new ObjectMapper().writeValue(response.getOutputStream(),idToken);
        System.out.println(jwtAccessToken);
    }
}
