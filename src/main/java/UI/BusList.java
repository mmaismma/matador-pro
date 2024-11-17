/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class BusList extends JFrame {

    public BusList() {
        setTitle("Available Buses");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(0, 1, 10, 10)); // Grid layout for evenly spaced components

        // Sample bus data
        String[][] busData = {
            {"Bus 1", "10:00 AM"},
            {"Bus 2", "12:30 PM"},
            {"Bus 3", "3:15 PM"},
            {"Bus 4", "5:45 PM"}
        };

        for (String[] bus : busData) {
            JPanel busInfoPanel = new JPanel();
            busInfoPanel.setLayout(new GridBagLayout());
            busInfoPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            busInfoPanel.setBackground(Color.WHITE);
            busInfoPanel.setPreferredSize(new Dimension(450, 50));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.anchor = GridBagConstraints.WEST;

            JLabel busNameLabel = new JLabel(bus[0]);
            JLabel busTimeLabel = new JLabel(" - Departure: " + bus[1]);
            JButton bookButton = new JButton("BOOK");
            bookButton.setBackground(new Color(100, 149, 237)); // Light blue color
            bookButton.setForeground(Color.WHITE);
            bookButton.setFocusPainted(false);
            bookButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "You have booked " + bus[0] + " departing at " + bus[1] + ".");
                }
            });

            gbc.gridx = 0;
            gbc.gridy = 0;
            busInfoPanel.add(busNameLabel, gbc);
            gbc.gridx = 1;
            gbc.gridy = 0;
            busInfoPanel.add(busTimeLabel, gbc);
            gbc.gridx = 2;
            gbc.gridy = 0;
            busInfoPanel.add(bookButton, gbc);

            add(busInfoPanel);
        }

        setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new BusList());
    }
}
