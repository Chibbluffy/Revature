package dev.wan.controllers;

import com.google.gson.Gson;
import dev.wan.entities.Employee;
import dev.wan.services.LoginService;
import dev.wan.services.LoginServiceImpl;
import dev.wan.utils.JwtUtil;
import io.javalin.http.Handler;
import org.apache.log4j.Logger;

public class LoginController {
    Gson gson = new Gson();
    Logger logger = Logger.getLogger(LoginController.class.getName());
    private LoginService loginService = new LoginServiceImpl();

    public Handler loginHandler = (ctx) -> {
        String body = ctx.body();
        Employee user = gson.fromJson(body, Employee.class);
        String passhash = user.getPasshash();

        user = loginService.getEmployeeByUsername(user.getUsername());

        if (passhash == user.getPasshash()){
            String jwt = JwtUtil.generate(user.getUsername(), user.getPosition());
            ctx.cookie("Authorization", jwt);
            ctx.result(jwt);
        }
        else{
            logger.error("Incorrect login attempt");
            ctx.status(401);
        }
    };


}
