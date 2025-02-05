package sb.adventofcode.twentyFour;

public class Day4WordSearcher {
    public int HowManyWords(String wordSearchString){
        char[][] wordSearchArray = parseWordSearch(wordSearchString);
        String word = "XMAS";
        var finds = FindWords(wordSearchArray,word);
        return finds;
    }

    private Integer FindWords(char[][] wordSearchArray, String word) {
        var wordCount = 0;
        for (int i = 0; i < wordSearchArray.length; i++) {
            for (int j = 0; j < wordSearchArray[i].length; j++) {
                //check if first letter.
                if (wordSearchArray[i][j]==word.charAt(0)){
                    wordCount+= searchAll(word,wordSearchArray, i , j);
                }
                //look in each direction
                //if second letter found, look ONLY IN THAT DIRECTION
            }
        }
        return wordCount;
    }

    private int searchAll(String word, char[][] wordSearchArray, int i, int j) {
//        needs the plus one to account for 0 index
        boolean spaceUp = i+1>=word.length();
        boolean spaceDown = wordSearchArray.length-i>=word.length();
        boolean spaceLeft = j+1>=word.length();
        boolean spaceRight = wordSearchArray[0].length-j>=word.length();
        var count = 0;
        if(spaceUp){
            count+=searchUp(word,wordSearchArray, i , j);
        }
        if(spaceUp&&spaceLeft){
            count+=searchUpLeft(word,wordSearchArray, i , j);
        }
        if(spaceUp && spaceRight){
            count+=searchUpRight(word,wordSearchArray, i , j);
        }
        if(spaceDown){
            count+=searchDown(word,wordSearchArray, i , j);
        }
        if(spaceDown&&spaceLeft){
            count+=searchDownLeft(word,wordSearchArray, i , j);
        }
        if(spaceDown && spaceRight){
            count+=searchDownRight(word,wordSearchArray, i , j);
        }
        if(spaceLeft){
            count+=searchLeft(word,wordSearchArray, i , j);
        }
        if(spaceRight){
            count+=searchRight(word,wordSearchArray, i , j);
        }
        return count;
    }

    private int searchRight(String word, char[][] wordSearchArray, int i, int j) {
        for (int k = 1; k < word.length(); k++) {
            if (wordSearchArray[i][j+k]!=word.charAt(k)){
                return 0;
            }
        }
        return 1;
    }

    private int searchLeft(String word, char[][] wordSearchArray, int i, int j) {
        for (int k = 1; k < word.length(); k++) {
            if (wordSearchArray[i][j-k]!=word.charAt(k)){
                return 0;
            }
        }
        return 1;
    }

    private int searchDownRight(String word, char[][] wordSearchArray, int i, int j) {
        for (int k = 1; k < word.length(); k++) {
            if (wordSearchArray[i+k][j+k]!=word.charAt(k)){
                return 0;
            }
        }
        return 1;
    }

    private int searchDownLeft(String word, char[][] wordSearchArray, int i, int j) {
        for (int k = 1; k < word.length(); k++) {
            if (wordSearchArray[i+k][j-k]!=word.charAt(k)){
                return 0;
            }
        }
        return 1;
    }

    private int searchDown(String word, char[][] wordSearchArray, int i, int j) {
        for (int k = 1; k < word.length(); k++) {
            if (wordSearchArray[i+k][j]!=word.charAt(k)){
                return 0;
            }
        }
        return 1;
    }


    private int searchUpRight(String word, char[][] wordSearchArray, int i, int j) {
        for (int k = 1; k < word.length(); k++) {
            if (wordSearchArray[i-k][j+k]!=word.charAt(k)){
                return 0;
            }
        }
        return 1;
    }

    private int searchUpLeft(String word, char[][] wordSearchArray, int i, int j) {
        for (int k = 1; k < word.length(); k++) {
            if (wordSearchArray[i-k][j-k]!=word.charAt(k)){
                return 0;
            }
        }
        return 1;
    }

    private int searchUp(String word, char[][] wordSearchArray, int i, int j) {
        //if we don't find second letter return 0, then continue check
        for (int k = 1; k < word.length(); k++) {
            if (wordSearchArray[i-k][j]!=word.charAt(k)){
                return 0;
            }
        }
        //if we made it through all checks return 1
        return 1;
    }

    private char[][] parseWordSearch(String wordSearchString) {
        var lines = wordSearchString.split("\n");
        char[][] res = new char[lines.length][lines[0].length()];
        for (int i = 0; i < lines.length; i++) {
            res[i] = lines[i].toCharArray();
        }
        return res;
    }
    public int HowManyXWords(String wordSearchString){
        //find the A
        //check for a Mas or sam on down diag, then up diag
        //if both are true, add to the count
        var wordSearchArray = parseWordSearch(wordSearchString);
        Integer finds = findXs(wordSearchArray);
        return finds;


    }

    private Integer findXs(char[][] wordSearchArray) {
        var wordCount = 0;
        for (int i = 0; i < wordSearchArray.length; i++) {
            for (int j = 0; j < wordSearchArray[i].length; j++) {
                //check if first letter.
                if (wordSearchArray[i][j]=='A'){
                    wordCount+= searchX(wordSearchArray, i , j);
                }
                //look in each direction
                //if second letter found, look ONLY IN THAT DIRECTION
            }
        }
        return wordCount;
    }
}
