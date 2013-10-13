package imran.num2word.service;

import imran.num2word.format.FormatFactory;

import static imran.num2word.format.FormatFactory.POST_FORMATTER;
import static imran.num2word.format.FormatFactory.PRE_FORMATTER;

public class WordsBuilderChain implements NumberToWordsService {

    private FormatFactory formatter;
    private WordsBuilderFactory wordsBuilders;
    private Segment segmenter;

    public WordsBuilderChain(WordsBuilderFactory wordsBuilders,
                             FormatFactory formatter,
                             Segment segmenter) {

        this.wordsBuilders = wordsBuilders;
        this.formatter = formatter;
        this.segmenter = segmenter;
    }

    public String toWords(String number) {
        if (number.equals("0")) {
            return "zero";
        }

        StringBuffer buffer = new StringBuffer();
        String formattedNumber = formatter.get(PRE_FORMATTER).format(number);

        for (int i=0; i<wordsBuilders.size(); i++) {
            buffer.append(wordsBuilders.get(i).build(segmenter.getSegment(i, formattedNumber)));
        }

        return formatter.get(POST_FORMATTER).format(buffer.toString());
    }
}
