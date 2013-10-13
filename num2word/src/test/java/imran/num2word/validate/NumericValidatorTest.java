package imran.num2word.validate;

import org.junit.Test;

import static imran.num2word.validate.NumericValidator.isNumeric;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NumericValidatorTest {

    @Test
    public void shouldReturnTrueForNumericValue() {
        // given, when, then
        assertThat(isNumeric("78234"), is(true));
    }

    @Test
    public void shouldReturnFalseForNonNumericValue() {
        // given, when, then
        assertThat(isNumeric("non numeric value"), is(false));
    }
}
