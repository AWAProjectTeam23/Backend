package com.example.restapi.api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.restapi.repos.UserRepo;
import com.example.restapi.services.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.List;
import java.util.Map;

public class JwtTools {

    private static final String SECRET = "secret_key";

    public static String createToken(User user) {

        Algorithm algorithm = Algorithm.HMAC256(SECRET.getBytes());

        String jwtToken = JWT.create()
                        .withSubject(user.getUsername())
                                .withClaim("role", user.getAuthorities().iterator().next().getAuthority())
                                        .sign(algorithm);

        return jwtToken;
    }

    public static UsernamePasswordAuthenticationToken validateJwt(String accessToken) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET.getBytes());

        JWTVerifier verifier = JWT.require(algorithm).build();

        UsernamePasswordAuthenticationToken authToken = null;

        try {
            DecodedJWT decodedJWT = verifier.verify(accessToken);
            String username = decodedJWT.getSubject();
            String role = decodedJWT.getClaim("role").asString();
            SimpleGrantedAuthority auth = new SimpleGrantedAuthority(role);
            authToken = new UsernamePasswordAuthenticationToken(username, null, List.of(auth));

        } catch (Exception e) {

        }

        return authToken;
    }
}
