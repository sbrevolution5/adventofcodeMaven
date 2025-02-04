package sb.adventofcode.twentyFour;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static sb.adventofcode.twentyFour.Inputs24.Day3Input;
import static sb.adventofcode.twentyFour.Inputs24.Day3Sample;

public class Day3FileDecorruptor {
    public void JustMultiply() {
        //look for mul
        ArrayList<String> muls = new ArrayList<>();
        extractToList(muls);
        ArrayList<Integer> productList = new ArrayList<>();
        for (String mul : muls) {
            productList.add(getProductFromString(mul));
        }
        int prod = getSum(productList);
        System.out.printf("%s is sum of dividends", prod);
    }

    private static int getProductFromString(String mul) {
        Pattern p = Pattern.compile("\\d{1,3}");
        Matcher m = p.matcher(mul);
        ArrayList<Integer> multiples = new ArrayList<>();
        while (m.find()) {
            multiples.add(parseInt(m.group()));
        }
        return multiples.get(0) * multiples.get(1);
    }

    private static void extractToList(ArrayList<String> muls) {
        String pattern = "mul[(]\\d{1,3}[,]\\d{1,3}[)]";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(Day3Input);
        while (m.find()) {
            System.out.println(m.group());
            muls.add(m.group());
        }
    }
    private int getSum(ArrayList<Integer> distances) {
        var sum = 0;
        for (Integer dist :
                distances) {
            sum +=dist;
        }
        return sum;
    }
}
