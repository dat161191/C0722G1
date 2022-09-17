package exercise_HotelManager;

public class Human1 {
    private String fullName1;
    private String idCard1;
    private String queQuan1;

    public Human1() {
        super();
    }

    public Human1(String fullName1, String queQuan1, String idCard1) {
        super();
        this.fullName1 = fullName1;
        this.queQuan1 = queQuan1;
        this.idCard1 = idCard1;
    }

    public String getIdCard1() {
        return idCard1;
    }

    public void setIdCard1(String idCard1) {
        this.idCard1 = idCard1;
    }

    @Override
    public String toString() {
        return "Human1{" +
                "fullName='" + fullName1 + '\'' +
                ", idCard='" + idCard1 + '\'' +
                ", queQuan='" + queQuan1 + '\'' +
                '}';
    }
}
