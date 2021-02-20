package dev.wan.daos;

import dev.wan.entities.Client;
import org.junit.jupiter.api.*;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClientDaoTest {
    private static ClientDao cdao = new ClientDaoLocal();
    private static Client testClient = null;

    @Test
    @Order(1)
    void create_client_test(){
        Client client1 = new Client(1, "Tom", "Wan", 1996, 800);
        cdao.createClient(client1);
        System.out.println(client1);

        Client client2 = new Client(1, "New", "Client", 1950, 750);
        cdao.createClient(client2);
        System.out.println(client2);

        testClient = client1;

        Assertions.assertNotEquals(0,client1.getId());
        Assertions.assertEquals(2, client2.getId());
    }

    @Test
    @Order(2)
    void get_client_by_id_test(){
        int clientId = testClient.getId();

        Client client = cdao.getClientById(clientId);
        Assertions.assertEquals(clientId, client.getId());
    }

    @Test
    @Order(3)
    void get_all_clients_test(){
        Set<Client> allClients = cdao.getAllClients();
        Assertions.assertEquals(2, allClients.size());
    }

    @Test
    @Order(4)
    void update_client_test(){
        Client client = cdao.getClientById(testClient.getId());
        client.setCreditScore(850);
        client.setLastName("Wann");
        cdao.updateClient(client);

        Client updatedClient = cdao.getClientById(testClient.getId());
        Assertions.assertEquals("Wann", updatedClient.getLastName());
    }

    @Test
    @Order(5)
    void delete_client_test(){
        int clientId = testClient.getId();
        boolean result = cdao.deleteClientById(clientId);
        Assertions.assertTrue(result);
    }
}