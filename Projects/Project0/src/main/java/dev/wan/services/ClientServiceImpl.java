package dev.wan.services;

import dev.wan.daos.ClientDao;
import dev.wan.entities.Client;

import java.util.Set;
import java.util.logging.Logger;

public class ClientServiceImpl implements ClientService{
    private static Logger logger = Logger.getLogger(ClientServiceImpl.class.getName());

    private static ClientDao clientDao;
    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public Client registerClient(Client client) {
        client.setNumberOfAccounts(0);
        this.clientDao.createClient(client);
        logger.info("Registered new client!");
        return client;
    }

    @Override
    public Set<Client> getAllClients() {
        return this.clientDao.getAllClients();
    }

    @Override
    public Client getClientById(int id) {
        return this.clientDao.getClientById(id);
    }

    @Override
    public Client updateClient(Client client) {
        this.clientDao.updateClient(client);
        return client;
    }

    @Override
    public boolean deleteClientById(int id) {
        if(this.clientDao.getClientById(id) == null){
            return false;
        }
        return this.clientDao.deleteClientById(id);
    }
}
