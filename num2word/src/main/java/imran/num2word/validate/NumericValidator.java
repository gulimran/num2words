package imran.num2word.validate;

public class NumericValidator {

    public static boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
        }
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
