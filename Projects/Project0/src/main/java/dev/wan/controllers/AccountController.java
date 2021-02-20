package dev.wan.controllers;

import com.google.gson.Gson;
import dev.wan.daos.AccountDaoDB;
import dev.wan.daos.AccountDaoLocal;
import dev.wan.entities.Account;
import dev.wan.services.AccountService;
import dev.wan.services.AccountServiceImpl;
import io.javalin.http.Handler;

import java.util.Set;

public class AccountController {
    private AccountService accountService = new AccountServiceImpl(new AccountDaoDB());
    Gson gson = new Gson();

    // POST /clients/:id/accounts
    // 201
    public Handler createAccountHandler = (ctx) -> {
        String accountJSON = ctx.body();
        Account account = gson.fromJson(accountJSON,  Account.class);
        this.accountService.registerAccount(account);
        ctx.result("New account created!\n" + accountJSON);
        ctx.status(201);
    };

    // GET  /clients/:id/accounts
    // ^ should handle queries too (amountLessThan, amountGreaterThan)
    public Handler getAllAccountsByClientIdHandler = (ctx) -> {
        int clientId = Integer.parseInt(ctx.pathParam("id"));
        int amountLessThan = Integer.parseInt(ctx.queryParam("amountLessThan", "-1"));
        int amountGreaterThan = Integer.parseInt(ctx.queryParam("amountGreaterThan", "-1"));
        Set<Account> allAccountsFromClient;
        if (amountLessThan != -1 && amountGreaterThan != -1){
            allAccountsFromClient = this.accountService.getAccountsByClientId(clientId, amountGreaterThan, amountLessThan);
        }else{
            allAccountsFromClient = this.accountService.getAccountsByClientId(clientId);
        }
        String accountsJSON = gson.toJson(allAccountsFromClient);
        if (accountsJSON != null){
            ctx.result(accountsJSON);
            ctx.status(200);
        }
        else {
            ctx.result("No accounts found");
            ctx.status(404);
        }
    };
    // GET  /clients/:id/accounts/:id2
    // 200/404
    public Handler getAccountByIdsHandler = (ctx) -> {
        int clientId = Integer.parseInt(ctx.pathParam("id"));
        int accountId = Integer.parseInt(ctx.pathParam("id2"));
        Account account = this.accountService.getAccountByIds(clientId, accountId);
        String accountJSON = gson.toJson(account);
        if (accountJSON != null){
            ctx.result(accountJSON);
            ctx.status(200);
        }
        else {
            ctx.result("No account found");
            ctx.status(404);
        }
    };

    // PUT clients/:id/accounts/:id2
    // 200/404
    public Handler updateAccountByIdsHandler = (ctx) -> {

    };
    // DELETE clients/:id/accounts/:id2
    // 200/404
    public Handler deleteAccountByIdsHandler = (ctx) -> {
        int clientId = Integer.parseInt(ctx.pathParam("id"));
        int accountId = Integer.parseInt(ctx.pathParam("id2"));
        if (clientId != 0) {
            boolean deleted = this.accountService.deleteAccountByIds(clientId, accountId);
            if (deleted){
                ctx.result("Account " + accountId + " for Client " + clientId + "deleted.");
                ctx.status(200);
            }
            else {
                ctx.result("Account " + accountId + " for Client " + clientId + " could not be deleted.");
                ctx.status(200);
            }
        }
    };

}
