package dao.interfaces;

import dao.entities.BankCard;
import dao.implementations.BankCardDaoImpl;

import java.sql.Date;
import java.util.List;

/**
 * Created by vrama on 26.04.2016.
 */
public interface BankCardDao {
    List<BankCard> getAllBankCards();
    BankCard getBankCardByOwnerId(int id);
    int addBankCard(BankCard bankCard);
}
