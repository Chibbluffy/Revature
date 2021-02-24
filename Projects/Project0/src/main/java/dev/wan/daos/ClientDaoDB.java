package dev.wan.daos;

import dev.wan.entities.Client;
import dev.wan.utils.ConnectionUtil;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ClientDaoDB implements ClientDao{
    Logger logger = Logger.getLogger(ClientDaoDB.class.getName());

    @Override
    public Client createClient(Client client) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "insert into client (firstName,lastName,birthYear,numberOfAccounts,creditScore) values (?,?,?,0,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());
            ps.setInt(3, client.getBirthYear());
            ps.setInt(4, client.getCreditScore());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int clientId = rs.getInt("clientId");
            client.setClientId(clientId);
            return client;

        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            logger.error("Unable to create client");
            return null;
        }
    }

    @Override
    public Set<Client> getAllClients() {
        Set<Client> allClients = new HashSet<Client>();
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "select * from client";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            rs.next();
            while(rs.next()){
                Client client = new Client();
                client.setClientId(rs.getInt("clientId"));
                client.setFirstName(rs.getString("firstName"));
                client.setLastName(rs.getString("lastName"));
                client.setBirthYear(rs.getInt("birthYear"));
                client.setNumberOfAccounts(rs.getInt("numberOfAccounts"));
                client.setCreditScore(rs.getInt("creditScore"));
                allClients.add(client);
            }
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            logger.error("Could not get all clients:\n"+sqlException.getMessage());
            return null;
        }
        return allClients;
    }

    @Override
    public Client getClientById(int clientId) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "select * from client where clientId=?";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, clientId);
            ResultSet rs = ps.executeQuery();
            rs.next();

            Client client = new Client();
            client.setClientId(rs.getInt("clientId"));
            client.setFirstName(rs.getString("firstName"));
            client.setLastName(rs.getString("lastName"));
            client.setBirthYear(rs.getInt("birthYear"));
            client.setNumberOfAccounts(rs.getInt("numberOfAccounts"));
            client.setCreditScore(rs.getInt("creditScore"));
            return client;
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            logger.error("Could not get client:\n"+sqlException.getMessage());
            return null;
        }
    }

    @Override
    public Client updateClient(Client client) {
        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "update client set firstName=?,lastName=?,birthYear=?,numberOfAccounts=?,creditScore=? where clientId=?";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());
            ps.setInt(3, client.getBirthYear());
            ps.setInt(4, client.getNumberOfAccounts());
            ps.setInt(5, client.getCreditScore());
            ps.setInt(6, client.getClientId());
            int updated = ps.executeUpdate();
            if (updated == 0){
                logger.error("No clients were updated");
                return null;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            logger.error("Could not get client:\n" + sqlException.getMessage());
            return null;
        }
        return client;
    }

    @Override
    public boolean deleteClientById(int clientId) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "delete from client where clientId=?";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, clientId);

            int deleted = ps.executeUpdate();
            if (deleted > 0){
                logger.info("Deleted client: " + clientId);
                return true;
            }
            logger.error("No clients deleted");
            return false;
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            logger.error("Could not delete client:\n" + sqlException.getMessage());
            return false;
        }
    }
}
