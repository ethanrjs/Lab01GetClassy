import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonReader {
    public static void main(String[] args) {
        String filename = "persons.csv"; // Default CSV file name
        ArrayList<Person> persons = readPersonsFromFile(filename);
        for (Person person : persons) {
            System.out.println("Name: " + person.fullName() + ", ID: " + person.getID() +
                    ", Title: " + person.getTitle() + ", Year of Birth: " + person.getYOB());
        }
    }
    public static ArrayList<Person> readPersonsFromFile(String filename) {
        ArrayList<Person> persons = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(",");
                if (data.length == 5) {
                    String firstName = data[0];
                    String lastName = data[1];
                    String ID = data[2];
                    String title = data[3];
                    int YOB = Integer.parseInt(data[4]);
                    Person person = new Person(firstName, lastName, ID, title, YOB);
                    persons.add(person);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        return persons;
    }
}
