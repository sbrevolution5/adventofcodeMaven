package sb.adventofcode.twentythree.Days;

import sb.adventofcode.twentythree.Inputs;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Day1 {
    public int GetCalibration(String data){
        String[] inputs = ProcessInput(data);
        var res = new ArrayList<Integer>();
        for (String line:
             inputs) {
            res.add(FormNumber(line));
        }
        var sum = 0;
        for (Integer n :
                res) {
            sum += n;
        }
        return sum;
    }

    private int FormNumber(String line) {
        var numberedline = WordToDigits(line);
        var l = numberedline.replaceAll("[^\\d]", "");
        char first = l.charAt(0);
        char last = l.charAt(l.length()-1);

        return Character.getNumericValue(first)*10 + Character.getNumericValue(last);
    }

    private String WordToDigits(String line) {
        line = line.replace("one","o1e");
        line = line.replace("two","t2o");
        line = line.replace("three","th3ee");
        line = line.replace("four","4");
        line = line.replace("five","5e");
        line = line.replace("six","6");
        line = line.replace("seven","7n");
        line = line.replace("eight","8t");
        line = line.replace("nine","n9e");
        return line;
    }

    private String[] ProcessInput(String data) {
        var res = data.split("\n");
        return res;
    }
}
