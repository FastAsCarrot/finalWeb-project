package dao.interfaces;

import dao.entities.Client;

import java.util.List;

/**
 * Created by vrama on 26.04.2016.
 */
public interface ClientDao {
    public List<Client> getAllClients();
    public Client getClientById(int id);
    public void updateClient(Client client);
}
