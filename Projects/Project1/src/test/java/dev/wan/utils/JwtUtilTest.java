package dev.wan.utils;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JwtUtilTest {
    static String testjwt;

    @Test
    @Order(1)
    void creates_jwt(){
        String jwt = JwtUtil.generate("Outrider", "Amber");
        System.out.println(jwt);
    }

    @Test
    @Order(2)
    void create_jwt_manager(){
        String jwt = JwtUtil.generate("Acting Grandmaster","Jean");
        System.out.println(jwt);
        testjwt = jwt;
    }

    @Test
    @Order(3)
    void decode_jwt(){
        DecodedJWT jwt = JwtUtil.isValidJWT(testjwt);
        String role = jwt.getClaim("role").asString();
        System.out.println(role);
        Assertions.assertEquals("Acting Grandmaster",role);
    }

}