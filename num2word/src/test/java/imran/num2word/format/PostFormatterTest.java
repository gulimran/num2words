package imran.num2word.format;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PostFormatterTest {

    private PostFormatter classToTest = new PostFormatter();

    @Test
    public void shouldReturnSingleWord() {
        // given, when, then
        assertThat(classToTest.format("three"), is("three"));
    }

    @Test
    public void shouldRemoveExtraSpaces() {
        // given, when, then
        assertThat(classToTest.format("ninety  five  "), is("ninety five"));
    }

    @Test
    public void shouldRemoveExtraAndFromEnd() {
        // given, when, then
        assertThat(classToTest.format("eight hundred and"), is("eight hundred"));
    }

    @Test
    public void shouldReplaceHundredAndThousandWithHundredThousand() {
        // given, when, then
        assertThat(classToTest.format("two hundred and thousand"), is("two hundred thousand"));
    }

    @Test
    public void shouldReplaceHundredAndMillionWithHundredMillion() {
        // given, when, then
        assertThat(classToTest.format("one hundred and million"), is("one hundred million"));
    }

    @Test
    public void shouldRemoveAndBetweenThousandAndHundred() {
        // given, when, then
        assertThat(classToTest.format("four thousand and five hundred"), is("four thousand five hundred"));
    }

    @Test
    public void shouldRemoveAndBetweenMillionAndThousand() {
        // given, when, then
        assertThat(classToTest.format("one million and five thousand"), is("one million five thousand"));
    }

    @Test
    public void shouldRemoveAndBetweenMillionAndHundred() {
        // given, when, then
        assertThat(classToTest.format("six million and three hundred"), is("six million three hundred"));
    }
}
