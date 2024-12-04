package app;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MatadorPro {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize FlatLaf");
        }
        javax.swing.SwingUtilities.invokeLater(() -> new ui.Home().setVisible(true));
    }
}
