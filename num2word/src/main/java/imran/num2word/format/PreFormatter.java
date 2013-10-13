package imran.num2word.format;

import java.text.DecimalFormat;

public class PreFormatter implements Formatter<String, String> {

    private static final String MASK = "000000000";
    private DecimalFormat format;

    public PreFormatter() {
        this.format = new DecimalFormat(MASK);
    }

    public String format(String input) {
        return format.format(Long.parseLong(input));
    }
}
