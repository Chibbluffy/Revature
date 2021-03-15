package dev.wan.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtil {
    private static final String secret="Better secret string than Adam's super secret string";
    private static final Algorithm algorithm = Algorithm.HMAC256(secret);

    public static String generate(int employeeId, String username, String role){
        String token = JWT.create()
                .withClaim("employeeId", employeeId)
                .withClaim("username", username)
                .withClaim("role", role)
                .sign(algorithm);
        return token;
    }

    public static DecodedJWT isValidJWT(String token){
        try {
            if (token == null){
                return null;
            }
            DecodedJWT jwt = JWT.require(algorithm).build().verify(token);
            return jwt;
        }catch (JWTVerificationException jwtVerificationException){
            jwtVerificationException.printStackTrace();
            return null;
        }
    }
}
