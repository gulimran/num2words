package imran.num2word.service;

import imran.num2word.build.WordsBuilder;
import imran.num2word.format.FormatFactory;
import imran.num2word.format.PostFormatter;
import imran.num2word.format.PreFormatter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static imran.num2word.format.FormatFactory.POST_FORMATTER;
import static imran.num2word.format.FormatFactory.PRE_FORMATTER;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WordsBuilderChainTest {

    private static final String INPUT = "13111969";
    private static final String PRE_FORMATTED = "19691113";
    private static final String SEGMENTED = "1311";

    @InjectMocks
    private WordsBuilderChain classToTest;

    @Mock
    private FormatFactory formatter;

    @Mock
    private WordsBuilderFactory wordsBuilders;

    @Mock
    private Segment segmenter;

    @Mock
    WordsBuilder<String, String> builder;

    @Mock
    private PreFormatter preFormatter;

    @Mock
    private PostFormatter postFormatter;

    @Before
    public void setup() {
        given(wordsBuilders.get(anyInt())).willReturn(builder);
        given(formatter.get(PRE_FORMATTER)).willReturn(preFormatter);
        given(formatter.get(POST_FORMATTER)).willReturn(postFormatter);
        given(preFormatter.format(INPUT)).willReturn(PRE_FORMATTED);
        given(segmenter.getSegment(anyInt(), eq(PRE_FORMATTED))).willReturn(SEGMENTED);
    }

    @Test
    public void shouldReturnWordZeroForNumerZero() {
        // given, when, then
        assertThat(classToTest.toWords("0"), is("zero"));
    }

    @Test
    public void shouldPreFormatGivenNumber() {
        // given, when
        classToTest.toWords(INPUT);

        // then
        verify(preFormatter).format(eq(INPUT));
    }

    @Test
    public void shouldRunAllBuiildersFromFactory() {
        // given
        given(wordsBuilders.size()).willReturn(4);

        // when
        classToTest.toWords(INPUT);

        // then
        verify(wordsBuilders, times(4)).get(anyInt());
    }

    @Test
    public void shouldGetSegmentForAllBuiilders() {
        // given
        given(wordsBuilders.size()).willReturn(3);

        // when
        classToTest.toWords(INPUT);

        // then
        verify(segmenter, times(3)).getSegment(anyInt(), eq(PRE_FORMATTED));
    }

    @Test
    public void shouldCallAllBuiilders() {
        // given
        given(wordsBuilders.size()).willReturn(2);

        // when
        classToTest.toWords(INPUT);

        // then
        verify(builder, times(2)).build(eq(SEGMENTED));
    }

    @Test
    public void shouldPostFormatGivenWordAtEnd() {
        // given
        given(wordsBuilders.size()).willReturn(1);
        given(builder.build(SEGMENTED)).willReturn("result");

        // when
        classToTest.toWords(INPUT);

        // then
        InOrder order = inOrder(preFormatter, wordsBuilders, segmenter, builder, postFormatter);
        order.verify(preFormatter).format(eq(INPUT));
        order.verify(wordsBuilders).size();
        order.verify(wordsBuilders).get(eq(0));
        order.verify(segmenter).getSegment(eq(0), eq(PRE_FORMATTED));
        order.verify(builder).build(eq(SEGMENTED));
        order.verify(wordsBuilders).size();
        order.verify(postFormatter).format(eq("result"));
    }
}
