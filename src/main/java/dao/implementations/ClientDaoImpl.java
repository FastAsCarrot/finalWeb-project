package dao.implementations;

import connectionPool.ConnectionPool;
import dao.entities.Client;
import dao.interfaces.ClientDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Filipp Pisarev.
 */
public class ClientDaoImpl implements ClientDao{
    private ConnectionPool connectionPool;

    public ClientDaoImpl(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clientList = new ArrayList<>();
        String sqlQuery = "SELECT card_user_id, user_name, user_login, card_user_password, account_role_id " +
                "FROM card_user";

        try(final Connection connection = ConnectionPool.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(sqlQuery) ) {

            while(rs.next()) {
                clientList.add(new Client(
                        rs.getInt("card_user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_login"),
                        rs.getString("card_user_password"),
                        rs.getInt("account_role_id")
                ));
            }

            return clientList;

        } catch (SQLException e) {
            e.printStackTrace();

            return Collections.emptyList();
        }
    }

    @Override
    public Client getClientById(int id) {
        String sqlQuery = "SELECT card_user_id, user_name, user_login, card_user_password, account_role_id " +
        "FROM card_user WHERE card_user_id = " + id;

        try(final Connection connection = ConnectionPool.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(sqlQuery) ) {

            rs.next();

            return new Client(
                        rs.getInt("card_user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_login"),
                        rs.getString("card_user_password"),
                        rs.getInt("account_role_id"));

        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }

    }


    @Override
    public boolean addClient(String name, String login, String password) {
        String sqlQuery = "INSERT INTO card_user(user_name, user_login, card_user_password) " +
                "VALUES (?), (?), (?)";

        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sqlQuery)) {
            ps.setString(1, name);
            ps.setString(2, login);
            ps.setString(3, password);
            ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }
    }

    @Override
    public boolean updateClient(Client client) {
        String sqlQuery = "UPDATE card_user SET user_name = (?), card_user_password = (?) " +
                "WHERE card_user_id = (?)";

        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sqlQuery)) {
            ps.setString(1, client.getName());
            ps.setString(2, client.getPassword());
            ps.setInt(3, client.getId());
            ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }
    }

}
