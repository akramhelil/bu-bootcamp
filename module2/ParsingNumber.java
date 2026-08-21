import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ParsingNumber {

    public static void numParser(String num) {

        if (num == null || num.isEmpty()) {
            System.out.println("Input is null or empty");
            return;
        }

        if (num.contains(".")) {
            System.out.println("Input is a decimal number: " + num);
            parseDecimal(num);
            return;
        }

        try {
            int number = Integer.parseInt(num);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + num);
        }
    }

    private static void parseDecimal(String num) {
        double decimalNumber = Double.parseDouble(num);
        System.out.println("Parsed decimal number: " + decimalNumber);
    }

    public static void readingLines(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numParser(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        readingLines("numbers.txt");
    }
}