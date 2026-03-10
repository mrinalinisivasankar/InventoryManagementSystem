import javax.swing.*;
import java.awt.*;

public class InventoryGUI extends JFrame {
    private JButton addButton;
    private JButton removeButton;
    private JButton updateButton;
    private JButton exitButton;

    public InventoryGUI() {
        setTitle("Inventory Management System");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Title and Subtitle Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("INVENTORY MANAGEMENT SYSTEM");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitleLabel = new JLabel("Please select a button");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        titlePanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacing
        titlePanel.add(titleLabel);
        titlePanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing
        titlePanel.add(subtitleLabel);
        titlePanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacing

        // Buttons Panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        addButton = new JButton("Add Product");
        removeButton = new JButton("Remove Product");
        updateButton = new JButton("Update Product");
        exitButton = new JButton("Exit");


        buttonsPanel.add(addButton);
        buttonsPanel.add(removeButton);
        buttonsPanel.add(updateButton);
        buttonsPanel.add(exitButton);
        
     // Add Panels to Frame
        add(titlePanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.CENTER);
    

        addButton.addActionListener(e -> new AddProductDialog());

        removeButton.addActionListener(e -> new RemoveProductDialog());

        updateButton.addActionListener(e -> new UpdateProductDialog());

        exitButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to exit?",
                    "Confirm Exit",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0); // Exit the program
            }
        });

      

        setVisible(true);
    }

}