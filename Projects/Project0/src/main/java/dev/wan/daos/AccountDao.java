package dev.wan.daos;

import dev.wan.entities.Account;

import java.util.Set;

public interface AccountDao {

    // Create
    Account createAccount(Account account);


    // Read
    Set<Account> getAccountsByClientId(int id);
    Account getAccountByIds(int clientId, int accountId);

    // Update
    Account updateAccount(Account account);

    // Delete
    boolean deleteAccountByIds(int clientId, int accountId);
}
