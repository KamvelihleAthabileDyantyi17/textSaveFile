import java.io.*;
import java.util.Scanner;

public class FileReadWrite {

    public static void writeToField(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("Content written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static String readFromFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            System.out.println("Reading from file completed.");
            return content.toString().trim(); // Remove trailing newline
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
            return null; // Indicate error by returning null
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input file name
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();

        // Input content to write to the file
        System.out.print("Enter content to write to the file: ");
        String content = scanner.nextLine();

        // Write content to the file
        writeToField(fileName, content);

        // Read content from the file
        String fileContent = readFromFile(fileName);
        if (fileContent != null) {
            System.out.println("Content read from file:");
            System.out.println(fileContent);
        }

        scanner.close();
    }
}