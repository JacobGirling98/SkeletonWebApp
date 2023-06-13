package com.develogical;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class QueryProcessorTest {

  QueryProcessor queryProcessor = new QueryProcessor();

  @Test
  public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
    assertThat(queryProcessor.process("test"), is(""));
  }

  @Test
  public void knowsAboutShakespeare() throws Exception {
    assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
  }

  @Test
  public void returnsOnWhatIsYourName() {
    assertThat(queryProcessor.process("What is your name?"), containsString("David Brent"));
  }

  @Test
  public void largestNumber() {
    assertThat(queryProcessor.process("Which of the following numbers is the largest: 6, 81, 66?"), containsString("81"));
  }

  @Test
  public void adding() {
    assertThat(queryProcessor.process("What is 68 plus 88?"), containsString("156"));
  }

  @Test
  public void multiplying() {
    assertThat(queryProcessor.process("What is 53 multiplied by 27?"), containsString("1431"));
  }

  @Test
  public void square() {
    assertThat(queryProcessor.process("Which of the following numbers is both a square and a cube: 64, 1024, 2998, 1765, 4058, 3375, 975?"), containsString("64"));
  }

  @Test
  public void minus() {
    assertThat(queryProcessor.process("What is 79 minus 30?"), containsString("49"));
  }
}
