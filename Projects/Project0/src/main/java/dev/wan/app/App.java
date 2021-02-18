package dev.wan.app;

import dev.wan.controllers.AccountController;
import dev.wan.controllers.ClientController;
import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create();

        AccountController accountController = new AccountController();
        ClientController clientController = new ClientController();


        app.post("/clients", clientController.createClientHandler);         // 201
        app.get("clients", clientController.getAllClientsHandler);          // 200
        app.get("/clients/:id", clientController.getClientByIdHandler);     // 200/404
        app.put("/clients/:id", clientController.updateClientHandler);      // 200/404
        app.delete("/clients/:id", clientController.deleteClientHandler);    // 200/404
        app.post("/clients/:id/accounts", accountController.createAccountHandler);           // 201
        app.get("/clients/:id/accounts", accountController.getAllAccountsByClientIdHandler); // 200/404
        // ^ should handle queries too (amountLessThan, amountGreaterThan)
        app.get("/clients/:id/accounts/:id2", accountController.getAccountByIdsHandler);      // 200/404
        app.put("/clients/:id/accounts/:id2", accountController.updateAccountByIdsHandler);   // 200/404
        app.delete("/clients/:id/accounts/:id2", accountController.deleteAccountByIdsHandler);     // 200/404

        app.start();
    }
}
