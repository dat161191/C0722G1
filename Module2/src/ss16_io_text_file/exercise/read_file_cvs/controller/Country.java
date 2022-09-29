package ss16_io_text_file.exercise.read_file_cvs.controller;

public class Country {
    private int STT;
    private String code;
    private String nameCountry;

    public Country(int STT, String code, String nameCountry) {
        this.STT = STT;
        this.code = code;
        this.nameCountry = nameCountry;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    @Override
    public String toString() {
        return String.format("%s,%s",this.getCode(),this.getNameCountry());
    }
}
