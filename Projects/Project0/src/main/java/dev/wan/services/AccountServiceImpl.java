package dev.wan.services;

import dev.wan.daos.AccountDao;
import dev.wan.entities.Account;

import java.util.Set;

public class AccountServiceImpl implements AccountService{
    private static AccountDao accountDao;
    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @Override
    public Account registerAccount(Account account) {
//        account.setAccountId();
//        account.
        this.accountDao.createAccount(account);
        return account;
    }

    @Override
    public Set<Account> getAccountsByClientId(int id) {
        return this.accountDao.getAccountsByClientId(id);
    }

    @Override
    public Account getAccountByIds(int clientId, int accountId) {
        return this.accountDao.getAccountByIds(clientId, accountId);
    }

    @Override
    public Account updateAccount(Account account) {
        Account oldAccount = this.accountDao.getAccountByIds(account.getClientId(), account.getAccountId());
//        if (oldAccount.)
        this.accountDao.updateAccount(account);
        return account;
    }

    @Override
    public boolean deleteAccountByIds(int clientId, int accountId) {
        return this.accountDao.deleteAccountByIds(clientId, accountId);
    }
}
