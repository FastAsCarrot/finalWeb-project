package dao.interfaces;

import dao.entities.Transaction;

import java.security.Timestamp;
import java.util.List;

/**
 * Created by vrama on 26.04.2016.
 */
public interface TransactionDao {
    List<Transaction> getAllTransactions();
    Transaction getTransactionById(int id);
    boolean makeTransaction(java.sql.Timestamp time, double sum, int card_id);
}
