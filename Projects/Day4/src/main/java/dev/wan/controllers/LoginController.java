package dev.wan.controllers;

import dev.wan.utils.JwtUtil;
import io.javalin.http.Handler;

public class LoginController {
    public Handler loginHandler = (ctx) -> {
        String user = "Tom";
        String role = "employee";
//        String user = ctx.body();
//        String role = "employee";
        String jwt = JwtUtil.generate(role, user);
        ctx.cookie("Authorization",jwt);
        ctx.result(jwt);
    };
}
