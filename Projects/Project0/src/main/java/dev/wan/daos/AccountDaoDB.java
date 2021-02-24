package dev.wan.daos;

import dev.wan.entities.Account;
import dev.wan.utils.ConnectionUtil;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class AccountDaoDB implements AccountDao{
    Logger logger = Logger.getLogger(AccountDaoDB.class.getName());

    @Override
    public Account createAccount(Account account) {
        try(Connection conn = ConnectionUtil.createConnection()){
            int clientId = account.getClientId();
            System.out.println(clientId);
            // Get client current numAccounts
            String sql = "select * from client where clientId=?";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, clientId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int accountId = rs.getInt("numberOfAccounts") + 1;
            account.setAccountId(accountId);
            // update client
            sql = "update client set numberOfAccounts=? where clientId=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, accountId);
            ps.setInt(2, clientId);
            int updated = ps.executeUpdate();
            if (updated > 0){
                logger.info("Client numberOfAccounts was successfully updated for new account creation");
            }else{
                logger.error("Client numberOfAccounts was NOT updated");
            }
            // Create Account
            sql = "insert into account (clientId, accountId, accountType, balance) values (?,?,?,?);";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, account.getClientId());
            ps.setInt(2, account.getAccountId());
            ps.setString(3, account.getAccountType());
            ps.setFloat(4, account.getBalance());
            updated = ps.executeUpdate();
            if (updated > 0){
                logger.info("Account was successfully created");
            }else{
                logger.error("Account was not created");
            }
            return account;

        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            logger.error("Unable to create account for client: "+account.getClientId());
            return null;
        }
    }

    @Override
    public Set<Account> getAccountsByClientId(int id) {
        Set<Account> allAccounts = new HashSet<Account>();
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "select * from account where clientId = ?;";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Account account = new Account();
                account.setClientId(rs.getInt("clientId"));
                account.setAccountId(rs.getInt("accountId"));
                account.setBalance(rs.getFloat("balance"));
                account.setAccountType(rs.getString("accountType"));
                allAccounts.add(account);
            }
            logger.info("Get all accounts of client "+id);
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            logger.error("unable to get all accounts of client "+id);
        }
        return allAccounts;
    }

    @Override
    public Set<Account> getAccountsByClientId(int id, float balanceMin, float balanceMax) {
        Set<Account> allAccounts = new HashSet<Account>();
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "select * from account where clientId = ? and balance > ? and balance < ?;";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.setFloat(2, balanceMin);
            ps.setFloat(3, balanceMax);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Account account = new Account();
                account.setClientId(rs.getInt("clientId"));
                account.setAccountId(rs.getInt("accountId"));
                account.setBalance(rs.getFloat("balance"));
                account.setAccountType(rs.getString("accountType"));
                allAccounts.add(account);
            }
            logger.info("Get all filtered accounts of client "+id);
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            logger.error("unable to get all filtered accounts of client "+id);
        }
        return allAccounts;
    }

    @Override
    public Account getAccountByIds(int clientId, int accountId) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "select * from account where clientId = ? and accountId = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, clientId);
            ps.setFloat(2, accountId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Account account = new Account();
            account.setClientId(rs.getInt("clientId"));
            account.setAccountId(rs.getInt("accountId"));
            account.setBalance(rs.getFloat("balance"));
            account.setAccountType(rs.getString("accountType"));
            logger.info("Get account "+accountId+" of client "+clientId);
            return account;
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            logger.error("unable to get account");
        }
        return null;
    }

    @Override
    public Account updateAccount(Account account) {
        try (Connection conn = ConnectionUtil.createConnection()) {
            Account oldAccount = getAccountByIds(account.getClientId(), account.getAccountId());
            account.setAccountType(oldAccount.getAccountType());
            String sql = "update account set balance=? where clientId=? and accountId=?";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, account.getBalance());
            ps.setInt(2, account.getClientId());
            ps.setInt(3, account.getAccountId());
            if(ps.executeUpdate() > 0){
                logger.info("Updated account "+account.getAccountId()+" from client "+account.getClientId());
                return account;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            logger.error("Could not update account:\n" + sqlException.getMessage());
        }
        return null;
    }

    @Override
    public boolean deleteAccountByIds(int clientId, int accountId) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "delete from account where clientId=? and accountId=?";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, clientId);
            ps.setInt(2, accountId);
            int deleted = ps.executeUpdate();
            if (deleted > 0){
                logger.info("Deleted account "+accountId+" from client "+clientId);
                return true;
            }
            return false;
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            logger.error("Could not delete account:\n"+sqlException.getMessage());
            return false;
        }
    }
}
