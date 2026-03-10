import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    
    public void addProduct(Product product) {
        products.add(product);
    }

 
    public void removeProduct(String productId) {
        products.removeIf(product -> product.getProductId().equals(productId));
    }

    // Get a product by its ID
    public Product getProduct(String productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null; // If no product is found
    }

    // Update a product (e.g., update price, name, or ID)
    public boolean updateProduct(String productId, String newId, String newName, double newPrice) {
        Product product = getProduct(productId);
        if (product != null) {
            product.setProductId(newId);
            product.setName(newName);
            product.setPrice(newPrice);
            return true;
        }
        return false;
    }

    // Display all products in the inventory
    public List<Product> getAllProducts() {
        return products;
    }
}
