package dev.wan.controllers;

import com.google.gson.Gson;
import dev.wan.daos.ClientDaoDB;
import dev.wan.daos.ClientDaoLocal;
import dev.wan.entities.Client;
import dev.wan.services.ClientService;
import dev.wan.services.ClientServiceImpl;
import io.javalin.http.Handler;

import java.util.Set;

public class ClientController {
    private ClientService clientService = new ClientServiceImpl(new ClientDaoDB());
    Gson gson = new Gson();

    //  POST /clients
    //  => 201
    public Handler createClientHandler = (ctx) -> {
        String clientJSON = ctx.body();
        Client client = gson.fromJson(clientJSON, Client.class);

        this.clientService.registerClient(client);
        clientJSON = gson.toJson(client);

        ctx.result("New client registered!\n" + clientJSON);
        ctx.status(201);
    };

    // GET /clients
    // => 200/404
    public Handler getAllClientsHandler = (ctx) -> {
        Set<Client> allClients = this.clientService.getAllClients();
        String clientsJSON = gson.toJson(allClients);

        if (clientsJSON != null){
            ctx.result(clientsJSON);
            ctx.status(200);
        }
        else {
            ctx.result("Could not find any clients");
            ctx.status(404);
        }
    };

    // GET /clients/:id
    // => 200/404
    public Handler getClientByIdHandler = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Client client = this.clientService.getClientById(id);

        if (client != null){
            String clientJSON = gson.toJson(client);
            ctx.result(clientJSON);
            ctx.status(200);
        }
        else {
            ctx.result("Could not find any clients");
            ctx.status(404);
        }
    };

    // PUT /clients/:id
    // 200/404
    public Handler updateClientHandler = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        String clientJSON = ctx.body();
        Client client = gson.fromJson(clientJSON, Client.class);
        client.setClientId(id);
        Client updatedClient = this.clientService.updateClient(client);

        if (updatedClient != null){
            clientJSON = gson.toJson(updatedClient);
            ctx.result("Client updated!\n" + clientJSON);
            ctx.status(200);
        }
        else{
            ctx.result("Client could not be updated.");
            ctx.status(404);
        }
    };
    // DELETE clients/:id
    // 200/404
    public Handler deleteClientHandler = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean deleted = this.clientService.deleteClientById(id);
        if (deleted){
            ctx.result("Client " + id + " was deleted.");
            ctx.status(200);
        }
        else {
            ctx.result("Client was not deleted.");
            ctx.status(404);
        }
    };
}
