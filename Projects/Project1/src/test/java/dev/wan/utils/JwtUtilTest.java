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
        String jwt = JwtUtil.generate(2,"Amber", "Outrider");
        System.out.println(jwt);
    }

    @Test
    @Order(2)
    void create_jwt_manager(){
        String jwt = JwtUtil.generate(3,"Jean","Acting Grandmaster");
        System.out.println(jwt);
        testjwt = jwt;
    }

    @Test
    @Order(3)
    void decode_jwt(){
        DecodedJWT jwt = JwtUtil.isValidJWT(testjwt);
        String role = jwt.getClaim("role").asString();
        String username = jwt.getClaim("username").asString();
        int id = jwt.getClaim("employeeId").asInt();
        System.out.println(role);
        System.out.println(username);
        System.out.println(id);
        Assertions.assertEquals("Jean",username);
        Assertions.assertEquals("Acting Grandmaster",role);
    }

}