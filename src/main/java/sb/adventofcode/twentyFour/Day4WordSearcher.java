package sb.adventofcode.twentyFour;

import java.util.ArrayList;

public class Day4WordSearcher {
    public int HowManyWords(String wordSearchString){
        ArrayList<char[]> wordSearchArray = new ArrayList<>();
        wordSearchArray = parseWordSearch(wordSearchString);
        return 0;
    }

    private ArrayList<char[]> parseWordSearch(String wordSearchString) {
        var lines = wordSearchString.split("\n");
        ArrayList<char[]> res = new ArrayList<>();
        for(String line: lines){
            var lineList = line.toCharArray();
            res.add(lineList);
        }
        return res;
    }
}
