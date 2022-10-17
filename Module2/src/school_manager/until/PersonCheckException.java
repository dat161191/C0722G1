package school_manager.until;

import school_manager.model.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class PersonCheckException {
    public static void checkName(String name) throws PersonException {
        if (!name.matches("^(([A-ZĐ][a-záàảãạăâắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+[ ])*)+[A-ZĐ][a-záàảãạăâắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+$")) {
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

//    public static void checkBirth(String str) throws PersonException {
//        if (!str.matches("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$")) {
//            throw new PersonException("Bạn nhập sai định dạng,vui lòng nhập lại");
//        }
//    }

    public static void checkTenique(String str) throws PersonException {
        if (!str.matches("([\\p{L}\\s]+)")) {
            throw new PersonException("Bạn nhập sai định dạng,vui lòng nhập lại");
        }
    }

    public static <E extends Person> void checkDuplicatedCode(String code, List<E> employeeList) throws PersonException {
        for (E e : employeeList) {
            if (e.getCode().equals(code)) {
                throw new PersonException("Mã này đã trùng!Vui lòng nhập lại");
            }
        }
    }

    public static void checkDate(String str) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setLenient(false);
        simpleDateFormat.parse(str);
    }

    public static void checkBirth(LocalDate birth) throws PersonException {
        LocalDate presentDate = LocalDate.now().plusYears(-7);
        LocalDate maxDate = LocalDate.now().plusYears(-100);
        if (!birth.isBefore(presentDate) || !birth.isAfter(maxDate)) {
            throw new PersonException("Tuổi bạn nhập quá giới hạn!Vui lòng nhập lại");
        }
    }

    public static void checkYesNo(String str) throws PersonException {
        if ((!str.equals("Y")) && (!str.equals("N"))) {
            throw new PersonException("Vui lòng nhập đúng chữ");
        }
    }
}
