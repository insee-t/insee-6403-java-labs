/**
 * MobileDeviceV12 extends MobileDeviceV11 by enhancing user interactions.
 * It adds event listeners to text fields, validates user input, and ensures
 * a smooth user experience when entering device details such as name, brand,
 * and price. Numeric validation is enforced on price input.
 *
 * This class also displays meaningful messages based on user input and guides
 * the user through the form-filling process.
 *
 * @author Insee Thaopech
 * @version 1.2
 */
package thaopech.insee.lab12;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * MobileDeviceV12 class extends MobileDeviceV11 and introduces additional input validation.
 */
public class MobileDeviceV12 extends thaopech.insee.lab10.MobileDeviceV11 {

    /**
     * Constructor for MobileDeviceV12, initializing the frame with a title.
     *
     * @param title The title of the application window.
     */
    public MobileDeviceV12(String title) {
        super(title);
    }

    /**
     * Overrides addListeners to include additional event listeners for text fields.
     */
    @Override
    public void addListeners() {
        super.addListeners(); // Retain parent class listeners (e.g., radio buttons)

        // Add ActionListener to text fields
        getDeviceNameField().addActionListener(this);
        getBrandField().addActionListener(this);
        getPriceField().addActionListener(this);

        // Set names for the text fields to display meaningful messages
        getDeviceNameField().setName("Device Name");
        getBrandField().setName("Brand");
        getPriceField().setName("Price");
    }

    /**
     * Handles validation for general text fields.
     *
     * @param tf The text field being validated.
     * @param nextComponent The component to enable upon successful validation.
     */
    private void handleNormalTextField(JTextField tf, JComponent nextComponent) {
        String text = tf.getText().trim();
        String fieldName = tf.getName();

        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter some data in " + fieldName, "Message", JOptionPane.INFORMATION_MESSAGE);
            tf.requestFocusInWindow();
            nextComponent.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, fieldName + " is changed to " + text, "Message", JOptionPane.INFORMATION_MESSAGE);
            nextComponent.setEnabled(true);
        }
    }

    /**
     * Handles validation for numeric text fields, ensuring positive values.
     *
     * @param tf The text field being validated.
     * @param nextComponent The component to enable upon successful validation.
     */
    private void handlePosNumTextField(JTextField tf, JComponent nextComponent) {
        String text = tf.getText().trim();
        String fieldName = tf.getName();

        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter some data in " + fieldName);
            tf.requestFocusInWindow();
            nextComponent.setEnabled(false);
        } else {
            try {
                double value = Double.parseDouble(text);
                if (value < 0) {
                    JOptionPane.showMessageDialog(this, fieldName + " must be a positive number", "Error", JOptionPane.ERROR_MESSAGE);
                    tf.requestFocusInWindow();
                    nextComponent.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(this, fieldName + " is changed to " + value, "Message", JOptionPane.INFORMATION_MESSAGE);
                    nextComponent.setEnabled(true);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number in " + fieldName, "Message", JOptionPane.INFORMATION_MESSAGE);
                tf.requestFocusInWindow();
                nextComponent.setEnabled(false);
            }
        }
    }

    /**
     * Handles action events for text fields, validating input and enabling the next field.
     *
     * @param e The action event triggered by user input.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object srcObject = e.getSource();
        
        if (srcObject == nameField) {
            handleNormalTextField(nameField, brandField);
        } else if (srcObject == brandField) {
            handleNormalTextField(brandField, priceField);
        } else if (srcObject == priceField) {
            handlePosNumTextField(priceField, extraComponent.getOSComboBox());
        }
    }

    /**
     * Creates and displays the application window.
     */
    public static void createAndShowGUI() {
        MobileDeviceV12 window12 = new MobileDeviceV12("Mobile Device V12");
        window12.addComponents();
        window12.addMenus();
        window12.addListeners(); // Listeners are now added here
        window12.addMnemonicsAndAccelerators();
        window12.setFrameFeatures();
    }

    /**
     * Main method to launch the application in the event dispatch thread.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}