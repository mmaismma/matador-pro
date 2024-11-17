/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusSearch extends JFrame {

    public BusSearch() {
        setTitle("Bus Search");
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);

        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(236, 87, 124));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        String[] loc1 = {"Katra", "Painthal", "SMVDU Naryana", "Dheerti", "Domail"};
        String[] loc2 = new String[loc1.length];
        for (int i = 0; i < loc1.length; i++) {
            loc2[i] = loc1[loc1.length - 1 - i];
        }
        JComboBox<String> fromDropdown = new JComboBox<>(loc1);
        JComboBox<String> toDropdown = new JComboBox<>(loc2);

        JLabel fromLabel = new JLabel("From");
//        fromLabel.setIcon(new ImageIcon("C:\\javaproj\\assest\\board.png")); 
        JLabel toLabel = new JLabel("To");
//        toLabel.setIcon(new ImageIcon("C:\\javaproj\\assest\\deboard.png"));
        JLabel dateLabel = new JLabel("Date");
//        dateLabel.setIcon(new ImageIcon("C:\\javaproj\\metador\\assest\\calander.png"));

        JTextField dateField = new JTextField("dd MM yy");
        dateField.setPreferredSize(new Dimension(100, 30));

        JButton searchButton = new JButton("SEARCH BUSES");
        searchButton.setPreferredSize(new Dimension(150, 50));
        searchButton.setBackground(new Color(211, 60, 67));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusPainted(false);

        // Add components to the panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(fromLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(fromDropdown, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(toLabel, gbc);
        gbc.gridx = 3;
        gbc.gridy = 0;
        panel.add(toDropdown, gbc);
        gbc.gridx = 4;
        gbc.gridy = 0;
        panel.add(dateLabel, gbc);
        gbc.gridx = 5;
        gbc.gridy = 0;
        panel.add(dateField, gbc);
        gbc.gridx = 6;
        gbc.gridy = 0;
        panel.add(searchButton, gbc);

        // Add panel to frame
        add(panel, BorderLayout.CENTER);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> new BusList().setVisible(true));
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 578, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    public static void main(String args[]) {
//            SwingUtilities.invokeLater(() -> new BusSearch());

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BusSearch().setVisible(true);
            }
        });
    }
}

// Variables declaration - do not modify                     
    // End of variables declaration
