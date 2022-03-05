package part6_project1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
    public static boolean checkExample1 (String args) {
        Pattern p = Pattern.compile("\\d\\s\\W\\s*\\d*");
        Matcher m = p.matcher(args);
        return m.find();
    }
}
