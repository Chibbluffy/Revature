package dev.wan.services;

import dev.wan.daos.AccountDaoDB;
import dev.wan.daos.AccountDaoLocal;
import dev.wan.entities.Account;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountServiceImplTest {
    private static AccountService as = new AccountServiceImpl(new AccountDaoDB());
    private static Account testAccount = null;

    @Test
    @Order(1)
    void register_account(){

    }


}