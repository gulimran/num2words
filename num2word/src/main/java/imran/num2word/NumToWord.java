package imran.num2word;

import imran.num2word.exception.NumToWordException;
import imran.num2word.format.FormatFactory;
import imran.num2word.service.Segmenter;
import imran.num2word.service.WordsBuilderChain;
import imran.num2word.service.WordsBuilderFactory;

import static imran.num2word.validate.NumericValidator.isNumeric;
import static imran.num2word.validate.RangeValidator.isInRange;

public class NumToWord {

    private static final String ERROR_PREFIX = "ERROR: ";
    private static final String MESSAGE_PREFIX = "Invalid argument ";
    private static final String USAGE_PREFIX = "USAGE: ";
    private static final String USAGE_MESSAGE = "java -jar puzzle-one.jar <number>, where number is between 1 and 999999999";
    private WordsBuilderChain chain;

    public NumToWord(WordsBuilderChain chain) {
        this.chain = chain;
    }

    public String convertToWords(String number) {
        if (isNumeric(number) && isInRange(number)) {
            return chain.toWords(number);
        }
        else {
            throw new NumToWordException(MESSAGE_PREFIX + number);
        }
    }

    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                NumToWord numToWord = new NumToWord(new WordsBuilderChain(
                        new WordsBuilderFactory(),
                        new FormatFactory(),
                        new Segmenter()));

                System.out.println(numToWord.convertToWords(args[0]));
            }
            catch (NumToWordException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
        else {
            System.out.println(MESSAGE_PREFIX);
            System.out.println(USAGE_PREFIX + USAGE_MESSAGE);
        }
    }
}
