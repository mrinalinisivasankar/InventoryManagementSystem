import javax.swing.*;
import java.awt.*;

public class UpdateProductDialog extends JDialog {
    public UpdateProductDialog() {
        setTitle("Update Product");
        setSize(300, 250);
        setLayout(new FlowLayout());

        JLabel idLabel = new JLabel("Product ID:");
        JTextField idField = new JTextField(15);
        JLabel nameLabel = new JLabel("New Name:");
        JTextField nameField = new JTextField(15);
        JLabel priceLabel = new JLabel("New Price:");
        JTextField priceField = new JTextField(15);
        JLabel quantityLabel = new JLabel("New Quantity:");
        JTextField quantityField = new JTextField(15);

        JButton updateButton = new JButton("Update Product");

        add(idLabel);
        add(idField);
        add(nameLabel);
        add(nameField);
        add(priceLabel);
        add(priceField);
        add(quantityLabel);
        add(quantityField);
        add(updateButton);

        updateButton.addActionListener(e -> {
            String productId = idField.getText().trim();
            String newName = nameField.getText().trim();
            String newPriceText = priceField.getText().trim();
            String newQuantityText = quantityField.getText().trim();

            // Validate input
            if (productId.isEmpty() || newName.isEmpty() || newPriceText.isEmpty() || newQuantityText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                // Parse price and quantity
                double newPrice = Double.parseDouble(newPriceText);
                int newQuantity = Integer.parseInt(newQuantityText);
                
                int response = JOptionPane.showConfirmDialog(this,
                        "Are you sure you want to update this product?",
                        "Confirm Update",
                        JOptionPane.YES_NO_OPTION);

                if (response == JOptionPane.YES_OPTION) {
                    try {
                        // Update the product in the database
                        ProductDatabase.updateProduct(new Product(productId, newName, newPrice, newQuantity));
                        JOptionPane.showMessageDialog(this, "Product updated successfully!");
                        dispose(); 
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this,
                                "Error updating product: " + ex.getMessage(),
                                "Database Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Price and Quantity must be valid numbers!",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
