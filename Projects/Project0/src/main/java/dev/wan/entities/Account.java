package dev.wan.entities;

public class Account {
    private int accountId;
    private int clientId;
    private String accountType;
    private int balance;

    public Account(){

    }
    public Account(int accountId, int clientId, String accountType) {
        this.accountId = accountId;
        this.clientId = clientId;
        this.accountType = accountType;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", clientId=" + clientId +
                '}';
    }
}
