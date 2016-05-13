package dao.interfaces;

import dao.entities.BankCard;

import java.util.List;

/**
 * Created by vrama on 26.04.2016.
 */
public interface BankCardDao {
    List<BankCard> getAllBankCards();
    BankCard getBankCardByOwnerId(int id);
}
