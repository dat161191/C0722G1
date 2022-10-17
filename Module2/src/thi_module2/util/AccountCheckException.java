package thi_module2.util;

import school_manager.model.Person;
import thi_module2.model.AccountBank;
import thi_module2.model.AccountPay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class AccountCheckException {
    public static void checkName(String name) throws AccountException {
        if (!name.matches("^(([A-ZĐ][a-záàảãạăâắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+[ ])*)+[A-ZĐ][a-záàảãạăâắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+$")) {
            throw new AccountException("Tên này không đúng định dạng");
        }
    }

    public static void checkScore(double score) throws AccountException {
        if (score < 0 || score > 10) {
            throw new AccountException("Điểm này không đúng!Vui lòng nhập lại");
        }
    }

    public static void checkCode(String code) throws AccountException {
        if (!code.matches("[A-Z][0-9]{2}")) {
            throw new AccountException("Mã này không hợp lệ!Vui lòng nhập lại");
        }
    }

    public static void checkGender(String str) throws AccountException {
        if (!Objects.equals(str, "1") && !Objects.equals(str, "2") && !Objects.equals(str, "3")) {
            throw new AccountException("Bạn đã nhập sai vui lòng nhập lại");
        }
    }

    public static void checkNameClass(String str) throws AccountException {
        if (!str.matches("[0-9]{2}[A-Z]")) {
            throw new AccountException("Không đúng định dạng lớp!Vui lòng nhập lại");
        }
    }


    public static void checkTenique(String str) throws AccountException {
        if (!str.matches("([\\p{L}\\s]+)")) {
            throw new AccountException("Bạn nhập sai định dạng,vui lòng nhập lại");
        }
    }

    public static <E extends AccountBank> void checkDuplicatedCode(int code, List<E> list) throws AccountException {
        for (E e : list) {
            if (e.getCode() == (code)) {
                throw new AccountException("Mã tài khoản bị trùng!");
            }
        }
    }

    public static void checkDate(String str) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setLenient(false);
        simpleDateFormat.parse(str);
    }

    public static void checkBirth(LocalDate birth) throws AccountException {
        LocalDate presentDate = LocalDate.now().plusYears(-7);
        LocalDate maxDate = LocalDate.now().plusYears(-100);
        if (!birth.isBefore(presentDate) || !birth.isAfter(maxDate)) {
            throw new AccountException("Tuổi bạn nhập quá giới hạn!Vui lòng nhập lại");
        }
    }

    public static void checkYesNo(String str) throws AccountException {
        if ((!str.equals("Y")) && (!str.equals("N"))) {
            throw new AccountException("Vui lòng nhập đúng chữ");
        }
    }

    public static void checkDuplicatedCardNumber(int cardNumber, List<AccountBank> accountBankList) throws AccountException {
        for (AccountBank i : accountBankList) {
            if (i instanceof AccountPay) {
                if (((AccountPay) i).getCardNumber() == cardNumber){
                    throw new AccountException("Mã thẻ bị trùng");
                }
            }

        }
    }
}
