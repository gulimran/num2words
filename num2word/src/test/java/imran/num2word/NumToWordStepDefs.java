package imran.puzzleone;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import imran.num2word.NumToWord;
import imran.num2word.exception.NumToWordException;
import imran.num2word.format.FormatFactory;
import imran.num2word.service.Segmenter;
import imran.num2word.service.WordsBuilderChain;
import imran.num2word.service.WordsBuilderFactory;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NumToWordStepDefs {

    private NumToWord numToWord;
    private List<String> wordsForNumbers;

    public NumToWordStepDefs() {
        wordsForNumbers = newArrayList();
    }

    @Given("^num to word is submitted by a user")
    public void instantiateNumToWord() throws Throwable {
        numToWord = new NumToWord(new WordsBuilderChain(
                    new WordsBuilderFactory(),
                    new FormatFactory(),
                    new Segmenter()));
    }

    @When("^this program is run with one of the following positive integer numbers given as an input:$")
    public void runNumToWordWithEachOfTheGivenPositiveIntegerNumbers(List<String> input) throws Throwable {
        for (String number : input) {
            wordsForNumbers.add(numToWord.convertToWords(number));
        }
    }

    @When("^this program is run with a zero integer number \"([^\"]*)\" given as an input$")
    public void runNumToWordWithZero(String input) throws Throwable {
        wordsForNumbers.add(numToWord.convertToWords(input));
    }

    @When("^this program is run with a negative integer number \"([^\"]*)\" given as an input$")
    public void runNumToWordWithTheGivenNegativeNumber(String input) throws Throwable {
        try {
            wordsForNumbers.add(numToWord.convertToWords(input));
        }
        catch (NumToWordException e) {
            wordsForNumbers.add("ERROR: " + e.getMessage());
        }
    }

    @When("^this program is run with a non integer number \"([^\"]*)\" given as an input$")
    public void runNumToWordWithTheGivenNonInteger(String input) throws Throwable {
        try {
            wordsForNumbers.add(numToWord.convertToWords(input));
        }
        catch (NumToWordException e) {
            wordsForNumbers.add("ERROR: " + e.getMessage());
        }
    }

    @Then("^the output is \"([^\"]*)\"$")
    public void shouldReturnZeroString(String output) throws Throwable {
            assertThat(wordsForNumbers.get(0), is(output));
    }

    @Then("^the output is an error message as \"([^\"]*)\"$")
    public void shouldReturnErrorMessage(String output) throws Throwable {
            assertThat(wordsForNumbers.get(0), is(output));
    }

    @Then("^the output is an equivalent number in british english words as:$")
    public void shouldReturnEquivalentNumberInBritishEnglishWords(List<String> output) throws Throwable {
        for (int i=0; i<output.size(); i++) {
            assertThat(wordsForNumbers.get(i), is(output.get(i)));
        }
    }
}