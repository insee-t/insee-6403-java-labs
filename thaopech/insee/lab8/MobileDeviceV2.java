package thaopech.insee.lab8;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.GridLayout;

/**
 * MobileDeviceV2 extends MobileDeviceV1 by adding fields for the operating system
 * and device features. This version introduces a dropdown for OS selection and 
 * a scrollable text area for feature descriptions.
 * @author Insee Thaopech
 * @version 1.0
 */
public class MobileDeviceV2 extends MobileDeviceV1 {
    // Additional UI components
    protected JPanel extraPanel;
    protected JLabel OSLabel, featureLabel;
    protected String[] OperatingSystems = {"Android", "iOS", "Windows", "Others"};
    protected JComboBox<String> OSComboBox = new JComboBox<>(OperatingSystems);
    protected JTextArea featureTextArea;
    protected JScrollPane featureScrollPane;

    /**
     * Constructor that sets the window title.
     * @param title The title of the window.
     */
    public MobileDeviceV2(String title) {
        super(title);
    }

    /**
     * Overrides addComponents to add OS selection and feature input fields.
     * Calls super.addComponents() to retain components from MobileDeviceV1.
     */
    @Override
    protected void addComponents() {
        super.addComponents(); // Call parent method to add existing components

        // Panel to hold new UI elements
        extraPanel = new JPanel(new GridLayout(2, 2));

        // Label and combo box for selecting operating system
        OSLabel = new JLabel("Operating System:");
        OSComboBox.setSelectedIndex(0); // Default selection is "Android"
        OSComboBox.setEditable(false); // Prevent manual text entry

        // Label and text area for entering additional device features
        featureLabel = new JLabel("Features:");
        featureTextArea = new JTextArea(3, 25);
        featureTextArea.setLineWrap(true); // Enable text wrapping
        featureScrollPane = new JScrollPane(featureTextArea); // Add scroll functionality

        // Add components to the extra panel
        extraPanel.add(OSLabel);
        extraPanel.add(OSComboBox);
        extraPanel.add(featureLabel);
        extraPanel.add(featureScrollPane);

        // Add the extra panel to the main panel at the center
        mainPanel.add(extraPanel, BorderLayout.CENTER);
    }

    /**
     * Main method to run the application in a separate thread 
     * using SwingUtilities for thread safety.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    /**
     * Creates and displays the MobileDeviceV2 window.
     */
    public static void createAndShowGUI() {
        MobileDeviceV2 mdv2 = new MobileDeviceV2("Mobile Device V2");
        mdv2.addComponents();
        mdv2.setFrameFeatures();
    }
}
