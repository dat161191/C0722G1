package school_manager.service.util;

import java.util.Objects;

public class PersonCheckException {
    public static void checkName(String name) throws PersonException {
        if (!name.matches("([{L}\\s]+)")) {
            throw new PersonException("Tên này không đúng định dạng");
        }
    }

    public static void checkScore(double score) throws PersonException {
        if (score < 0 || score > 10) {
            throw new PersonException("Điểm này không đúng!Vui lòng nhập lại");
        }
    }

    public static void checkCode(String code) throws PersonException {
        if (!code.matches("[A-Z][0-9]{2}")) {
            throw new PersonException("Mã này không hợp lệ!Vui lòng nhập lại");
        }
    }

    public static void checkGender(String str) throws PersonException {
        if (!Objects.equals(str, "1") && !Objects.equals(str, "2") && !Objects.equals(str, "3")) {
            throw new PersonException("Bạn đã nhập sai vui lòng nhập lại");
        }
    }

    public static void checkNameClass(String str) throws PersonException {
        if (!str.matches("[0-9]{2}[A-Z]")) {
            throw new PersonException("Không đúng định dạng lớp!Vui lòng nhập lại");
        }
    }

    public static void checkBirth(String str) throws PersonException {
        if (!str.matches("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$")) {
            throw new PersonException("Bạn nhập sai định dạng,vui lòng nhập lại");
        }
    }
    public static void checkTenique(String str) throws PersonException{
        if(!str.matches("([\\p{L}\\s]+)")){
            throw new PersonException("Bạn nhập sai định dạng,vui lòng nhập lại");
        }
    }
}
