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
            // Get client current numAccounts
            String sql = "select * from client where clientId = ?;";
            PreparedStatement ps1 = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps1.setInt(1,clientId);
            ResultSet rs1 = ps1.getGeneratedKeys();
            rs1.next();
            int accountId = rs1.getInt("numberOfAccounts") + 1;
            // update client
            sql = "update client set numberOfAccounts=? where clientId=?";
            PreparedStatement ps2 = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps2.setInt(1, clientId);
            ps2.setInt(2, accountId);
            ps2.execute();
            // Create Account
            sql = "insert into account (client_id, account_id, account_type, balance) values (?,?,?,?);";
            PreparedStatement ps3 = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps3.setInt(1, account.getClientId());
            ps3.setInt(2, account.getAccountId());
            ps3.setString(3, account.getAccountType());
            ps3.setFloat(4, account.getBalance());
            ps3.execute();

            ResultSet rs3 = ps3.getGeneratedKeys();
            rs3.next();
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
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            while(rs.next()){
                Account account = new Account();
                account.setClientId(rs.getInt("clientId"));
                account.setAccountId(rs.getInt("accountId"));
                account.setBalance(rs.getFloat("balance"));
                account.setAccountType(rs.getString("accountType"));
                allAccounts.add(account);
            }
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
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            while(rs.next()){
                Account account = new Account();
                account.setClientId(rs.getInt("clientId"));
                account.setAccountId(rs.getInt("accountId"));
                account.setBalance(rs.getFloat("balance"));
                account.setAccountType(rs.getString("accountType"));
                allAccounts.add(account);
            }
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            logger.error("unable to get all accounts of client "+id);
        }
        return allAccounts;
    }

    @Override
    public Account getAccountByIds(int clientId, int accountId) {
        return null;
    }

    @Override
    public Account updateAccount(Account account) {
        return null;
    }

    @Override
    public boolean deleteAccountByIds(int clientId, int accountId) {
        return false;
    }

    /*
create table account(
	account_number int,
	account_type varchar(50),
	balance float,
	client_id int,
	constraint fk_client_id foreign key (client_id) references client(client_id),
	constraint account_num_limit check (account_number <= client(numberOfAccounts))
);
     */
}
