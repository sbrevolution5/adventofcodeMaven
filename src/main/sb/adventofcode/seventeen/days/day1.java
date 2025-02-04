package sb.adventofcode.seventeen.days;

public class day1 {
    public int Max = 0;
    public int Half = 0;
    public int GetPart2(String input){
        int[] ints = ParseInput(input);
        int sum = 0;
        int i = 0;
        while(i<Half){
            if (DoesHalfMatch(ints,i)){
                sum+=(ints[i]*2);
            }
            i++;
        }
        return sum;
    }
    public int GetSolution(String input){
        int[] ints = ParseInput(input);
        int sum =0;
        int i =0;
        while(i<ints.length){
            var count = HowManyMatches(ints,i);
            sum+= ints[i]*count;
            i+=count+1;
        }
        return sum;
    }

    private int[] ParseInput(String input) {
        var chars = input.split("");
        Max = input.length();
        Half = Max/2;
        int[] res = new int[chars.length];
        for (int i = 0; i < chars.length; i++){
            res[i] = Integer.parseInt(chars[i]);
        }
        return res;
    }
    public int HowManyMatches(int[] arr, int idx){
        int toMatch = arr[idx];
        int res = 0;
        if (idx == Max-1){
            idx= -1;
        }
        while(arr[idx+1] == toMatch){
            idx++;
            res++;
        }
        return res;
    }
    public boolean DoesHalfMatch(int[] arr, int idx){
        int toMatch = arr[idx];
        int other = arr[idx+Half];
        return toMatch==other;
    }

}
