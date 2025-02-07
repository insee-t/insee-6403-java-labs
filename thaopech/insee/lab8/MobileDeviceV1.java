package thaopech.insee.lab8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * MobileDeviceV1 extends MySimpleWindow to create a GUI for entering 
 * mobile device details, including name, brand, price, and type (smartphone or tablet).
 * @author Insee Thaopech
 * @version 1.0
 */

public class MobileDeviceV1 extends MySimpleWindow {
    // Form components
    protected JPanel formPanel;
    protected JLabel nameLabel, brandLabel, priceLabel, typeLabel;
    protected JTextField nameField, brandField, priceField;
    protected JRadioButton smartPhoneButton, tabletButton;
    protected ButtonGroup deviceTypeGroup;
    protected JPanel typePanel;

    /**
     * Constructor that sets the window title.
     * @param title The title of the window.
     */
    public MobileDeviceV1(String title) {
        super(title);
    }

    /**
     * Overrides addComponents to add form fields for device details.
     * Calls super.addComponents() to include base components from MySimpleWindow.
     */
    @Override
    protected void addComponents() {
        super.addComponents(); // Call parent method to add buttons

        // Initialize form panel with grid layout (4 rows, 2 columns)
        formPanel = new JPanel(new GridLayout(4, 2));
        typePanel = new JPanel();

        // Create labels and input fields
        nameLabel = new JLabel("Device Name:");
        brandLabel = new JLabel("Brand:");
        priceLabel = new JLabel("Price:");
        typeLabel = new JLabel("Type:");
        
        nameField = new JTextField(15);
        brandField = new JTextField(15);
        priceField = new JTextField(15);

        // Create radio buttons for device type selection
        smartPhoneButton = new JRadioButton("Smartphone", true); // Default selection
        tabletButton = new JRadioButton("Tablet");
        deviceTypeGroup = new ButtonGroup();

        // Add components to form panel
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(brandLabel);
        formPanel.add(brandField);
        formPanel.add(priceLabel);
        formPanel.add(priceField);
        formPanel.add(typeLabel);

        // Add radio buttons to a separate panel
        typePanel.add(smartPhoneButton);
        typePanel.add(tabletButton);

        // Group radio buttons so only one can be selected at a time
        deviceTypeGroup.add(smartPhoneButton);
        deviceTypeGroup.add(tabletButton);

        // Add the type selection panel to the form
        formPanel.add(typePanel);

        // Add the form panel to the top (NORTH) of the main panel
        mainPanel.add(formPanel, BorderLayout.NORTH);
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
     * Creates and displays the MobileDeviceV1 window.
     */
    public static void createAndShowGUI() {
        MobileDeviceV1 mdv1 = new MobileDeviceV1("Mobile Device V1");
        mdv1.addComponents();
        mdv1.setFrameFeatures();
    }
}
