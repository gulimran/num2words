package imran.num2word.enums;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NumbersTest {

    @Test
    public void shouldReturnNumberForItsOrdinal() {
        // given
        String expected = " eight";

        // when
        String actual = Numbers.get(8);

        // then
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldReturnEmptyStringForZeroOrdinal() {
        // given
        String expected = "";

        // when
        String actual = Numbers.get(0);

        // then
        assertThat(actual, is(expected));
    }
}
