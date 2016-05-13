package dao.implementations;

import connectionPool.ConnectionPool;
import dao.entities.BankCard;
import dao.interfaces.BankCardDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Filipp Pisarev.
 */
public class BankCardDaoImpl implements BankCardDao {
    private ConnectionPool connectionPool;

    public BankCardDaoImpl() {

    }

    @Override
    public List<BankCard> getAllBankCards() {
        List<BankCard> bankCardList = new ArrayList<>();

        String sqlQuery = "SELECT card_id, card_number, cvv, expires, bank_account_id, pin, owner_id " +
                "FROM card";

        try (final Connection connection = ConnectionPool.getConnection();
             final Statement statement = connection.createStatement();
             final ResultSet rs = statement.executeQuery(sqlQuery)) {

            while(rs.next()) {
                bankCardList.add(new BankCard(
                        rs.getInt("card_id"),
                        rs.getString("card_number"),
                        rs.getString("cvv"),
                        rs.getDate("expires"),
                        rs.getInt("bank_account_id"),
                        rs.getString("pin"),
                        rs.getInt("owner_id")
                ));
            }

            return bankCardList;

        } catch (SQLException e) {
           e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public BankCard getBankCardByOwnerId(int id) {
        String sqlQuery = "SELECT card_id, card_number, cvv, expires, bank_account_id, pin, owner_id " +
                "FROM card WHERE owner_id = " + id;

        try (final Connection connection = ConnectionPool.getConnection();
             final Statement statement = connection.createStatement();
             final ResultSet rs = statement.executeQuery(sqlQuery)) {

            if (rs.next()) {

                return new BankCard(
                        rs.getInt("card_id"),
                        rs.getString("card_number"),
                        rs.getString("cvv"),
                        rs.getDate("expires"),
                        rs.getInt("bank_account_id"),
                        rs.getString("pin"),
                        rs.getInt("owner_id")
                );
            }


        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }

        return null;
    }

}
