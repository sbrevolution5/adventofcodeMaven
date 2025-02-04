package sb.adventofcode.seventeen.days;

public class day2 {
    public int GetChecksum(String input){
        int[][] spreadsheet = ParseInput(input);
        int sum = 0;
        for (int i = 0; i < 16; i++) {
            sum+= getChecksum(spreadsheet[i]);
        }
        return sum;
    }
    public int GetDivsum(String input) throws Exception {
        int[][] spreadsheet = ParseInput(input);
        int sum = 0;
        for (int i = 0; i < 16; i++) {
            sum+= getDivsum(spreadsheet[i]);
        }
        return sum;
    }

    private int getDivsum(int[] ints) throws Exception {
        for (int i = 0; i < ints.length-1; i++) {
            for (int j = i+1; j < ints.length; j++) {

                if (ints[j]%ints[i]==0){
                    return ints[j]/ints[i];
                }
                else if(ints[i]%ints[j]==0){
                    return ints[i]/ints[j];
                }
            }
        }
        throw new Exception();
    }

    private int getChecksum(int[] ints) {
        var high = Integer.MIN_VALUE;
        var low = Integer.MAX_VALUE;
        for (int anInt : ints) {
            if (anInt > high) {
                high = anInt;
            }
            if (anInt < low) {
                low = anInt;
            }
        }
        return high-low;
    }

    private int[][] ParseInput(String input) {
        var rows = input.split("\n");
        int[][] res = new int[16][16];
        for (int i = 0; i < rows.length; i++) {
            var row = rows[i];
            var rowSplit = row.split("\t");
            for (int j = 0; j < rows.length; j++) {
                res[i][j] = Integer.parseInt(rowSplit[j]);
            }
        }
        return res;
    }
}
