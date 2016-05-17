package dao.entities;

/**
 * Created by vrama on 26.04.2016.
 */
public class BankAccount {
    private int id;
    private double amount;
    private boolean isBlocked;

    public BankAccount(int id, double amount, boolean isBlocked) {
        this.id = id;
        this.amount = amount;
        this.isBlocked = isBlocked;
    }

    public int getId() {
        return id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public boolean getisBlocked() {
        return isBlocked;
    }

    public void setisBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
