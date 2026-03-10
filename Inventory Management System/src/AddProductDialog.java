import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductDialog extends JDialog {
    private JTextField idField;
    private JTextField nameField;
    private JTextField priceField;
    private JTextField quantityField;
    private JButton addButton;

    public AddProductDialog() {
        setTitle("Add Product");
        setSize(300, 250);
        setLayout(new FlowLayout());

        JLabel idLabel = new JLabel("Product ID:");
        idField = new JTextField(15);
        JLabel nameLabel = new JLabel("Product Name:");
        nameField = new JTextField(15);
        JLabel priceLabel = new JLabel("Price:");
        priceField = new JTextField(15);
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField(15);

        addButton = new JButton("Add Product");

        // Add components to the dialog
        add(idLabel);
        add(idField);
        add(nameLabel);
        add(nameField);
        add(priceLabel);
        add(priceField);
        add(quantityLabel);
        add(quantityField);
        add(addButton);

        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get values from the input fields
                String productId = idField.getText();
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());
                int quantity = Integer.parseInt(quantityField.getText());
                
                if (productId.isEmpty() || name.isEmpty() || price <= 0 || quantity <= 0) {
                    JOptionPane.showMessageDialog(AddProductDialog.this, "Please enter valid product details.");
                    return;  // Exit the method without adding the product
                }


               
                Product newProduct = new Product(productId, name, price, quantity);

                // Save the product to the database
                ProductDatabase.addProduct(newProduct);

              
                JOptionPane.showMessageDialog(AddProductDialog.this, "Product added successfully!");

                // Close the dialog
                dispose();
            }
        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
