import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator {
    public static void main(String[] args) {
        String filename = "products.csv"; // Default CSV file name
        generateAndSaveProducts(filename);
    }
    public static void generateAndSaveProducts(String filename) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        boolean more = true;

        while (more) {
            System.out.println("Enter product details:");
            String name = SafeInput.getNonZeroLenString(scanner, "Product Name");
            String description = SafeInput.getNonZeroLenString(scanner, "Description");
            String ID = SafeInput.getNonZeroLenString(scanner, "Product ID");
            double cost = SafeInput.getDouble(scanner, "Cost");

            products.add(new Product(name, description, ID, cost));

            more = SafeInput.getYNConfirm(scanner, "Do you want to add another product?");
        }

        // Write to file
        try (FileWriter writer = new FileWriter(filename)) {
            for (Product product : products) {
                writer.write(product.toCSVDataRecord() + "\n");
            }
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
