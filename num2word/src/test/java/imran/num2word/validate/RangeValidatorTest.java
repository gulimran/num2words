package imran.num2word.validate;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RangeValidatorTest {

    @Test
    public void shouldReturnTrueForNumberWithinRange() {
        // given
        String input = "745375763";

        // when, then
        assertThat(RangeValidator.isInRange(input), is(true));
    }

    @Test
    public void shouldReturnFalseForNumberBelowRange() {
        // given
        String input = "-1";

        // when, then
        assertThat(RangeValidator.isInRange(input), is(false));
    }

    @Test
    public void shouldReturnFalseForNumberAboveRange() {
        // given
        String input = "1234567890";

        // when, then
        assertThat(RangeValidator.isInRange(input), is(false));
    }

}
