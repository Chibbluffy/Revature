package dev.wan.daos;

import dev.wan.daos.AccountDao;
import dev.wan.daos.AccountDaoLocal;
import dev.wan.entities.Account;
import org.junit.jupiter.api.*;


import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountDaoLocalTest {
    private static AccountDao adao = new AccountDaoLocal();
    private static Account testAccount = null;

    @Test
    @Order(1)
    void create_account_test(){
        Account account1 = new Account(1,1, "Checkings");
        adao.createAccount(account1);
        System.out.println(account1);

        Account account2 = new Account(1,1, "Savings");
        adao.createAccount(account1);
        System.out.println(account1);

        testAccount = account1;

        Assertions.assertNotEquals(0, account1.getAccountId());
        Assertions.assertEquals(2, account2.getAccountId());
    }

    @Test
    @Order(2)
    void get_accounts_by_client_id_test(){
        int clientId = testAccount.getClientId();

        Set<Account> allAccounts = adao.getAccountsByClientId(clientId);
        Assertions.assertTrue(allAccounts.size() == 2);
    }

    @Test
    @Order(3)
    void get_account_by_ids_test(){
        int clientId = testAccount.getClientId();
        int accountId = testAccount.getAccountId();;
        Account account = adao.getAccountByIds(clientId, accountId);
        Assertions.assertEquals(1, clientId);
        Assertions.assertEquals(clientId, account.getClientId());
        Assertions.assertEquals(1, accountId);
        Assertions.assertEquals(accountId, account.getAccountId());
    }

    @Test
    @Order(4)
    void update_account_test(){
        Account account = adao.getAccountByIds(testAccount.getClientId(), testAccount.getAccountId());
        account.setAccountType("Savings");
        adao.updateAccount(account);

        Account updatedAccount = adao.getAccountByIds(testAccount.getClientId(), testAccount.getAccountId());
        Assertions.assertEquals("Savings", updatedAccount.getAccountType());
    }

    @Test
    @Order(5)
    void delete_account_by_ids(){
        int clientId = testAccount.getClientId();
        int accountId = testAccount.getAccountId();
        boolean result = adao.deleteAccountByIds(clientId,accountId);
        Assertions.assertTrue(result);
    }
}