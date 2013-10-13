package imran.num2word.enums;

public enum Tens {
    ZERO(""),
    TEN(" ten"),
    TWENTY(" twenty"),
    THIRTY(" thirty"),
    FORTY(" forty"),
    FIFTY(" fifty"),
    SIXTY(" sixty"),
    SEVENTY(" seventy"),
    EIGHTY(" eighty"),
    NINETY(" ninety");

    private String word;

    private Tens(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return word;
    }

    public static String get(int ordinal) {
        return Tens.values()[ordinal].toString();
    }
}
