import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class GradeAnalyzerTest {
    @Test
    public void calculateAverage_returnsZero_whenListIsEmpty() {
        ArrayList<Integer> scores = new ArrayList<>();
        assertEquals(0.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    public void calculateAverage_returnsCorrectAverage_forTypicalScores() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(80, 90, 100));
        assertEquals(90.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    public void calculateAverage_returnsSingleValue_whenListHasOneItem() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(75));
        assertEquals(75.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    public void calculateAverage_returnsDouble_notInteger() {
        // 1 + 2 = 3, divided by 2 = 1.5, not 1
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(1, 2));
        assertEquals(1.5, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    public void calculateAverage_handlesAllSameValues() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(88, 88, 88));
        assertEquals(88.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    public void writeReport_createsFile_withCorrectContent() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(80, 90, 100));
        double average = GradeAnalyzer.calculateAverage(scores);
        int high = 100;
        int low = 80;
        String filename = "module2/test_report.txt";

        GradeAnalyzer.writeReport(scores, average, high, low, filename);

        // Read the file and check its content
        try (java.util.Scanner scanner = new java.util.Scanner(new java.io.File(filename))) {
            StringBuilder content = new StringBuilder();
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }
            String expectedContent = "Scores: [80, 90, 100]\nAverage: 90.0\nHigh: 100\nLow: 80\n";
            assertEquals(expectedContent.trim(), content.toString().trim());
        } catch (Exception e) {
            fail("Exception occurred while reading the report file: " + e.getMessage());
        }
    }

    @Test
    public void readScores_countsInvalidScores() {
        String filename = "module2/scores_invalid.txt";
        ArrayList<Integer> scores = GradeAnalyzer.readScores(filename);
        assertEquals(0, scores.size());
        assertEquals(7, GradeAnalyzer.invalidScoresCount);
    }

    @Test
    public void readScores_countsValidScores() {
        String filename = "module2/scores.txt";
        ArrayList<Integer> scores = GradeAnalyzer.readScores(filename);
        assertEquals(16, scores.size());
        assertEquals(5, scores.size() - GradeAnalyzer.invalidScoresCount);
    }
}