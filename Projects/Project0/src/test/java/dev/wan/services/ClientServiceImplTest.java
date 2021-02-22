package dev.wan.services;

import dev.wan.daos.ClientDaoDB;
import dev.wan.daos.ClientDaoLocal;
import dev.wan.entities.Client;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClientServiceImplTest {
    private static ClientService cs = new ClientServiceImpl(new ClientDaoLocal());

    @Test
    @Order(1)
    void register_client_test(){
        Client client = new Client(0, "Tom", "Wan", 1996, 800);
        cs.registerClient(client);

        Assertions.assertNotEquals(0, client.getId());
        Assertions.assertEquals(0, client.getNumberOfAccounts());
    }

    @Test
    @Order(2)
    void update_client_test(){
        Client client = new Client(0,"Thomas","Wan",1996,850);
        client = cs.updateClient(client);
        Assertions.assertEquals("Thomas",client.getFirstName());
    }
}