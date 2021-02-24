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
        return this.accountDao.createAccount(account);
    }

    @Override
    public Set<Account> getAccountsByClientId(int id) {
        return this.accountDao.getAccountsByClientId(id);
    }

    @Override
    public Set<Account> getAccountsByClientId(int id, float balanceMin, float balanceMax) {
        return this.accountDao.getAccountsByClientId(id, balanceMin, balanceMax);
    }

    @Override
    public Account getAccountByIds(int clientId, int accountId) {
        return this.accountDao.getAccountByIds(clientId, accountId);
    }

    @Override
    public Account updateAccount(Account account) {
        return this.accountDao.updateAccount(account);
    }

    @Override
    public boolean deleteAccountByIds(int clientId, int accountId) {
        return this.accountDao.deleteAccountByIds(clientId, accountId);
    }
}
