package dao.entities;

import java.sql.Date;
import java.sql.Timestamp;


/**
 * Created by vrama on 26.04.2016.
 */
public class BankCard {
    private int id;
    private int bankAccountId;
    private int ownerId;
    private String number;
    private String cvv;
    private Date expires;
    private String pin;

    public BankCard(int id, String number, String cvv, Date expires, int bankAccountId, String pin, int ownerId) {
        this.bankAccountId = bankAccountId;
        this.ownerId = ownerId;
        this.number = number;
        this.cvv = cvv;
        this.expires = expires;
        this.pin = pin;
    }

    public BankCard(int bankAccountId, int ownerId, String number, String cvv, Date expires, String pin) {
        this.bankAccountId = bankAccountId;
        this.ownerId = ownerId;
        this.number = number;
        this.cvv = cvv;
        this.expires = expires;
        this.pin = pin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(int bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
