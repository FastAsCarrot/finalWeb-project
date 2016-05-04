package dao.interfaces;

import dao.entities.Transaction;

import java.security.Timestamp;
import java.util.List;

/**
 * Created by vrama on 26.04.2016.
 */
public interface TransactionDao {
    public List<Transaction> getAllTransactions();
    public Transaction getTransactionById(int id);
    public boolean makeTransaction(java.sql.Timestamp time, double sum, int card_id);
}
