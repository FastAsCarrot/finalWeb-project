package dao.implementations;

import connectionPool.ConnectionPool;
import dao.entities.BankAccount;
import dao.interfaces.BankAccountDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Filipp Pisarev.
 */
public class BankAccountDaoImpl implements BankAccountDao {
    private ConnectionPool connectionPool;

    public BankAccountDaoImpl() {

    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        List<BankAccount> bankAccountList = new ArrayList<>();

        String sqlQuery = "SELECT bank_account_id, amount, blocked FROM bank_account";

        try (final Connection connection = ConnectionPool.getConnection();
             final Statement statement = connection.createStatement();
             final ResultSet rs = statement.executeQuery(sqlQuery)) {


            while (rs.next()) {
                bankAccountList.add(new BankAccount(
                        rs.getInt("bank_account_id"),
                        rs.getDouble("amount"),
                        rs.getBoolean("blocked")));
            }

            return bankAccountList;

        } catch (SQLException e) {
            e.printStackTrace();

            return Collections.emptyList();
        }


    }

    @Override
    public BankAccount getBankAccountById(int id) {
        String sqlQuery = "SELECT bank_account_id, amount, blocked FROM bank_account WHERE bank_account_id = " + id;

        try (final Connection connection = ConnectionPool.getConnection();
             final Statement statement = connection.createStatement();
             final ResultSet rs = statement.executeQuery(sqlQuery)) {

            rs.next();

            return new BankAccount(
                    rs.getInt("bank_account_id"),
                    rs.getDouble("amount"),
                    rs.getBoolean("blocked"));

        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public boolean blockBankAccountById(int id) {
        String sqlQuery = "UPDATE bank_account SET blocked = true WHERE bank_account_id =  " + id;

        try (final Connection connection = ConnectionPool.getConnection();
             final Statement statement = connection.createStatement()) {
            statement.executeUpdate(sqlQuery);

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }
    }

    @Override
    public boolean addMoney(int id, double sum) {
        String sqlQuery = "UPDATE bank_account SET amount = (?) WHERE bank_account_id = (?)";

        try (final Connection connection = ConnectionPool.getConnection();
             final PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setInt(1, id);
            statement.setDouble(2, sum);
            statement.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }

    }

}