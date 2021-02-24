package dev.wan.controllers;

import com.google.gson.Gson;
import dev.wan.daos.AccountDaoDB;
import dev.wan.daos.AccountDaoLocal;
import dev.wan.entities.Account;
import dev.wan.services.AccountService;
import dev.wan.services.AccountServiceImpl;
import io.javalin.http.Handler;
import org.apache.log4j.Logger;

import java.util.Set;

public class AccountController {
    static Logger logger = Logger.getLogger(AccountController.class.getName());
    private AccountService accountService = new AccountServiceImpl(new AccountDaoDB());
    Gson gson = new Gson();

    // POST /clients/:id/accounts
    // 201
    public Handler createAccountHandler = (ctx) -> {
        String accountJSON = ctx.body();
        Account account = gson.fromJson(accountJSON,  Account.class);
        account = this.accountService.registerAccount(account);

        if (account != null){
            accountJSON = gson.toJson(account);
            ctx.result("New account created!\n" + accountJSON);
            ctx.status(201);
            logger.info("Account created");
        }else{
            ctx.result("New account could not be created");
            ctx.status(404);
            logger.info("New account could not be created");
        }
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

        if (allAccountsFromClient.isEmpty()){
            ctx.result("No accounts found");
            ctx.status(404);
            logger.error("no accounts found");
        }
        else {
            String accountsJSON = gson.toJson(allAccountsFromClient);
            ctx.result(accountsJSON);
            ctx.status(200);
        }
    };

    // GET  /clients/:id/accounts/:id2
    // 200/404
    public Handler getAccountByIdsHandler = (ctx) -> {
        int clientId = Integer.parseInt(ctx.pathParam("id"));
        int accountId = Integer.parseInt(ctx.pathParam("id2"));
        Account account = this.accountService.getAccountByIds(clientId, accountId);

        if (account != null){
            String accountJSON = gson.toJson(account);
            ctx.result(accountJSON);
            ctx.status(200);
        }
        else {
            logger.error("No account found");
            ctx.result("No account found");
            ctx.status(404);
        }
    };

    // PUT clients/:id/accounts/:id2
    // 200/404
    public Handler updateAccountByIdsHandler = (ctx) -> {
        String accountJSON = ctx.body();
        Account account = gson.fromJson(accountJSON,  Account.class);
        if (        account.getAccountId()==Integer.parseInt(ctx.pathParam("id"))
                &&  account.getClientId()==Integer.parseInt(ctx.pathParam("id2"))){

            Account updatedAccount = this.accountService.updateAccount(account);
            if (updatedAccount != null){
                accountJSON = gson.toJson(updatedAccount);
                ctx.result("Account successfully updated\n"+accountJSON);
                ctx.status(200);
                return;
            }
        }
        ctx.result("No account updated");
        ctx.status(404);
        logger.error("No account updated");
    };

    // DELETE clients/:id/accounts/:id2
    // 200/404
    public Handler deleteAccountByIdsHandler = (ctx) -> {
        int clientId = Integer.parseInt(ctx.pathParam("id"));
        int accountId = Integer.parseInt(ctx.pathParam("id2"));
        if (clientId != 0) {
            boolean deleted = this.accountService.deleteAccountByIds(clientId, accountId);
            if (deleted){
                ctx.result("Account " + accountId + " for Client " + clientId + " deleted.");
                ctx.status(200);
            }
            else {
                ctx.result("Account " + accountId + " for Client " + clientId + " could not be deleted.");
                ctx.status(404);
                logger.error("No account deleted");
            }
        }
    };
}
