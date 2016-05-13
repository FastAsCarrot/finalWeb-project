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

    public ClientDaoImpl() {
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
    public Client getClientByLogin(String login) {
        String sqlQuery = "SELECT card_user_id, user_name, user_login, card_user_password, account_role_id " +
        "FROM card_user WHERE user_login = '" + login + "'";

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
        String sqlQuery = "INSERT INTO card_user (user_name, user_login, card_user_password) " +
                "VALUES (?, ?, ?)";

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

    //TODO: write this method !!
    @Override
    public String loginValidation(String login, String password) {
        String sqlQuery = "SELECT user_name  FROM card_user WHERE user_login='" + login + "'"
                + " AND card_user_password = '" + password + "'" ;

        try(Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlQuery)) {

            if(rs.next()) {
                return rs.getString("user_name");
            }

        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }


        return null;
    }

    @Override
    public boolean isLoginAlreadyExist(String login) {
        String sqlQuery = "SELECT user_login FROM card_user WHERE user_login ='" + login +"'";

        try(final Connection connection = ConnectionPool.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(sqlQuery)) {

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }

        return false;
    }

}
