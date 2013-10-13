package imran.num2word.enums;

public enum Numbers {
    ZERO(""),
    ONE(" one"),
    TWO(" two"),
    THREE(" three"),
    FOUR(" four"),
    FIVE(" five"),
    SIX(" six"),
    SEVEN(" seven"),
    EIGHT(" eight"),
    NINE(" nine"),
    TEN(" ten"),
    ELEVEN(" eleven"),
    TWELVE(" twelve"),
    THIRTEEN(" thirteen"),
    FOURTEEN(" fourteen"),
    FIFTEEN(" fifteen"),
    SIXTEEN(" sixteen"),
    SEVENTEEN(" seventeen"),
    EIGHTEEN(" eighteen"),
    NINETEEN(" nineteen"),
    TWENTY(" twenty");

    private String word;

    private Numbers(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return word;
    }

    public static String get(int ordinal) {
        return Numbers.values()[ordinal].toString();
    }
}
