package dev.wan.controllers;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import dev.wan.daos.ExpenseDaoHibernate;
import dev.wan.entities.Expense;
import dev.wan.services.ExpenseService;
import dev.wan.services.ExpenseServiceImpl;
import dev.wan.utils.JwtUtil;
import io.javalin.http.Handler;
import org.apache.log4j.Logger;

import java.util.Set;

public class ExpenseController {
    static Logger logger = Logger.getLogger(ExpenseController.class.getName());
    private ExpenseService expenseService = new ExpenseServiceImpl(new ExpenseDaoHibernate());
    Gson gson = new Gson();

    //app.post("/expenses", expenseController.createExpenseHandler);
    public Handler createExpenseHandler = (ctx) -> {
        logger.info("attempting to create expense");
        try{
            String token = ctx.header("Authorization");
            DecodedJWT decodedJWT = JwtUtil.isValidJWT(token);
            logger.info(decodedJWT.getClaim("role").toString().isEmpty());
//        if (decodedJWT != null && !decodedJWT.getClaim("role").toString().isEmpty()){
            if (decodedJWT != null) {
                Expense expense = gson.fromJson(ctx.body(), Expense.class);
                logger.info(expense);
                expense = expenseService.createExpense(expense);
                logger.info(expense);
                String expenseJSON = gson.toJson(expense);
                ctx.result(expenseJSON);
                ctx.status(201);
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.error("Could not successfully create expense.");
        ctx.status(400);
    };

    //app.get("expenses", expenseController.getAllExpensesHandler);
    public Handler getAllExpensesHandler = (ctx) -> {
        try{
            String token = ctx.header("Authorization");
            DecodedJWT decodedJWT = JwtUtil.isValidJWT(token);
//        DecodedJWT decodedJWT = JwtUtil.isValidJWT(ctx.cookieMap().get("jwt"));
            int employeeId = decodedJWT.getClaim("employeeId").asInt();
            if (decodedJWT != null && decodedJWT.getClaim("role").asString().contains("Master")){
                Set<Expense> expenses = expenseService.getAllExpenses();
                String expensesJSON = gson.toJson(expenses);
                ctx.result(expensesJSON);
                ctx.status(200);
            }else if(decodedJWT != null) {// Only show current user expenses
                Set<Expense> expenses = expenseService.getExpensesByEmployeeId(employeeId);
                String expensesJSON = gson.toJson(expenses);
                ctx.result(expensesJSON);
                ctx.status(200);
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Cannot get expenses. User is probably not logged in");
            ctx.result("Cannot get expenses. You are probably not logged in");
            ctx.status(403);
        }
    };
    //app.get("/expenses/:id", expenseController.getExpenseHandler);
    public Handler getExpenseHandler = (ctx) -> {
        try{
            String token = ctx.header("Authorization");
            int id = Integer.parseInt(ctx.pathParam("id"));
            DecodedJWT decodedJWT = JwtUtil.isValidJWT(token);
            if (decodedJWT != null && decodedJWT.getClaim("role").asString().contains("Master")){
                Expense expenses = expenseService.getExpenseById(id);
                String expensesJSON = gson.toJson(expenses);
                ctx.result(expensesJSON);
                ctx.status(200);
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.error("Cannot get expense. User is probably not logged in");
        ctx.result("Cannot get expense. You are probably not logged in");
        ctx.status(403);
    };

    //app.put("/expenses/:id", expenseController.updateExpenseHandler);
    public Handler updateExpenseHandler = (ctx) -> {
        try{
            String token = ctx.header("Authorization");
            DecodedJWT decodedJWT = JwtUtil.isValidJWT(token);
//        DecodedJWT decodedJWT = JwtUtil.isValidJWT(ctx.cookieMap().get("authorization"));
            if (decodedJWT != null && decodedJWT.getClaim("role").asString().contains("Master")){
                String action = ctx.queryParam("action","");
                if (action.equals("approve")){
                    Expense expense = expenseService.getExpenseById(Integer.parseInt(ctx.pathParam("id")));
                    expenseService.approveExpense(expense, decodedJWT.getClaim("employeeId").asInt());
                    String expenseJSON = gson.toJson(expense);
                    ctx.result(expenseJSON);
                    ctx.status(200);
                }
                else if (action.equals("deny")){
                    Expense expense = expenseService.getExpenseById(Integer.parseInt(ctx.pathParam("id")));
                    expenseService.denyExpense(expense, decodedJWT.getClaim("employeeId").asInt());
                    String expenseJSON = gson.toJson(expense);
                    ctx.result(expenseJSON);
                    ctx.status(200);
                }else{
                    logger.info("No action specified. Updating by default");
                    Expense expense = gson.fromJson(ctx.body(),Expense.class);
                    expense.setExpenseId(Integer.parseInt(ctx.pathParam("id")));
                    expense = expenseService.updateExpense(expense);
                    String expenseJSON = gson.toJson(expense);
                    ctx.result(expenseJSON);
                    ctx.status(200);
                }
            }else{
                logger.error("User does not have permission to update expenses");
                ctx.result("You do not have permissions to update expenses");
                ctx.status(403);
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Could not update expenses. Login fail?");
            ctx.result("You do not have permissions to update expenses. Are you logged in?");
            ctx.status(403);
        }
    };
}
