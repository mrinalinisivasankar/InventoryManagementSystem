import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {

    public static void addProduct(Product product) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO products (product_id, name, price, quantity) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, product.getProductId());
                stmt.setString(2, product.getName());
                stmt.setDouble(3, product.getPrice());
                stmt.setInt(4, product.getQuantity());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM products";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    Product product = new Product(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                    );
                    products.add(product);
                }
            }
        } catch (SQLException e) {
        	System.out.println("Error while adding product to database: " + e.getMessage());
            e.printStackTrace();
        }
        return products;
    }

    public static void updateProduct(Product product) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE products SET name = ?, price = ?, quantity = ? WHERE product_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, product.getName());
                stmt.setDouble(2, product.getPrice());
                stmt.setInt(3, product.getQuantity());
                stmt.setString(4, product.getProductId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void removeProduct(String productId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM products WHERE product_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, productId);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
