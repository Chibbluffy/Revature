package dev.wan.controllers;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import dev.wan.daos.ExpenseDaoHibernate;
import dev.wan.services.ExpenseService;
import dev.wan.services.ExpenseServiceImpl;
import dev.wan.utils.JwtUtil;
import io.javalin.http.Handler;

import java.util.logging.Logger;

public class ExpenseController {
    static Logger logger = Logger.getLogger(ExpenseController.class.getName());
    private ExpenseService expenseService = new ExpenseServiceImpl(new ExpenseDaoHibernate());
    Gson gson = new Gson();

    //app.post("/expenses", expenseController.createExpenseHandler);
    public Handler createExpenseHandler = (ctx) -> {
        DecodedJWT decodedJWT = JwtUtil.isValidJWT(ctx.cookieMap().get("jwt"));
        if (decodedJWT != null && decodedJWT.getClaim("role").asString().contains("Grandmaster")){

        }else{

        }
    };

    //app.get("expenses", expenseController.getAllExpensesHandler);
    public Handler getAllExpensesHandler = (ctx) -> {
        DecodedJWT decodedJWT = JwtUtil.isValidJWT(ctx.cookieMap().get("jwt"));
        if (decodedJWT != null && decodedJWT.getClaim("role").asString().contains("Grandmaster")){

        }else{// Only show current user expenses

        }

    };
    //app.get("/expenses/:id", expenseController.getExpenseHandler);
    public Handler getExpenseHandler = (ctx) -> {
        DecodedJWT decodedJWT = JwtUtil.isValidJWT(ctx.cookieMap().get("jwt"));
        if (decodedJWT != null && decodedJWT.getClaim("role").asString().contains("Grandmaster")){
        }else{
        }
    };

    //app.put("/expenses/:id", expenseController.updateExpenseHandler);
    public Handler updateExpenseHandler = (ctx) -> {
        DecodedJWT decodedJWT = JwtUtil.isValidJWT(ctx.cookieMap().get("jwt"));
        if (decodedJWT != null && decodedJWT.getClaim("role").asString().contains("Grandmaster")){

        }else{

        }
    };

    public Handler expenseDashboardHandler = (ctx) -> {
        DecodedJWT decodedJWT = JwtUtil.isValidJWT(ctx.cookieMap().get("jwt"));
        if (decodedJWT != null && decodedJWT.getClaim("role").asString().contains("Grandmaster")){

        }else{
            ctx.status(403);
        }
    };
    //app.delete("/expenses/:id", expenseController.deleteExpenseHandler);
//    public Handler deleteExpenseHandler = (ctx) ->{
//
//    };
}
