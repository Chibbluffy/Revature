package dev.wan.daos;

import dev.wan.entities.Account;

import java.util.*;

public class AccountDaoLocal implements AccountDao{
    private static Map<Integer, Set<Account>> accountTable = new HashMap<Integer, Set<Account>>();
    private static int idMaker = 0;

    public AccountDaoLocal() {
    }

    @Override
    public Account createAccount(Account account) {
        account.setAccountId(++idMaker);
        Set<Account> accountSet = accountTable.get(account.getClientId());
        if (accountSet == null){
            accountSet = new HashSet<Account>();
            accountTable.put(account.getAccountId(), accountSet);
        }
        accountSet.add(account);
        accountTable.put(account.getAccountId(), accountSet);
        return account;
    }

    @Override
    public Set<Account> getAccountsByClientId(int id) {
        return accountTable.get(id);
    }

    @Override
    public Set<Account> getAccountsByClientId(int id, float balanceMin, float balanceMax) {
        return null;
    }

    @Override
    public Account getAccountByIds(int clientId, int accountId) {
        return null;
    }

    @Override
    public Account updateAccount(Account account) {
//        ArrayList<Account> accountList = accountTable.get(account.getClientId());
//        accountTable.put(account.getAccountId(),accountList);
//        accountList.replaceAll(, account);
        return account;
    }

    @Override
    public boolean deleteAccountByIds(int clientId, int accountId) {
        return false;
//        Account account = accountTable.remove(accountId);
//        if (account == null){
//            return false;
//        }
//        return true;
    }
}
