package sb.adventofcode.twentythree.Days;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.lang.Character.isDigit;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class Day5 {
    private Map<Long, Long> seedSoil = new HashMap<>();
    private Map<Long, Long> soilFertilizer = new HashMap<>();
    private Map<Long, Long> fertilizerWater = new HashMap<>();
    private Map<Long, Long> waterLight = new HashMap<>();
    private Map<Long, Long> lightTemp = new HashMap<>();
    private Map<Long, Long> tempHumidity = new HashMap<>();
    private Map<Long, Long> humidityLocation = new HashMap<>();

//    public long FindLowestLocation(String input);
}
//WILL CRASH PC DO NOT RUN THIS ONE
   /* public long FindLowestLocation(String input) {
        var almanac = ProcessInput(input);
        //check all applicable almanac instructions,
        var lines = input.split("\n");
        var seeds = lines[0].split(":")[1].trim();
        var seedList = Arrays.stream(seeds.split(" +")).flatMapToLong(s -> LongStream.of(parseLong(s))).boxed().collect(Collectors.toList());

        //adjust based on instruction
        for (AlmanacInstruction i :
                almanac) {
            if (Objects.equals(i.title, "seed-to-soil map:")) {
                AlterMap(i, seedSoil);
            } else if (Objects.equals(i.title, "soil-to-fertilizer map:")) {
                AlterMap(i, soilFertilizer);
            } else if (Objects.equals(i.title, "fertilizer-to-water map:")) {
                AlterMap(i, fertilizerWater);
            } else if (Objects.equals(i.title, "water-to-light map:")) {
                AlterMap(i, waterLight);
            } else if (Objects.equals(i.title, "light-to-temperature map:")) {
                AlterMap(i, lightTemp);
            } else if (Objects.equals(i.title, "temperature-to-humidity map:")) {
                AlterMap(i, tempHumidity);
            } else if (Objects.equals(i.title, "humidity-to-location map:")) {
                AlterMap(i, humidityLocation);
            }
        }
        //once we have a map for each type of transition, we can decode with our maps using a nested formula to find the key destination.  i.e.
        // find location by hummap.get(tempmap.get(lightmap.get(watermap.get(fertilizermap.get(soilmap.get(seedmap.get(seedid)))))))))
        var seedLocations = new ArrayList<Long>();
        for (Long seedId :
                seedList) {
            seedLocations.add(FindSeedLocation(seedId));
        }
        var lowest = Long.MAX_VALUE;
        for (Long i :
                seedLocations) {
            if(i< lowest){
                lowest = i;
            }
        }
        return lowest;
    }

    private Long CheckMap(Long key, Map<Long, Long> map) {
        return map.get(key)!=null ? map.get(key):key;

    }

    private Long FindSeedLocation(Long seedId) {
        *//*var seed = seedId;
        var soil = CheckMap(seedId,seedSoil);
        System.out.println(String.format("soil number is %s for seed %s",soil, seed));
        var fert = 0;
        var water = 0;
        var light = 0;
        var temp = 0;
        var humidity = 0;
        var location = 0;*//*
        return
                CheckMap(
                        CheckMap(
                                CheckMap(
                                        CheckMap(
                                                CheckMap(
                                                        CheckMap(
                                                                CheckMap(seedId, seedSoil), soilFertilizer)
                                                        , fertilizerWater)
                                                , waterLight)
                                        , lightTemp)
                                , tempHumidity)
                        , humidityLocation);
    }

    private Map<Long, Long> AlterMap(AlmanacInstruction i, Map<Long, Long> map) {
        var x = i.source;
        for (int j = 0; j < i.range; j++) {
            map.put(i.source + j, i.dest + j);
        }
        return map;
    }


    private List<AlmanacInstruction> ProcessInput(String input) {
        var lines = input.split("\n");
        //make collections of each instruction, seedtosoil etc
        var instructionTitle = "";
        var instructionList = new ArrayList<AlmanacInstruction>();
        for (String s :
                lines) {
            if (s != "") {

                if (!isDigit(s.charAt(0))) {
                    instructionTitle = s;
                } else {

                    var instruct = new AlmanacInstruction();
                    instruct.title = instructionTitle;
                    var parts = s.split(" ");
                    instruct.source = parseLong(parts[1]);
                    instruct.dest = parseLong(parts[0]);
                    instruct.range = parseLong(parts[2]);
                    instructionList.add(instruct);
                }
            }
        }
        return instructionList;
    }

    private class AlmanacInstruction {
        public String title = "";
        public Long source = 0l;
        public Long dest = 0l;
        public Long range = 0l;
    }
}
*/