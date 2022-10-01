package ss19_string_and_regex.exercise.validate_name_class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameClass {
    /*Bắt đầu bằng một ký tự chữ hoa C hoặc A hoặc P

Không chứa các ký tự đặc biệt

Theo sau ký tự bắt đầu là 4 ký tự số

Kết thúc phải là 1 trong những ký tự chữ hoa sau: G, H, I, K, L, M*/
    private static final String NAME_CLASS = "[CAP][0-9]{4}[GMIKLM]";

    public NameClass() {
    }
    public boolean validate(String regex){
        Pattern pattern=Pattern.compile(NAME_CLASS);
        Matcher matcher=pattern.matcher(regex);
        return matcher.matches();
    }
}
