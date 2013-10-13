package imran.num2word.format;

import org.junit.Before;
import org.junit.Test;

import static imran.num2word.format.FormatFactory.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FormatFactoryTest {

    private FormatFactory classToTest;

    @Before
    public void setup() {
        classToTest = new FormatFactory();
    }

    @Test
    public void shouldReturnAnInstanceOfPreFormatter() {
        // given, when, then
        assertThat((classToTest.get(PRE_FORMATTER) instanceof PreFormatter), is(true));
    }

    @Test
    public void shouldReturnAnInstanceOfPostFormatter() {
        // given, when, then
        assertThat((classToTest.get(POST_FORMATTER) instanceof PostFormatter), is(true));
    }
}
