package dao.interfaces;

import dao.entities.Client;

import java.util.List;

/**
 * Created by vrama on 26.04.2016.
 */
public interface ClientDao {
    List<Client> getAllClients();
    Client getClientByLogin(String login);
    boolean addClient(String name, String login, String password);
    String loginValidation(String login, String password);
    boolean isLoginAlreadyExist(String login);
    boolean updateClient(Client client);
}
