package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class RideReview extends JFrame {

    public RideReview() {
        setTitle("Ride Review");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 350);
        setLayout(new BorderLayout());

        BackgroundPanel bg = new BackgroundPanel("src/main/resources/rr.jpg");
        bg.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Text area for comments
        JTextArea commentBox = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(commentBox);
        
        // Set the placeholder text
        commentBox.setText("Leave Your Comments Here ✍️");
        commentBox.setForeground(Color.magenta);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        bg.add(scrollPane, gbc);

        // Label for rating
        JLabel ratingLabel = new JLabel("Rate your ride:");
        ratingLabel.setFont(new Font("SansSerif", Font.BOLD, 16)); // Set bold font
        ratingLabel.setForeground(new Color(57, 255, 20)); 
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        bg.add(ratingLabel, gbc);

        // Star rating buttons
        ButtonGroup ratingGroup = new ButtonGroup();
        JPanel starPanel = new JPanel(new FlowLayout());
        for (int i = 1; i <= 5; i++) {
            JRadioButton starButton = new JRadioButton(String.valueOf(i));
            ratingGroup.add(starButton);
            starPanel.add(starButton);
        }
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        bg.add(starPanel, gbc);

        // Submit button
        JButton submitButton = new JButton("Submit");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        bg.add(submitButton, gbc);

        // Add ActionListener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the review text
                String reviewText = commentBox.getText();

                // Get the selected rating
                String selectedRating = null;
                for (Enumeration<AbstractButton> buttons = ratingGroup.getElements(); buttons.hasMoreElements(); ) {
                    AbstractButton button = buttons.nextElement();
                    if (button.isSelected()) {
                        selectedRating = button.getText();
                        break;
                    }
                }

                // Show confirmation dialog
                if (selectedRating == null) {
                    JOptionPane.showMessageDialog(
                            RideReview.this,
                            "Please select a rating.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                } else {
                            int res = JOptionPane.showConfirmDialog(
                            RideReview.this,
                            "Thank you for your feedback!\nRating: " + selectedRating + " stars\nReview: " + reviewText,
                            "Confirmation",
                            JOptionPane.OK_CANCEL_OPTION
                    );
                     // If OK is clicked, close the RideReview frame and open CompletedTrip frame
                    if (res == JOptionPane.OK_OPTION) {
                        dispose(); // Close RideReview frame
                    }
                }
            }
        });

        // Add panel to the frame
        add(bg, BorderLayout.CENTER);
        
        // Make the frame visible
        setVisible(true);
        this.setLocationRelativeTo(null);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new RideReview());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
// Custom JPanel class for the background

class BackgroundPanel extends JPanel {

    private Image bg;

    // Constructor to load the image
    public BackgroundPanel(String imagePath) {
        try {
            bg = new ImageIcon("src/main/resources/rr.jpg").getImage();
        } catch (Exception e) {
            System.err.println("Background image not found: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bg != null) {
            g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

