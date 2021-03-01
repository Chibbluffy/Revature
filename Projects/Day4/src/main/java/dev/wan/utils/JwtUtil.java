package dev.wan.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtil {
    private static final String secret = "super secret string that noone else should ever have";
    private static final Algorithm algorithm = Algorithm.HMAC256(secret);

    // put in the parameters that you want to be in the body of the JWT
    public static String generate(String role, String employeeName){
        String token = JWT.create()
                .withClaim("role", role) // adds data to payload
                .withClaim("employeeName", employeeName)
                .sign(algorithm); // this generates signature and finalizes changes
        return token;
    }

    public static DecodedJWT isValidJWT(String token){
        try{
            if (token == null){
                return null;
            }
            DecodedJWT jwt = JWT.require(algorithm).build().verify(token);
            return jwt;
        }catch(JWTVerificationException jwtVerificationException){
            // if exception, someone tampered with the JWT
            jwtVerificationException.printStackTrace();
            // good place for logging.
            // 1. error
            // 2. user error showing someone tampered with JWT (suspicious)
            return null;
        }
    }
}
