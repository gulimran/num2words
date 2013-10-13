package imran.num2word;

import imran.num2word.exception.NumToWordException;
import imran.num2word.service.WordsBuilderChain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NumToWordTest {

    @InjectMocks
    private NumToWord classToTest;

    @Mock
    private WordsBuilderChain chain;

    @Test
    public void shouldCallWordsBuilderChain() {
        // given
        String input = "123456789";

        // when
        classToTest.convertToWords(input);

        // then
        verify(chain).toWords(eq(input));
    }

    @Test(expected = NumToWordException.class)
    public void shouldThrowExceptionOnNonInteger() {
        // given
        String input = "any number";

        // when
        classToTest.convertToWords(input);

        // then
        fail("should throw exception");
    }

    @Test(expected = NumToWordException.class)
    public void shouldThrowExceptionWhenNumberBelowRange() {
        // given
        String input = "-22";

        // when
        classToTest.convertToWords(input);

        // then
        fail("should throw exception");
    }

    @Test(expected = NumToWordException.class)
    public void shouldThrowExceptionWhenNumberAboveRange() {
        // given
        String input = "9876543210";

        // when
        classToTest.convertToWords(input);

        // then
        fail("should throw exception");
    }
}
