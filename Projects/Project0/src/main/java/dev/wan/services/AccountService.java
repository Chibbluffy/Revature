package dev.wan.services;

import dev.wan.entities.Account;

import java.util.Set;

public interface AccountService {
    Account registerAccount(Account account);

    Set<Account> getAccountsByClientId(int id);
    Set<Account> getAccountsByClientId(int id, float balanceMin, float balanceMax);
    Account getAccountByIds(int clientId, int accountId);

    Account updateAccount(Account account);

    boolean deleteAccountByIds(int clientId, int accountId);
}
