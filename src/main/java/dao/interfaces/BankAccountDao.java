package dao.interfaces;

import dao.entities.BankAccount;

import java.util.List;

/**
 * Created by vrama on 26.04.2016.
 */
public interface BankAccountDao {
    public List<BankAccount> getAllBankAccounts();
    public BankAccount getBankAccountById(int id);
    public boolean blockBankAccountById(int id);
    public boolean addMoney(int id, double sum);
}
