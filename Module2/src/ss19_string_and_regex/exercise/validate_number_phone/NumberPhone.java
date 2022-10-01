package ss19_string_and_regex.exercise.validate_number_phone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberPhone {
    /*Số điện thoại hợp lệ cần đạt theo mẫu sau: (xx)-(0xxxxxxxxx)

    x là ký tự số

    Không chứa các ký tự đặc biệt*/
    private static final String REGEX = "[(][0-9]{2}[)][-][(][0][0-9]{8,9}[)]";

    public NumberPhone() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
