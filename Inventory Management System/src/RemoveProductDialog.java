import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RemoveProductDialog extends JDialog {
    private JTextField productIdField;
    private JButton removeButton;

    public RemoveProductDialog() {
        setTitle("Remove Product");
        setSize(300, 150);
        setLayout(new FlowLayout());

        JLabel productIdLabel = new JLabel("Product ID:");
        productIdField = new JTextField(15);
        removeButton = new JButton("Remove Product");

        add(productIdLabel);
        add(productIdField);
        add(removeButton);

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productId = productIdField.getText();
                if (!productId.isEmpty()) {
               
                    int response = JOptionPane.showConfirmDialog(RemoveProductDialog.this, 
                            "Are you sure you want to delete this product?", 
                            "Confirm Deletion", 
                            JOptionPane.YES_NO_OPTION);

                 if (response == JOptionPane.YES_OPTION) {
                    try (Connection connection = DatabaseConnection.getConnection()) {
                    	String sql = "DELETE FROM products WHERE product_id = ?";
                          try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                              stmt.setString(1, productId);
                              int rowsAffected = stmt.executeUpdate();
                              if (rowsAffected > 0) {
                                  JOptionPane.showMessageDialog(RemoveProductDialog.this, "Product Removed!");
                                } 
                              else {
                                    JOptionPane.showMessageDialog(RemoveProductDialog.this, "No product found with the provided ID.");
                                }
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(RemoveProductDialog.this, "Error while removing product: " + ex.getMessage());
                        }
                        dispose();                      }
                } else {
                    JOptionPane.showMessageDialog(RemoveProductDialog.this, "Please enter a Product ID.");
                }
            }
        });
        setVisible(true);
    }
}
