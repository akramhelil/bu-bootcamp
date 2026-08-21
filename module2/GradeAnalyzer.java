import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.Collections;

public class GradeAnalyzer {

    public static int totalScoresCount = 0;
    public static int invalidScoresCount = 0;

    public static void main(String[] args) {
        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores(args[0]);
        // ArrayList<Integer> scores2 = new ArrayList<>(Arrays.asList(90, 23, 45, 67,
        // 89, 100));

        // Step 2: calculate statistics
        double average = calculateAverage(scores);
        double high = scores.isEmpty() ? 0 : Collections.max(scores);
        double low = scores.isEmpty() ? 0 : Collections.min(scores);
        System.out.println("Average: " + average);
        System.out.println("High: " + high);
        System.out.println("Low: " + low);
        // Step 3: write and print report
        writeReport(scores, average, (int) high, (int) low, "report.txt");
    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                try {
                    int score = Integer.parseInt(line.trim());
                    scores.add(score);
                    totalScoresCount++;
                    System.out.println("Read score: " + score);
                } catch (NumberFormatException e) {
                    invalidScoresCount++;
                    System.out.println("Warning: Invalid score format: " + line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: exception reading file: " + e.getMessage());
        }
        System.out.println("Total valid scores read: " + scores.size());
        System.out.println("Total invalid scores read: " + invalidScoresCount);

        return scores;
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        System.out.println("Sum of scores: " + sum);
        System.out.println("Number of scores: " + scores.size());
        System.out.println("Average score: " + (double) sum / scores.size());
        return (double) sum / scores.size();
    }

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
            double avg, int high, int low,
            String outputFile) {

        if (scores.isEmpty()) {
            System.out.println("No valid scores to report.");
            writeReportToFile(avg, high, low, 0, 0, 0, 0, 0);
            return;
        }

        int countA, countB, countC, countD, countF;
        countA = countB = countC = countD = countF = 0;

        for (int score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80 && score < 90) {
                countB++;
            } else if (score >= 70 && score < 80) {
                countC++;
            } else if (score >= 60 && score < 70) {
                countD++;
            } else {
                countF++;
            }
        }
        System.out.println("=== Grade Analysis Report ===");
        System.out.println("Total Scores Processed: " + totalScoresCount);
        System.out.println("Invalid Scores skipped: " + invalidScoresCount);
        System.out.println("Average Score: " + avg);
        System.out.println("Highest Score: " + high);
        System.out.println("Lowest Score: " + low);

        System.out.println("A (90-100): " + countA);
        System.out.println("B (80-89): " + countB);
        System.out.println("C (70-79): " + countC);
        System.out.println("D (60-69): " + countD);
        System.out.println("F (below 60): " + countF);

        try {
            writeReportToFile(avg, high, low, countA, countB, countC, countD, countF);
        } catch (Exception e) {
            System.out.println("Error writing report to file: " + e.getMessage());
        }

    }

    private static void writeReportToFile(double avg, int high, int low, int countA, int countB, int countC, int countD,
            int countF) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt"));
            writer.write("=== Grade Analysis Report ===\n");
            writer.write("Total Scores Processed: " + totalScoresCount + "\n");
            writer.write("Invalid Scores skipped: " + invalidScoresCount + "\n");
            writer.newLine();
            writer.write("Average Score: " + avg + "\n");
            writer.write("Highest Score: " + high + "\n");
            writer.write("Lowest Score: " + low + "\n");
            writer.newLine();
            writer.write("Grade Distribution:\n");
            writer.write("A (90-100): " + countA + "\n");
            writer.write("B (80-89): " + countB + "\n");
            writer.write("C (70-79): " + countC + "\n");
            writer.write("D (60-69): " + countD + "\n");
            writer.write("F (below 60): " + countF + "\n");
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: writeReportToFile method writing report to file: " + e.getMessage());
        }
    }
}
