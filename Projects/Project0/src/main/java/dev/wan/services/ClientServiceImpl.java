package dev.wan.services;

import dev.wan.daos.ClientDao;
import dev.wan.entities.Client;

import java.util.Set;

public class ClientServiceImpl implements ClientService{
    private static ClientDao clientDao;
    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public Client registerClient(Client client) {
        return null;
    }

    @Override
    public Set<Client> getAllClients() {
        return null;
    }

    @Override
    public Client getClientById(int id) {
        return null;
    }

    @Override
    public Client updateClient(Client client) {
        return null;
    }

    @Override
    public boolean deleteClientById(int id) {
        return false;
    }
}
