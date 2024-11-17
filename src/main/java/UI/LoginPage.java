package UI;
// hello mma
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPage extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JPanel mobilePanel;
    private JPanel otpPanel;

    public LoginPage() {
        setTitle("Login Page");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(new Color(255, 228, 196)); // Very pale orange

        mobilePanel = createMobilePanel();
        otpPanel = createOtpPanel();

        mainPanel.add(mobilePanel, "MobilePanel");
        mainPanel.add(otpPanel, "OtpPanel");

        add(mainPanel);
    }

    private JPanel createMobilePanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 228, 196)); // Very pale orange

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel loginLabel = new JLabel("Sign in");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(loginLabel, gbc);

        JLabel mobileLabel = new JLabel("Mobile Number:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(mobileLabel, gbc);

        JTextField mobileField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(mobileField, gbc);

        JButton getOtpButton = new JButton("Get OTP");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(getOtpButton, gbc);

        getOtpButton.addActionListener(e -> cardLayout.show(mainPanel, "OtpPanel"));

        JLabel createAccountLabel = new JLabel("<html><a href=''>Create Account</a></html>");
        createAccountLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        createAccountLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(() -> new RegisterPage().setVisible(true));
            }
        });
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(createAccountLabel, gbc);

        return panel;
    }

    private JPanel createOtpPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 228, 196)); // Very pale orange

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel loginLabel = new JLabel("Sign in");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(loginLabel, gbc);

        JLabel otpLabel = new JLabel("Enter OTP:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(otpLabel, gbc);

        JTextField otpField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(otpField, gbc);

        JButton loginButton = new JButton("Sign in");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        loginButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(() -> new ProfilePage().setVisible(true));
                dispose();
            }
        });
        panel.add(loginButton, gbc);

        JLabel createAccountLabel = new JLabel("<html><a href=''>Create Account</a></html>");
        createAccountLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        createAccountLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(() -> new RegisterPage().setVisible(true));
                dispose();
            }
        });
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(createAccountLabel, gbc);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginPage().setVisible(true));
    }
}
