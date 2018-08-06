package com.ubs.opsit.interviews;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;

import static com.ubs.opsit.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Acceptance test class that uses the JBehave (Gerkin) syntax for writing stories.  You should not need to
 * edit this class to complete the exercise, this is your definition of done.
 */
public class BerlinClockFixture {

       BerlinClockTest berlinClockTest = new BerlinClockTest();
 
    // BLINK EVERY TWO SECONDS
    @Test
    public void testSS() {
        Assert.assertEquals("Y", berlinClockTest.displaySS(0));
        Assert.assertEquals("O", berlinClockTest.displaySS(1));
        Assert.assertEquals("Y", berlinClockTest.displaySS(10));
        Assert.assertEquals("O", berlinClockTest.displaySS(33));
    }
 
 
    // PRIMARY HOURS LAMPS
    @Test
    public void testPrimaryHH() {
        Assert.assertEquals("OOOO", berlinClockTest.displayPrimaryHH(0));
        Assert.assertEquals("OOOO", berlinClockTest.displayPrimaryHH(1));
        Assert.assertEquals("RROO", berlinClockTest.displayPrimaryHH(12));
        Assert.assertEquals("RRRO", berlinClockTest.displayPrimaryHH(17));
        Assert.assertEquals("RRRR", berlinClockTest.displayPrimaryHH(24));
    }
 
    // SECONDARY HOURS LAMPS

    @Test
    public void testSecondaryHH() {
        Assert.assertEquals("OOOO", berlinClockTest.displaySecondaryHH(0));
        Assert.assertEquals("ROOO", berlinClockTest.displaySecondaryHH(1));
        Assert.assertEquals("RROO", berlinClockTest.displaySecondaryHH(12));
        Assert.assertEquals("RROO", berlinClockTest.displaySecondaryHH(17));
        Assert.assertEquals("RRRO", berlinClockTest.displaySecondaryHH(23));
    }
 
    // QUARTER TIME LAMPS
    @Test
    public void testQuarterLamps() {
        String quarterTime = berlinClockTest.displayPrimaryMM(32);
        Assert.assertEquals("R", quarterTime.substring(2, 3));
        Assert.assertEquals("R", quarterTime.substring(5, 6));
        Assert.assertEquals("O", quarterTime.substring(8, 9));
    }
 
    // PRIMARY MINUTES LAMPS
    @Test
    public void testPrimaryMM() {
        Assert.assertEquals("OOOOOOOOOOO", berlinClockTest.displayPrimaryMM(0));
        Assert.assertEquals("0OOOOOOOOOO", berlinClockTest.displayPrimaryMM(1));
        Assert.assertEquals("YOOOOOOOOOO", berlinClockTest.displayPrimaryMM(7));
        Assert.assertEquals("YYRYYOOOOOO", berlinClockTest.displayPrimaryMM(27));
        Assert.assertEquals("YYRYYRYYRYY", berlinClockTest.displayPrimaryMM(59));
    }
 
    //SECONDARY MINUTES LAMPS
    @Test
    public void testSecondaryMM() {
        Assert.assertEquals("OOOO", berlinClockTest.displaySecondaryMM(0));
        Assert.assertEquals("YOOO", berlinClockTest.displaySecondaryMM(1));
        Assert.assertEquals("YYOO", berlinClockTest.displaySecondaryMM(7));
        Assert.assertEquals("YYOO", berlinClockTest.displaySecondaryMM(27));
        Assert.assertEquals("YYYY", berlinClockTest.displaySecondaryMM(59));
    }
 
    // BERLIN CLOCK INPUT
    @Test
    public void testBerlinClockInput()  {
        Assert.assertEquals(5, berlinClockTest.getBerlinTime("23:33:33").length);
    }
 
    // BERLIN CLOCK RESULTS TEST
    @Test
    public void testBerlinClockOutput() {
        String[] berlinTime = berlinClockTest.convertTime("16:37:16");
        String[] expectedResult = new String[] {"O", "RRRR", "RRRO", "YYRYYROOOOO", "YYYO"};
        Assert.assertEquals(expectedResult.length, berlinTime.length);
        for (int index = 0; index < expectedResult.length; index++) {
            Assert.assertEquals(expectedResult[index], berlinTime[index]);
        }
    }
}
