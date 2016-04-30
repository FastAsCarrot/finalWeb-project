package dao.entities;

import java.sql.Timestamp;

/**
 * Created by vrama on 26.04.2016.
 */
public class Transaction {
    private int id;
    private int cardId;
    private Timestamp date;
    private double sum;

    public Transaction(int cardId, Timestamp date, double sum) {
        this.cardId = cardId;
        this.date = date;
        this.sum = sum;
    }

    public int getId() {
        return id;
    }


    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
