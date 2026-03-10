import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginScreen() {
        setTitle("Login Screen");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); 
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();
                
                // Perform login validation
                if (username.equals("rina") && password.equals("password")) {
                    JOptionPane.showMessageDialog(LoginScreen.this, "Login successful!");
                    new InventoryGUI(); // open main GUI after login
                    setVisible(false); // hide login screen
                } else {
                    JOptionPane.showMessageDialog(LoginScreen.this, "Invalid credentials. Try again.");
                }
            }
        });
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginScreen();
    }
}

