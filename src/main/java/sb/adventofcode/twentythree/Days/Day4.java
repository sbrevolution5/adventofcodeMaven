package sb.adventofcode.twentythree.Days;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

public class Day4 {
    public int GetScratcherScore(String input) {
        List<Scratcher> scratchers = ProcessInput(input);
        for (Scratcher s :
                scratchers) {
            s.CalculateScore();
        }
        return scratchers.stream().mapToInt(Scratcher::getScore).sum();
    }

    private ArrayList<Scratcher> ProcessInput(String input) {
        var list = input.split("\n");
        var res = new ArrayList<Scratcher>();
        for (String scratchString :
                list) {
            res.add(MakeScratcher(scratchString));
        }
        return res;
    }

    public int GetFinalCardCount(String input) {
        List<Scratcher> scratchers = ProcessInput(input);
        Map<Integer, Integer> map = new HashMap<>();
        for (Scratcher s :
                scratchers) {
            map.merge(s.CardNumber, 1, Integer::sum);
            s.CalculateWins();
        }
        for (Scratcher s :
                scratchers) {


            //System.out.println(String.format("Card Number %s has %s wins",s.CardNumber,s.Wins));
            for (int i = 1; i <= s.Wins; i++) {
                var card = s.CardNumber+i;
                map.merge(card, map.get(s.CardNumber), Integer::sum);
            }

        }
        return map.values().

                stream().

                mapToInt(Integer::intValue).

                sum();
    }

    private Scratcher MakeScratcher(String scratchString) {
        var res = new Scratcher();
        var parts = scratchString.split("[:|]");
        res.CardNumber = parseInt(parts[0].trim().split(" +")[1].trim());
        var winarray = Arrays.stream(parts[1].trim().split(" ")).filter(s -> s.trim() != "").flatMapToInt(s -> IntStream.of(parseInt(s.trim())));
        res.Winners = winarray.boxed().collect(Collectors.toList());
        var myarray = Arrays.stream(parts[2].trim().split(" ")).filter(s -> s.trim() != "").flatMapToInt(s -> IntStream.of(parseInt(s.trim())));
        res.MyNumbers = myarray.boxed().collect(Collectors.toList());
        return res;
    }

    ;

    private class Scratcher {
        public int CardNumber;
        public List<Integer> Winners;
        public List<Integer> MyNumbers;
        public Integer Score = 0;

        public Integer getScore() {
            return Score;
        }

        public void CalculateScore() {
            for (Integer n :
                    MyNumbers) {
                if (Winners.contains(n)) {
                    if (Score == 0) {
                        Score = 1;
                    } else {
                        Score = Score * 2;
                    }
                }
            }
        }

        public Integer Wins = 0;

        public void CalculateWins() {
            for (Integer n :
                    MyNumbers) {
                if (Winners.contains(n)) {
                    Wins++;
                }
            }
        }
    }
}
