package dao.interfaces;

import dao.entities.Transaction;

import java.util.List;

/**
 * Created by vrama on 26.04.2016.
 */
public interface TransactionDao {
    public List<Transaction> getAllTransactions();
    public Transaction getTransaction(int id);
    public boolean makeTransaction(double sum);
}
