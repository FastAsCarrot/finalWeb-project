package dao.interfaces;

import dao.entities.BankAccount;

import java.util.List;

/**
 * Created by vrama on 26.04.2016.
 */
public interface BankAccountDao {
    public List<BankAccount> getAllBankAccounts();
    public BankAccount getBankAccount(int id);
    public void blockBankAccount(int id);
    public boolean addMoney(double sum);
}
