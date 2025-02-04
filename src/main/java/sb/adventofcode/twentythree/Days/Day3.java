package sb.adventofcode.twentythree.Days;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetterOrDigit;
import static java.lang.Integer.parseInt;
import static java.util.Map.entry;

public class Day3 {
    private final int[][] directions = {
            { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
    public int GetAllParts(String input){
        //process input to a map
        var processedInput = Pattern.compile("\n").splitAsStream(input).map(String::toCharArray).toArray(char[][]::new);
        //Maps coordinates to characters
        Map<Map.Entry<Integer,Integer>,Integer> map = new HashMap<>();
        //check each rowby row for number
        for (int i = 0; i < processedInput.length; i++) {
            for (int j = 0; j < processedInput[i].length; j++) {
                //is there a number?
                if (!isLetterOrDigit(processedInput[i][j])&& processedInput[i][j]!='.') FindPart(processedInput,i,j,map);
            }

        }
        int sum = map.values().stream().mapToInt(Integer::intValue).sum();
        return sum;
    }

    private int FindPart(char[][] arr, int i, int j, Map<Map.Entry<Integer, Integer>, Integer> map) {
        for (int[] dir :
                directions) {
            Endpoints endpoints=  getEndpoints(arr,i,j,dir);
            if(endpoints!=null){
                String numberString = String.copyValueOf(arr[endpoints.row()], endpoints.start(), endpoints.end()- endpoints.start()+1);
                map.merge(entry(endpoints.row(), endpoints.start()),parseInt(numberString),Math::max);
            }
        }
        return map.size()==2 ? map.values().stream().reduce(1,Math::multiplyExact) :0;
    }

    private Endpoints getEndpoints(char[][] arr, int i, int j, int[] dir) {
        int row = i+dir[0];
        int col = j+dir[1];
        if (row< 0 ||col< 0||row>=arr.length || col>= arr[0].length|| !isDigit(arr[row][col]) ) return null;
        //go to beginning of number
        try {
            while (isDigit(arr[row][col-1])) col--;
        }catch (Exception e) {}
        int start = col;
        //record start and go to end of number
        try {
            while (isDigit(arr[row][col+1])) col++;
        }catch (Exception e) {}
        int end = col;
        return new Endpoints(row,start,end);
    }

    public int GetGearRatios(String input) {
//process input to a map
        var processedInput = Pattern.compile("\n").splitAsStream(input).map(String::toCharArray).toArray(char[][]::new);
        //Maps coordinates to characters
        //check each row by row for number
        int total = 0;
        for (int i = 0; i < processedInput.length; i++) {
            for (int j = 0; j < processedInput[i].length; j++) {
                //is there a gear?
                if (processedInput[i][j]=='*'){
                    Map<Map.Entry<Integer,Integer>,Integer> map = new HashMap<>();

                    total+= FindPart(processedInput,i,j,map);
                    System.out.println(String.format("currentTotal is %s",total));
                }

            }

        }
        return total;
    }

    private record Endpoints (int row, int start,int end){}
}
