package imran.num2word.enums;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TensTest {

    @Test
    public void shouldReturnTensForItsOrdinal() {
        // given
        String expected = " fifty";

        // when
        String actual = Tens.get(5);

        // then
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldReturnEmptyStringForZeroOrdinal() {
        // given
        String expected = "";

        // when
        String actual = Tens.get(0);

        // then
        assertThat(actual, is(expected));
    }
}
