package sb.adventofcode.twentyFour;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Integer.parseInt;

public class Day1LocationFinder {
    public void FindSimilarityScore(){
        ArrayList<ArrayList<Integer>> data = ProcessInputs(Inputs24.day1Input);
        var list1= data.get(0);
        var list2 = data.get(1);
        var similarities = new ArrayList<Integer>();
        for (int i = 0; i < list1.size(); i++) {
            similarities.add(calculateSimilarity(list2, list1, i));
        }
        var sum = getSum(similarities);
        System.out.println("The similarity index: ");
        System.out.println(sum);
    }

    private static Integer calculateSimilarity(ArrayList<Integer> list2, ArrayList<Integer> list1, int i) {
        var howManyOccurrences = Collections.frequency(list2, list1.get(i));
        return list1.get(i)*howManyOccurrences;
    }

    public void FindLocations(){
        ArrayList<ArrayList<Integer>> data = ProcessInputs(Inputs24.day1Input);
        for (ArrayList<Integer> list:
             data) {
            list.sort(null);
        }
        System.out.println(data);
        var distances =GetDistances(data);

        var sum = getSum(distances);
        System.out.println("the total distance is: ");
        System.out.println(sum);
    }

    private int getSum(ArrayList<Integer> distances) {
        var sum = 0;
        for (Integer dist :
                distances) {
            sum +=dist;
        }
        return sum;
    }

    private ArrayList<Integer> GetDistances(ArrayList<ArrayList<Integer>> data) {
        var list1 = data.get(0);
        var list2 = data.get(1);
        var res = new ArrayList<Integer>();
        for (int i = 0; i < data.get(0).size(); i++) {
            var a = list1.get(i);
            var b = list2.get(i);

            res.add(getDistance(a, b));
        }
        return res;
    }

    private int getDistance(Integer a, Integer b) {
        int x;
        if (a > b){
            x = a - b;
        }
        else{
            x = b - a;
        }
        return x;
    }

    private ArrayList<ArrayList<Integer>> ProcessInputs(String input){
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (String line: input.split("\n")){
            var nums = line.split("   ");
            list1.add(parseInt(nums[0]));
            list2.add(parseInt(nums[1]));
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.add(list1);
        res.add(list2);
        System.out.println(res);
        return res;
    }
}
