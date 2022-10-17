package thi_module2.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AccountSave extends AccountBank {
    private int moneySave;
    private LocalDate dateSave;
    private int rate;
    private int period;
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    @Override
    public String getIntroduce() {
        return "This is AccountSave: ";
    }

    public AccountSave() {
    }

    public AccountSave(int moneySave, LocalDate dateSave, int rate, int period) {
        this.moneySave = moneySave;
        this.dateSave = dateSave;
        this.rate = rate;
        this.period = period;
    }

    public AccountSave(int iD, int code, String name, LocalDate dateCreate) {
        super(iD, code, name, dateCreate);
    }

    public AccountSave(int iD, int code, String name, LocalDate dateCreate, int moneySave, LocalDate dateSave, int rate, int period) {
        super(iD, code, name, dateCreate);
        this.moneySave = moneySave;
        this.dateSave = dateSave;
        this.rate = rate;
        this.period = period;
    }

    public int getMoneySave() {
        return moneySave;
    }

    public void setMoneySave(int moneySave) {
        this.moneySave = moneySave;
    }

    public LocalDate getDateSave() {
        return dateSave;
    }

    public void setDateSave(LocalDate dateSave) {
        this.dateSave = dateSave;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return this.getIntroduce() + " " + super.toString() + " " + "AccountSave{" +
                "moneySave=" + moneySave +
                ", dateSave=" + dateSave.format(format) +
                ", rate=" + rate +
                ", period=" + period +
                '}';
    }
}
