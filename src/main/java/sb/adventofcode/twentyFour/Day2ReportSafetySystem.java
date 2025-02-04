package sb.adventofcode.twentyFour;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

public class Day2ReportSafetySystem {
    public void HowManyAreSafe() {
        //Get Input
        var reportList = ProcessInputs(Inputs24.day2Input);
        // check if all up down
        ArrayList<ArrayList<Integer>> safeReports = new ArrayList<>();
        for (var report : reportList) {
            if (isSafe(report)) {
                safeReports.add(report);
            }
            else{
                for (int i = 0; i < report.size(); i++) {
                    var newReport= new ArrayList<Integer>(report);
                    newReport.remove(i);
                    if(isSafe(newReport)){
                        safeReports.add(report);
                        break;
                    }
                }
            }
        }
        System.out.println("Number of safe reports:");
        System.out.println(safeReports.size());
        //write number of safe reports
    }

    private boolean isSafe(ArrayList<Integer> report) {
        //check for if first is up or down
        var safe = false;
        if (report.get(1) > report.get(0)) {
            //check ascending
            if (isAscending(report)) {
                return isSlow(report);
            }
        } else if (report.get(1) < report.get(0)) {
            //check descending (reuse above?)
            if (isDescending(report)) {
                return isSlow(report);
            }
        }
        return false;
    }

    private static boolean isDescending(ArrayList<Integer> report) {
        for (int i = 1; i < report.size(); i++) {
            if (report.get(i) > report.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSlow(ArrayList<Integer> report) {
        for (int i = 1; i < report.size(); i++) {
            int diff = abs(report.get(i) - report.get(i - 1));
            if (diff > 3 || diff == 0) {
                return false;
            }

        }
        return true;
    }

    private static boolean isAscending(ArrayList<Integer> report) {
        for (int i = 1; i < report.size(); i++) {
            if (report.get(i) < report.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<ArrayList<Integer>> ProcessInputs(String input) {
        ArrayList<ArrayList<Integer>> reportList = new ArrayList<ArrayList<Integer>>();

        for (String line : input.split("\n")) {
            var nums = line.split(" ");
            ArrayList<Integer> report = new ArrayList<>();
            for (String rawNum : nums) {
                report.add(parseInt(rawNum));
            }
            reportList.add(report);
        }
        System.out.println(reportList);
        return reportList;
    }

}
