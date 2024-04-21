import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductReader {
    public static void main(String[] args) {
        String filename = "products.csv"; // Default CSV file name
        ArrayList<Product> products = readProductsFromFile(filename);
        for (Product product : products) {
            System.out.println("Name: " + product.getName() + ", Description: " + product.getDescription() +
                    ", ID: " + product.getID() + ", Cost: $" + product.getCost());
        }
    }
    public static ArrayList<Product> readProductsFromFile(String filename) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(",");
                if (data.length == 4) {
                    String name = data[0];
                    String description = data[1];
                    String ID = data[2];
                    double cost = Double.parseDouble(data[3]);
                    Product product = new Product(name, description, ID, cost);
                    products.add(product);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        return products;
    }
}
