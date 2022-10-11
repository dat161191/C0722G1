package case_study_module2.util;

import case_study_module2.model.Person.Employee;
import case_study_module2.model.Person.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FuramaCheckException {
    private static Scanner scanner = new Scanner(System.in);

    public static void checkCode(String code) throws FuramaException {
        if (!code.matches("[0-9]+")) {
            throw new FuramaException("Code is wrong format! Please re-enter!");
        }
    }

    public static void checkFullName(String name) throws FuramaException {
        if (!name.matches("^(([A-ZĐ][a-záàảãạăâắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+[ ])*)+[A-ZĐ][a-záàảãạăâắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+$")) {
            throw new FuramaException("Name is wrong format! Please re-enter!");
        }
    }

    public static void checkGender(String choice) throws FuramaException {
        if (!Objects.equals(choice, "1") && !Objects.equals(choice, "2") && !Objects.equals(choice, "3")) {
            throw new FuramaException("You have choice it incorrectly, please re-enter!");
        }
    }

    public static void checkIDCard(String id) throws FuramaException {
        if (!id.matches("[A-Z][0-9]{9}")) {
            throw new FuramaException("IDCard is wrong format! Please re-enter!");
        }

    }

    public static void checkPhoneNumber(String number) throws FuramaException {
        if (!number.matches("[8][4][-][0][0-9]{8,}")) {
            throw new FuramaException("PhoneNumber is wrong format! Please re-enter!");
        }
    }

    public static void checkEmail(String email) throws FuramaException {
        if (!email.matches("[a-z]{6,}[A-Z]*[0-9]+[@][g][m][a][i][l][.][c][o][m]([.][v][n])*")) {
            throw new FuramaException("Email is wrong format! Please re-enter!");
        }
    }

    public static void checkLevel(String choice) throws FuramaException {
        if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")) {
            throw new FuramaException("You have choice it incorrectly, please re-enter!");
        }
    }

    public static void checkRank(String choice) throws FuramaException {
        if (!Objects.equals(choice, "1") && !Objects.equals(choice, "2") && !Objects.equals(choice, "3") && !Objects.equals(choice, "4")) {
            throw new FuramaException("You have choice it incorrectly, please re-enter!");
        }
    }

    public static void checkPosition(String choice) throws FuramaException {
        if (!Objects.equals(choice, "1") && !Objects.equals(choice, "2") && !Objects.equals(choice, "3")
                && !Objects.equals(choice, "4") && !Objects.equals(choice, "5") && !Objects.equals(choice, "6")) {
            throw new FuramaException("You have choice it incorrectly, please re-enter!");
        }
    }

    public static void checkWage(double wage) throws FuramaException {
        if (wage < 1000000) {
            throw new FuramaException("Wage is wrong format! Please re-enter!");
        }
    }

    public static void checkAddress(String address) throws FuramaException {
        if (!address.matches("([\\p{L}\\s]+)")) {
            throw new FuramaException("Address is wrong format! Please re-enter!");
        }
    }

    public static void checkServiceName(String name) throws FuramaException {
        if (!name.matches("^(([A-ZĐ][a-záàảãạăâắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+[ ])*)+[A-ZĐ][a-záàảãạăâắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+[0-9]*$")) {

            throw new FuramaException("ServiceName is wrong format! Please re-enter!");
        }
    }

    public static void checkRentalCoats(double rentalCoats) throws FuramaException {
        if (rentalCoats < 1) {
            throw new FuramaException("RentalCoats is wrong format! Please re-enter!");
        }
    }

    public static void checkUsableArea(double usableArea) throws FuramaException {
        if (usableArea < 30) {
            throw new FuramaException("UsableArea is wrong format! Please re-enter!");
        }
    }

    public static void checkPoolArea(double poolArea) throws FuramaException {
        if (poolArea < 30) {
            throw new FuramaException("PoolArea is wrong format! Please re-enter!");
        }
    }

    public static void checkRoomStandard(String roomStandard) throws FuramaException {
        if (!roomStandard.matches("^(([A-ZĐ][a-záàảãạăâắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+[ ])*)+[A-ZĐ][a-záàảãạăâắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+[0-9]*$")) {
            throw new FuramaException("RoomStandard is wrong format! Please re-enter!");
        }
    }

    public static void checkFreeService(String freeService) throws FuramaException {
        if (!freeService.matches("^(([A-ZĐ][a-záàảãạăâắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+[ ])*)+[A-ZĐ][a-záàảãạăâắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+[0-9]*$")) {
            throw new FuramaException("FreeService is wrong format! Please re-enter!");
        }
    }

    public static void checkNumberFloor(int numberFloor) throws FuramaException {
        if (numberFloor < 1) {
            throw new FuramaException("NumberFloor is wrong format! Please re-enter!");
        }
    }

    public static void checkBirth(LocalDate birth) throws FuramaException {
        LocalDate presentDate = LocalDate.now().plusYears(-18);
        LocalDate maxDate = LocalDate.now().plusYears(-100);
        if (!birth.isBefore(presentDate) || !birth.isAfter(maxDate)) {
            throw new FuramaException("Employee must not be under 18 or over 100 years old, please try again.");
        }
    }

    public static void checkMaxPeople(int maximumPeople) throws FuramaException {
        if (maximumPeople < 0 || maximumPeople > 20) {
            throw new FuramaException("FreeService is false! Please re-enter!");
        }
    }

    public static void checkRentalType(String rentalType) throws FuramaException {
        if (!rentalType.matches("^(([A-ZĐ][a-záàảãạăâắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+[ ])*)+[A-ZĐ][a-záàảãạăâắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+[0-9]*$")) {
            throw new FuramaException("RentalType is false! Please re-enter!");
        }
    }

    public static void checkServiceCodeHouse(String serviceCode) throws FuramaException {
        if (!(serviceCode.matches("[S][V][H][O][-][0-9]{4}"))) {
            throw new FuramaException("ServiceCodeHouse is false! Please re-enter!");
        }
    }

    public static void checkServiceCodeVilla(String serviceCode) throws FuramaException {
        if (!serviceCode.matches("[S][V][V][L][-][0-9]{4}")) {
            throw new FuramaException("ServiceCodeVilla is false! Please re-enter!");
        }
    }

    public static void checkServiceCodeRoom(String serviceCode) throws FuramaException {
        if (!serviceCode.matches("[S][V][R][O][-][0-9]{4}")) {
            throw new FuramaException("ServiceCodeRoom is false! Please re-enter!");
        }
    }

    public static void checkServiceCode(String serviceCode) throws FuramaException {
        if (!serviceCode.matches("[S][V][R][O][-][0-9]{4}|[S][V][V][L][-][0-9]{4}|[S][V][H][O][-][0-9]{4}")) {
            throw new FuramaException("ServiceCode is false! Please re-enter!");
        }
    }

    public static void checkEndDay(LocalDate endDay, LocalDate startday) throws FuramaException {
        if (!(endDay.compareTo(startday) >= 0)) {
            throw new FuramaException("This date is incorrect!Please re-enter!");

        }
    }

    public static void checkStartDay(LocalDate starDay) throws FuramaException {
        if (!starDay.isAfter(LocalDate.now()) && starDay.compareTo(LocalDate.now()) != 0) {
            throw new FuramaException("This date is incorrect!Please re-enter!");
        }
    }

    public static void checkDate(String str) throws FuramaException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setLenient(false);

        try {
            simpleDateFormat.parse(str);
        } catch (ParseException e) {
            throw new FuramaException("Date Format Exception");
        }

    }
    public static <E extends Person> boolean checkDuplicatedCode(String code, List<E> employeeList) {
        for (E e : employeeList) {
            if (e.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }
    public static LocalDate getLocalDate() {
        LocalDate birtth;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                System.out.println("Enter the date of birth to be corrected!");
                String date = scanner.nextLine();
                FuramaCheckException.checkDate(date);
                birtth = LocalDate.parse(date, formatter);
                FuramaCheckException.checkBirth(birtth);
                break;
            } catch (DateTimeException | FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        return birtth;
    }
}


