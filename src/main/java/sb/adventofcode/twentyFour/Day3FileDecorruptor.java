package sb.adventofcode.twentyFour;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static sb.adventofcode.twentyFour.Inputs24.Day3Sample;

public class Day3FileDecorruptor {
    public void JustMultiply(){
        //look for mul
        ArrayList<String> muls = new ArrayList<>();
        extractToList(muls);
        ArrayList<Integer> productList = new ArrayList<>();
        for(String mul:muls){

        }
        //does next mul have digits in 1-3 * 1-3) pattern?
        //put in a row
        //sum them up
    }

    private static void extractToList(ArrayList<String> muls) {
        String pattern = "mul[(]\\d{1,3}[,]\\d{1,3}[)]";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(Day3Sample);
        while (m.find()) {
            System.out.println(m.group());
            muls.add(m.group());
        }
    }
}
