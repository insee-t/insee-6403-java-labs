package thaopech.insee.lab11;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A class that extends MobileDeviceComplete and implements ActionListener.
 * It adds event listeners to text fields and responds to user input.
 */
public class MobileDeviceCompleteV2 extends MobileDeviceComplete implements ActionListener {

    /**
     * Constructor that initializes the MobileDeviceCompleteV2 with a title.
     *
     * @param title The title of the window.
     */
    public MobileDeviceCompleteV2(String title) {
        super(title);
    }

    /**
     * Adds action listeners to the input fields.
     */
    protected void addListeners() {
        deviceNameField.addActionListener(this);
        brandField.addActionListener(this);
        priceField.addActionListener(this);
    }

    /**
     * Handles action events triggered by user input in text fields.
     *
     * @param e The action event triggered by user interaction.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deviceNameField) {
            JOptionPane.showMessageDialog(this, "You pressed Enter in Device Name field: " + deviceNameField.getText());
        } else if (e.getSource() == brandField) {
            JOptionPane.showMessageDialog(this, "Brand field says: " + brandField.getText());
        } else if (e.getSource() == priceField) {
            JOptionPane.showMessageDialog(this, "Price entered: " + priceField.getText());
        }
    }

    /**
     * The main method that launches the application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    /**
     * Creates and displays the graphical user interface.
     */
    public static void createAndShowGUI() {
        MobileDeviceCompleteV2 window = new MobileDeviceCompleteV2("Mobile Device Complete V2");
        window.addComponents();
        window.addMenus();
        window.addListeners(); 
        window.setFrameFeatures();
    }
}