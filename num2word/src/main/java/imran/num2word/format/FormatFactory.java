package imran.num2word.format;

import java.util.HashMap;
import java.util.Map;

public class FormatFactory {

    public static final String PRE_FORMATTER = "pre-formatter";
    public static final String POST_FORMATTER = "post-formatter";

    private static final Map<String, Formatter<String, String>> map = new HashMap<String, Formatter<String, String>>(2);

    static {
        map.put(PRE_FORMATTER, new PreFormatter());
        map.put(POST_FORMATTER, new PostFormatter());
    }

    public Formatter<String, String> get(String key) {
        return map.get(key);
    }
}
