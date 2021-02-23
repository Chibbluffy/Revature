package dev.wan.daos;

import dev.wan.entities.Client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ClientDaoLocal implements ClientDao{

    private static Map<Integer,Client> clientTable = new HashMap<Integer,Client>();
    private static int idMaker = 0;

    @Override
    public Client createClient(Client client) {
        client.setClientId(++idMaker);
        clientTable.put(client.getClientId(),client);
        return client;
    }

    @Override
    public Set<Client> getAllClients() {
        Set<Client> allClients = new HashSet<Client>(clientTable.values());
        return allClients;
    }

    @Override
    public Client getClientById(int clientId) {
        return clientTable.get(clientId);
    }

    @Override
    public Client updateClient(Client client) {
        return clientTable.put(client.getClientId(),client);
    }

    @Override
    public boolean deleteClientById(int clientId) {
        Client client = clientTable.remove(clientId);
        if (client == null){
            return false;
        }
        return true;
    }
}
