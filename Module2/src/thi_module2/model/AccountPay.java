package thi_module2.model;

import java.time.LocalDate;

public class AccountPay extends AccountBank {
    private int cardNumber;
    private int moneyInAccount;

    @Override
    public String getIntroduce() {
        return "This is AccountPay:";
    }

    public AccountPay() {
    }

    public AccountPay(int cardNumber, int moneyInAccount) {
        this.cardNumber = cardNumber;
        this.moneyInAccount = moneyInAccount;
    }

    public AccountPay(int iD, int code, String name, LocalDate dateCreate) {
        super(iD, code, name, dateCreate);
    }

    public AccountPay(int iD, int code, String name, LocalDate dateCreate, int cardNumber, int moneyInAccount) {
        super(iD, code, name, dateCreate);
        this.cardNumber = cardNumber;
        this.moneyInAccount = moneyInAccount;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getMoneyInAccount() {
        return moneyInAccount;
    }

    public void setMoneyInAccount(int moneyInAccount) {
        this.moneyInAccount = moneyInAccount;
    }

    @Override
    public String toString() {
        return this.getIntroduce() + " " + super.toString() + " " + "AccountPay{" +
                "cardNumber=" + cardNumber +
                ", moneyInAccount=" + moneyInAccount +
                '}';
    }
}
