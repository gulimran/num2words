package imran.num2word.service;

import imran.num2word.build.HundredThousandBuilder;
import imran.num2word.build.MillionBuilder;
import imran.num2word.build.ThousandBuilder;
import imran.num2word.build.WordsBuilder;

import java.util.ArrayList;
import java.util.List;

public class WordsBuilderFactory {

    private static List<WordsBuilder<String, String>> wordsBuilders = getBuilderList();

    public int size() {
        return wordsBuilders.size();
    }

    public WordsBuilder<String, String> get(int index) {
        return wordsBuilders.get(index);
    }

    private static List<WordsBuilder<String, String>> getBuilderList() {
        wordsBuilders = new ArrayList<WordsBuilder<String, String>>();
        wordsBuilders.add(new MillionBuilder());
        wordsBuilders.add(new HundredThousandBuilder());
        wordsBuilders.add(new ThousandBuilder());
        return wordsBuilders;
    }
}
