package imran.num2word.validate;

public class RangeValidator {

    private static final Long MIN = 0L;
    private static final Long MAX = 999999999L;


    public static boolean isInRange(String str) {
        Long number = Long.parseLong(str);

        if (MIN <= number && MAX >= number) {
            return true;
        }

        return false;
    }
}
