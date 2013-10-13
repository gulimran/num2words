package imran.num2word.format;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class PreFormatterTest {

    private PreFormatter classToTest = new PreFormatter();

    @Test
    public void shouldReturnExpectedFormattedString() {
        // given
        String input = "54321";
        String expected = "000054321";

        // when
        String actual = classToTest.format(input);

        // then
        assertThat(actual, is(expected));
    }

    @Test(expected = NumberFormatException.class)
    public void shouldThrowExceptionOnNonNumericValue() {
        // given
        String input = "non-numeric";

        // when
        classToTest.format(input);

        // then
        fail("should throw exception");
    }

}
