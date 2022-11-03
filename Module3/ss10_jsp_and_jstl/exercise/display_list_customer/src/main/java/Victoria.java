public class Victoria {
    private String name;
    private String birth;
    private String address;
    private String face;

    public Victoria() {
    }

    public Victoria(String name, String birth, String address, String face) {
        this.name = name;
        this.birth = birth;
        this.address = address;
        this.face = face;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }
}
