package dao.implementations;

import connectionPool.ConnectionPool;
import dao.entities.Transaction;
import dao.interfaces.TransactionDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Filipp Pisarev.
 */
public class TransactionDaoImpl implements TransactionDao {
    ConnectionPool connectionPool;

    public TransactionDaoImpl() {

    }

    @Override
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactionList = new ArrayList<>();

        String sqlQuery = "SELECT transaction_id, transaction_date, sum, card_id" +
                "FROM card_transaction";

        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sqlQuery)) {

            while(rs.next()) {
                transactionList.add(new Transaction(
                        rs.getInt("transaction_id"),
                        rs.getTimestamp("transaction_date"),
                        rs.getDouble("sum"),
                        rs.getInt("card_id")
                ));
            }

            return transactionList;

        } catch (SQLException e) {
            e.printStackTrace();

            return Collections.emptyList();
        }
    }

    @Override
    public Transaction getTransactionById(int id) {
        String sqlQuery = "SELECT transaction_id, transaction_date, sum, card_id" +
                "FROM card_transaction WHERE transaction_id = " + id;

        try(final Connection connection = ConnectionPool.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(sqlQuery) ) {

            rs.next();

            return new Transaction(
                    rs.getInt("transaction_id"),
                    rs.getTimestamp("transaction_date"),
                    rs.getDouble("sum"),
                    rs.getInt("card_id"));

        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }

    }

    @Override
    public boolean makeTransaction(Timestamp time, double sum, int card_id) {
        String sqlQuery = "INSERT INTO card_transaction(transaction_date, transaction_sum, card_id) " +
                "VALUES (?, ?, ?)";

        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sqlQuery)) {
            ps.setTimestamp(1, time);
            ps.setDouble(2, sum);
            ps.setInt(3,card_id);
            ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }
    }
}
