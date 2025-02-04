package sb.adventofcode;

import sb.adventofcode.seventeen.days.*;
import sb.adventofcode.twentyFour.Day1LocationFinder;
import sb.adventofcode.twentyFour.Day2ReportSafetySystem;
import sb.adventofcode.twentythree.Days.*;
import sb.adventofcode.twentythree.Inputs;

public class Main {

    public static void main(String[] args) {
//	    var d1 = new day1();
//        System.out.println(d1.GetSolution(Inputs.Day1));
//        System.out.println(d1.GetPart2(Inputs.Day1));
//        var d2 = new day2();
//        System.out.println(d2.GetChecksum(Inputs.Day2));
//        try{
//
//            //System.out.println(d2.GetDivsum("5\t9\t2\t8\n" +
//              //      "9\t4\t7\t3\n" +
//                //    "3\t8\t6\t5"));
//            System.out.println(d2.GetDivsum(Inputs.Day2));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        var d3 = new day3();
//        System.out.println(d3.StepsToNode(Inputs.Day3));
//        var day1_23 = new Day1();
//        System.out.println(day1_23.GetCalibration(Inputs.Day1));
//        var day2_23 = new Day2();
//        System.out.println("The Sum of all possible game Ids is: ");
//
//        System.out.println(day2_23.SumOfPossibleRounds(Inputs.Day2));
//        System.out.println("The Sum of the powers of minimum cubes is: ");
//        System.out.println(day2_23.MinimumCubesPowerSum(Inputs.Day2));
//        var day3_23 = new Day3();
//        System.out.println("The total sum of part numbers is:");
//        System.out.println(day3_23.GetAllParts(Inputs.Day3_test));
//        System.out.println("The total Gear ratio is:");
//        System.out.println(day3_23.GetGearRatios(Inputs.Day3));
//        System.out.println("Total Points for scratch offs is:");
//        var day4_23 = new Day4();
//        System.out.println(day4_23.GetScratcherScore(Inputs.Day4));
//        System.out.println("Total Number of Scratchers:");
//        System.out.println(day4_23.GetFinalCardCount(Inputs.Day4));
//        var day5_23 = new Day5();
//        System.out.println("Lowest Location:");
//        System.out.println(day5_23.FindLowestLocation(Inputs.Day5));
        // 2024
        var d1 = new Day1LocationFinder();
        d1.FindLocations();
        d1.FindSimilarityScore();
        var d2 = new Day2ReportSafetySystem();
        d2.HowManyAreSafe();
        var d3 = new Day3FileDecorruptor();

    }
}
