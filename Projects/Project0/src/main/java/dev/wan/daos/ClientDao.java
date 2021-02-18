package dev.wan.daos;

import dev.wan.entities.Client;

import java.util.Set;

public interface ClientDao {
    // Create
    Client createClient(Client client);

    // Read
    Set<Client> getAllClients();
    Client getClientById(int clientId);

    // Update
    Client updateClient(Client client);

    // Delete
    boolean deleteClientById(int clientId);


}
