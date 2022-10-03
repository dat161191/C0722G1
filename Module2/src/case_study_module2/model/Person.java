package case_study_module2.model;

public abstract class Person {
    private String code;
    private String fullName;
    private String birth;
    private String gender;
    private int idCard;
    private int numberPhone;
    private String email;

    public Person() {
    }

    public Person(String Code, String fullName, String birth, String gender, int idCard, int numberPhone, String email) {
        this.code = Code;
        this.fullName = fullName;
        this.birth = birth;
        this.gender = gender;
        this.idCard = idCard;
        this.numberPhone = numberPhone;
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "employeeCode='" + code + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birth='" + birth + '\'' +
                ", gender='" + gender + '\'' +
                ", idCard=" + idCard +
                ", numberPhone=" + numberPhone +
                ", email='" + email + '\'' +
                '}';
    }

}
