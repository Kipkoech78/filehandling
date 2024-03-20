import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Readfile {
    public static void main(String[] args) {
        String fileName = "data.txt";
        List<Integer> numbers = readFromFile(fileName);
        if (numbers != null) {
            System.out.println("Integers read from the file: ");
            displayNumbers(numbers);

        }
        System.out.println("sum is: " + add(numbers));
    }


    private static List<Integer> readFromFile(String fileName) {
        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                try {
                    int number = Integer.parseInt(line);
                    numbers.add(number);
                } catch (NumberFormatException e) {
                    System.err.println("Error: Non-integer data found at line " + lineNumber + ": " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File '" + fileName + "' not found.");
            System.exit(1); // Terminate the program gracefully
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            System.exit(1); // Terminate the program gracefully
        }

        return numbers;
    }
    private static void displayNumbers(List<Integer> numbers){
        for(int num : numbers){
            System.out.println(num);
        }
    }
    private static int add(List<Integer> numbers){
        int sum = 0;
        for(int num : numbers){
            sum += num;

        }
        return sum;



    }
}
