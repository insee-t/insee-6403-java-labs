package thaopech.insee.lab8;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * A simple Swing-based GUI window with "OK" and "Cancel" buttons.
 * This class extends JFrame and provides basic UI components and functionality.
 * @author Insee Thaopech
 * @version 1.0
 */

public class MySimpleWindow extends JFrame {
    protected JFrame frame;
    protected JButton cancelButton, okButton;
    protected JPanel mainPanel, buttonPanel;

    /**
     * Constructor that sets the window title.
     * @param title The title of the window.
     */
    public MySimpleWindow(String title) {
        super(title);
    }

    /**
     * Initializes and adds components to the window.
     * This includes a main panel and a button panel with "OK" and "Cancel" buttons.
     */
    protected void addComponents() {
        cancelButton = new JButton("Cancel");
        okButton = new JButton("OK");

        mainPanel = new JPanel(new BorderLayout());
        buttonPanel = new JPanel();

        // Add buttons to the button panel
        buttonPanel.add(cancelButton);
        buttonPanel.add(okButton);

        // Add the button panel to the main panel at the bottom (SOUTH)
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Set the main panel as the content pane
        this.setContentPane(mainPanel);
    }

    /**
     * Configures window settings such as default close operation,
     * visibility, and positioning.
     */
    protected void setFrameFeatures() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack(); // Adjusts the window size to fit its components
        this.setLocationRelativeTo(null); // Centers the window on the screen
    }

    /**
     * Main method to run the application in a separate thread
     * using SwingUtilities to ensure thread safety.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    /**
     * Creates an instance of MySimpleWindow and initializes it.
     */
    public static void createAndShowGUI() {
        MySimpleWindow msw = new MySimpleWindow("My Simple Window");
        msw.addComponents();
        msw.setFrameFeatures();
    }
}
