package imran.num2word.service;

import imran.num2word.build.WordsBuilder;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WordsBuilderFactoryTest {

    private WordsBuilderFactory classToTest = new WordsBuilderFactory();

    @Test
    public void shouldReturnAnInstanceOfWordsBuilder() {
        // given, when, then
        assertThat(classToTest.get(0) instanceof WordsBuilder, is(true));
    }

    @Test
    public void shouldReturnTotalSize() {
        // given, when, then
        assertThat(classToTest.size(), is(3));
    }
}
