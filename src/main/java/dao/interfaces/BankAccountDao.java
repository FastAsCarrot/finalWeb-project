package dao.interfaces;

import dao.entities.BankAccount;

import java.util.List;

/**
 * Created by vrama on 26.04.2016.
 */
public interface BankAccountDao {
    List<BankAccount> getAllBankAccounts();
    BankAccount getBankAccountById(int id);
    boolean blockBankAccountById(int id);
    boolean addMoney(int id, double sum);
}
