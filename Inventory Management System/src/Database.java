import java.io.*;
import java.util.*;

public class Database {
    private static final String INVENTORY_FILE = "inventory.dat";

    // Save inventory to a file
    public static void saveInventory(List<Product> products) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(INVENTORY_FILE))) {
            out.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load inventory from a file
    public static List<Product> loadInventory() {
        List<Product> products = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(INVENTORY_FILE))) {
            products = (List<Product>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }

}
