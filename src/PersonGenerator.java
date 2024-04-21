import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        String filename = "persons.csv"; // Default CSV file name
        generateAndSavePersons(filename);
    }
    public static void generateAndSavePersons(String filename) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> persons = new ArrayList<>();
        boolean more = true;

        while (more) {
            System.out.println("Enter person details:");
            String firstName = SafeInput.getNonZeroLenString(scanner, "First Name");
            String lastName = SafeInput.getNonZeroLenString(scanner, "Last Name");
            String ID = SafeInput.getNonZeroLenString(scanner, "ID");
            String title = SafeInput.getNonZeroLenString(scanner, "Title");
            int YOB = SafeInput.getRangedInt(scanner, "Year Of Birth", 1940, 2000);

            persons.add(new Person(firstName, lastName, ID, title, YOB));

            more = SafeInput.getYNConfirm(scanner, "Do you want to add another person?");
        }

        // Write to file
        try (FileWriter writer = new FileWriter(filename)) {
            for (Person person : persons) {
                writer.write(person.toCSVDataRecord() + "\n");
            }
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
