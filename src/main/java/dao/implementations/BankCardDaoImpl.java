package dao.implementations;

import connectionPool.ConnectionPool;
import dao.entities.BankCard;
import dao.interfaces.BankCardDao;

import java.sql.*;
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
    public List<BankCard> getBankCardsByOwnerId(int id) {
        List<BankCard> bankCardList = new ArrayList<>();

        String sqlQuery = "SELECT card_id, card_number, cvv, expires, bank_account_id, pin, owner_id " +
                "FROM card WHERE owner_id = " + id;

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
    public int addBankCard(BankCard bankCard) {
        String sqlQuery = "INSERT INTO card(card_number, cvv, expires, bank_account_id, pin, owner_id)" +
                "VALUES (?, ?, ?, ?, ?, ?) RETURNING card_id";

        try (Connection connection = ConnectionPool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sqlQuery)) {
            ps.setString(1, bankCard.getNumber());
            ps.setString(2, bankCard.getCvv());
            ps.setDate(3, bankCard.getExpires());
            ps.setInt(4, bankCard.getBankAccountId());
            ps.setString(5, bankCard.getPin());
            ps.setInt(6, bankCard.getOwnerId());
            ps.execute();

            try(ResultSet rs = ps.getResultSet()) {
                if (rs.next()) {
                    return rs.getInt("card_id");
                } else {
                    return -1;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();

            return -1;
        }
    }

    @Override
    public int getBankCardIdByAccountId(int id) {
        String sqlQuery = "SELECT card_id" +
                " FROM card WHERE bank_account_id = "+ id;

        try(final Connection connection = ConnectionPool.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(sqlQuery)) {

            if (rs.next()) {
                return rs.getInt("card_id");
            } else {
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();

            return -1;
        }

    }

}
