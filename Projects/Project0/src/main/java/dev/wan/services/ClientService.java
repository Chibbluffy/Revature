package dev.wan.services;

import dev.wan.entities.Client;

import java.util.Set;

public interface ClientService {
    Client registerClient(Client client);
    Set<Client> getAllClients();
    Client getClientById(int id);

    Client updateClient(Client client);

    boolean deleteClientById(int id);
}
