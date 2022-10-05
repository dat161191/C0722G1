package case_study_module2.model.Contract;

public class Contract {
    private String codeContract;
    private String codeBooking;
    private double deposit;
    private double totalPayment;
    private String codeCustomer;

    public Contract(String codeContract, String codeBooking, double deposit, double totalPayment, String codeCustomer) {
        this.codeContract = codeContract;
        this.codeBooking = codeBooking;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
        this.codeCustomer = codeCustomer;
    }

    public Contract() {
    }

    public String getCodeContract() {
        return codeContract;
    }

    public void setCodeContract(String codeContract) {
        this.codeContract = codeContract;
    }

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "codeContract='" + codeContract + '\'' +
                ", codeBooking='" + codeBooking + '\'' +
                ", deposit=" + deposit +
                ", totalPayment=" + totalPayment +
                ", codeCustomer='" + codeCustomer + '\'' +
                '}';
    }
}
