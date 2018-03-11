package isNumeric;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public boolean isNumeric(char[] str) {
    	String regex ="[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?";
    	//String regex = "[\\+-]?(\\d)*[E|e|\\.]?[+|-]?(\\d)*";
    	Pattern pattern = Pattern.compile(regex);
    	Matcher m = pattern.matcher(String.valueOf(str));
        return m.matches();
    }

}