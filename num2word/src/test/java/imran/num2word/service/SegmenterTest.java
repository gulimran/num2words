package imran.num2word.service;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SegmenterTest {

    private Segmenter classToTest;

    @Before
    public void setup() {
        classToTest =  new Segmenter();
    }

    @Test
    public void shouldReturnFirstSegment() {
        // given, when, then
        assertThat(classToTest.getSegment(0, "345678901"), is("345"));
    }

    @Test
    public void shouldReturnSecondSegment() {
        // given, when, then
        assertThat(classToTest.getSegment(1, "345678901"), is("678"));
    }

    @Test
    public void shouldReturnhirdSegment() {
        // given, when, then
        assertThat(classToTest.getSegment(2, "345678901"), is("901"));
    }

}
