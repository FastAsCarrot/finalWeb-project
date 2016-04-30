package dao.interfaces;

import dao.entities.BankCard;

import java.util.List;

/**
 * Created by vrama on 26.04.2016.
 */
public interface BankCardDao {
    public List<BankCard> getAllCards();
    public BankCard getCardById(int id);
    public boolean updateCard(BankCard card);
}
