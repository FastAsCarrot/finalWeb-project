package dao.interfaces;

import dao.entities.Client;

import java.util.List;

/**
 * Created by vrama on 26.04.2016.
 */
public interface ClientDao {
    List<Client> getAllClients();
    Client getClientById(int id);
    boolean addClient(String name, String login, String password);
    boolean loginCheck(String login, String password);
    boolean registrationCheck(String login);
    boolean updateClient(Client client);
}
