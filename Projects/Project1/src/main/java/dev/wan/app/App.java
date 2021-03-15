package dev.wan.app;

import dev.wan.controllers.ExpenseController;
import dev.wan.controllers.LoginController;
import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create(
                config -> {
                    config.enableCorsForAllOrigins();
                }
        );

        ExpenseController expenseController = new ExpenseController();
        LoginController loginController = new LoginController();

        app.post("/expenses", expenseController.createExpenseHandler);

        app.get("/expenses", expenseController.getAllExpensesHandler);

        app.get("/expenses/:id", expenseController.getExpenseHandler);

        app.put("/expenses/:id", expenseController.updateExpenseHandler);

        app.post("/login", loginController.loginHandler);
        app.start();
    }
}
