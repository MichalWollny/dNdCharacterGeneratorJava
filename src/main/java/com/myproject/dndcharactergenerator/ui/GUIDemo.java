package main.java.com.myproject.dndcharactergenerator.ui;

import javax.swing.*;

public class GUIDemo {
    public static void main(String[] args) {
        // Sicherstellen, dass die GUI-Erstellung im Event-Dispatch-Thread erfolgt
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        // Erstellen eines neuen Fensters (JFrame)
        JFrame frame = new JFrame("HelloWorldGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Erstellen eines Labels mit der Nachricht "Hello, World!"
        JLabel label = new JLabel("Hello, World!", JLabel.CENTER);

        // Hinzufügen des Labels zum Fenster
        frame.getContentPane().add(label);

        // Fenstergröße anpassen und sichtbar machen
        frame.setSize(300, 100);
        frame.setVisible(true);
    }
}
