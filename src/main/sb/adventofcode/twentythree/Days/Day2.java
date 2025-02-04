package sb.adventofcode.twentythree.Days;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Day2 {

    public int SumOfPossibleRounds(String input){
        ArrayList<Game> games = ProcessInput(input);
        for (Game g :
                games) {
            for (Round r :
                    g.rounds) {
                if(r.Green>13 || r.Blue >14 || r.Red>12){
                    g.Possible = false;
                    break;
                }
            }
        }
        var possibleGames = games.stream().filter(g-> g.Possible).collect(Collectors.toList());
        var sum = 0;
        for (Game g :
                possibleGames) {
            sum += g.GameId;
        }
        return sum;
    }
    public int MinimumCubesPowerSum(String input){
        ArrayList<Game> games = ProcessInput(input);
        var sum = 0;
        for (Game g :
                games) {
            for (Round r :
                    g.rounds) {
                if (r.Red>g.RedMin){
                    g.RedMin = r.Red;
                }
                if(r.Blue>g.BlueMin){
                    g.BlueMin = r.Blue;
                }
                if (r.Green>g.GreenMin){
                    g.GreenMin = r.Green;
                }
            }
            g.Power = g.BlueMin*g.RedMin*g.GreenMin;
            sum += g.Power;
        }
    return sum;
    }

    private ArrayList<Game> ProcessInput(String input) {
        ArrayList<Game> games = new ArrayList<>();
        for (String line :
                input.split("\n")) {
            Game g = new Game();
            String l = line.substring(5);
            g.GameId = parseInt(l.split(":")[0]);
            g.rounds = new ArrayList<>();
            var rounds = l.split(":")[1].split(";");
            for (String round :
                    rounds) {
                var currentRound = new Round();
                var colors = round.split(",");
                for (String c :
                        colors) {
                    c=c.trim();
                    if (c.contains("red")){
                        currentRound.Red = parseInt(c.split(" ")[0]);
                    }
                    else if (c.contains("blue")){
                        currentRound.Blue = parseInt(c.split(" ")[0]);
                    }
                    else if (c.contains("green")){
                        currentRound.Green = parseInt(c.split(" ")[0]);
                    }
                }
                g.rounds.add(currentRound);

            }
            games.add(g);
        }
        return games;
    }

    public static class Game {
        public int GameId;
        public ArrayList<Round> rounds;
        public boolean Possible = true;
        public int RedMin = Integer.MIN_VALUE;
        public int BlueMin = Integer.MIN_VALUE;
        public int GreenMin = Integer.MIN_VALUE;
        public int Power = 0;
    }

    public static class Round {
        public int Red= Integer.MIN_VALUE;
        public int Green = Integer.MIN_VALUE;
        public int Blue= Integer.MIN_VALUE;
    }
}
