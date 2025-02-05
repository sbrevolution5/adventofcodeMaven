package sb.adventofcode.twentyFour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static sb.adventofcode.twentyFour.Inputs24.Day4Sample;

class Day4WordSearcherTest {

    @Test
    void howManyWords() {
        //arrange
        String testData = Day4Sample;
        var d4 = new Day4WordSearcher();
        //act
        var res = d4.HowManyWords(testData);
        //assert
        assertEquals(18,res);
    }

    @Test
    void howManyXWords() {
        //arrange
        String testData = Day4Sample;
        var d4 = new Day4WordSearcher();
        //act
        var res = d4.HowManyXWords(testData);
        //assert
        assertEquals(9,res);
    }
}