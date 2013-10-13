package imran.num2word.format;

public class PostFormatter implements Formatter<String, String> {

    private static final String PATTERN1 = "\\b\\s{2,}\\b";
    private static final String PATTERN2 = "\\s+";
    private static final String PATTERN3 = " and";
    private static final String PATTERN4 = "hundred and thousand";
    private static final String PATTERN5 = "hundred and million";

    private static final String WORD_AND = "and";
    private static final String WORD_HT = "hundred thousand";
    private static final String WORD_HM = "hundred million";
    private static final String WORD_MIL = "million";
    private static final String WORD_THOU = "thousand";
    private static final String WORD_HUND = "hundred";
    private static final String WORD_SPACE = " ";
    private static final String WORD_EMPTY = "";

    public String format(String input) {
        input = input.replaceAll(PATTERN1, WORD_SPACE);

        if (input.trim().endsWith(PATTERN3)) {
            input = input.substring(0, input.lastIndexOf(WORD_AND));
        }

        input = input.replaceAll(PATTERN4, WORD_HT);
        input = input.replaceAll(PATTERN5, WORD_HM);


        String[] s = input.trim().split(PATTERN2);

        if (s.length == 1) {
            return s[0];
        }

        StringBuffer buffer = new StringBuffer();

        if (s.length >= 4) {
            for (int i = 0; i < s.length - 3; i++) {
                if (s[i].equals(WORD_THOU) && s[i + 1].equals(WORD_AND) && s[i + 3].equals(WORD_HUND)) {
                    s[i + 1] = WORD_EMPTY;
                }
                if (s[i].equals(WORD_MIL) && s[i + 1].equals(WORD_AND) && s[i + 3].equals(WORD_THOU)) {
                    s[i + 1] = WORD_EMPTY;
                }
                if (s[i].equals(WORD_MIL) && s[i + 1].equals(WORD_AND) && s[i + 3].equals(WORD_HUND)) {
                    s[i + 1] = WORD_EMPTY;
                }
            }
        }

        for (String word : s) {
            buffer.append(word);
            buffer.append(WORD_SPACE);
        }

        input = buffer.toString();
        input = input.replaceAll(PATTERN1, WORD_SPACE);
        return input.trim();
    }
}
