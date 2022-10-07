package case_study_module2.model.Person;

import java.time.LocalDate;

public class Customer extends Person {
    private String rankCustomer;
    private String address;

    public Customer() {
    }

    public Customer(String rankCustomer, String address) {
        this.rankCustomer = rankCustomer;
        this.address = address;
    }

    public Customer(String Code, String fullName, LocalDate birth, String gender, String idCard, String numberPhone, String email) {
        super(Code, fullName, birth, gender, idCard, numberPhone, email);
    }

    public Customer(String Code, String fullName, LocalDate birth, String gender,
                    String idCard, String numberPhone, String email, String rankCustomer, String address) {
        super(Code, fullName, birth, gender, idCard, numberPhone, email);
        this.rankCustomer = rankCustomer;
        this.address = address;
    }

    public String getRankCustomer() {
        return rankCustomer;
    }

    public void setRankCustomer(String rankCustomer) {
        this.rankCustomer = rankCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "Customer{" +
                "rankCustomer='" + rankCustomer + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
