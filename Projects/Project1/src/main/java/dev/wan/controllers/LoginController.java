package dev.wan.controllers;

import com.google.gson.Gson;
import dev.wan.daos.EmployeeDaoHibernate;
import dev.wan.entities.Employee;
import dev.wan.services.LoginService;
import dev.wan.services.LoginServiceImpl;
import dev.wan.utils.JwtUtil;
import io.javalin.http.Handler;
import org.apache.log4j.Logger;

public class LoginController {
    Gson gson = new Gson();
    Logger logger = Logger.getLogger(LoginController.class.getName());
    private LoginService loginService = new LoginServiceImpl(new EmployeeDaoHibernate());

    public Handler loginHandler = (ctx) -> {
        String body = ctx.body();
        Employee user = gson.fromJson(body, Employee.class);
        String passhash = user.getPasshash();

        user = loginService.getEmployeeByUsername(user.getUsername());
        logger.info("Attempting login.");
        logger.info(user);
        logger.info(passhash);
        logger.info(user.getPasshash());
        if (user == null){
            logger.error("Incorrect login attempt. No user found.");
            ctx.status(401);
        }
        else if (passhash.equals(user.getPasshash())){
            logger.info("Logging in");
            String jwt = JwtUtil.generate(user.getId(), user.getUsername(), user.getPosition());
            ctx.cookie("Authorization", jwt);
            ctx.result(gson.toJson(jwt));
            ctx.status(200);
            logger.info("Logged in as User: "+user.getUsername());
        }
        else{
            logger.error("Incorrect login attempt. Incorrect password.");
            ctx.status(401);
        }
    };


}
