package dev.wan.utiltests;

import com.auth0.jwt.interfaces.DecodedJWT;
import dev.wan.utils.JwtUtil;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class JwtTests {

    static String testjwt;
    @Test
    void creates_jwt(){
        String jwt = JwtUtil.generate("employee", "Tom");
        System.out.println(jwt);
    }

    @Test
    void create_jwt_manager(){
        String jwt = JwtUtil.generate("Manager", "Tom");
        System.out.println(jwt);
        testjwt = jwt;
    }
    @Test
    void decode_jwt(){
        DecodedJWT jwt = JwtUtil.isValidJWT("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXBsb3llZU5hbWUiOiJUb20iLCJyb2xlIjoiTWFuYWdlciJ9.JrdPMcv_iGOQv_1lA2wZl62bOX5GzVcreyed7iEedj0");
        String role = jwt.getClaim("role").asString();
        System.out.println(role);
    }
    @Test
    void edited_jwt(){
        DecodedJWT jwt = JwtUtil.isValidJWT("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXBsb3llZU5hbWUiOiJUb20iLCJyb2xlIjoiTWFuYWdlciJ9.JrdPMcv_iGOQv_1lA2wZl62bOX5GzVcreyed7iEedj");
        String role = jwt.getClaim("role").asString();
        System.out.println(role);
    }
}
