package thaopech.insee.lab10;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.JMenuItem;

import thaopech.insee.lab9.MobileDeviceV7;

/**
 * The `MobileDeviceV8` class extends `MobileDeviceV7` to add additional functionality
 * for managing mobile device information. It includes a new panel (`ExtraPanelV2`)
 * for selecting an operating system and entering device features. It also handles
 * user actions such as displaying device information and resetting the form.
 */
public class MobileDeviceV8 extends MobileDeviceV7 implements ActionListener {

    // Additional UI components
    protected ExtraPanelV2 extraComponent = new ExtraPanelV2();

    /**
     * Adds action listeners to the `okButton` and `cancelButton` to handle user interactions.
     */
    public void addListeners() {
        cancelButton.addActionListener(this);
        okButton.addActionListener(this);
    }

    /**
     * Handles action events triggered by user interactions with the buttons.
     *
     * @param e The `ActionEvent` object representing the user's action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == okButton) {

            smartPhoneButton.setActionCommand("Smartphone");
            tabletButton.setActionCommand("Tablet");
            String values = vendorsComponent.getVendorsList().getSelectedValuesList().toString();
            String valuesWithoutBrackets = values.substring(1, values.length() - 1);

            String info = "Device Name: " + nameField.getText() + '\n'
                + "Brand: " + brandField.getText() + '\n'
                + "Price: " + priceField.getText() + '\n'
                + "Type: " + deviceTypeGroup.getSelection().getActionCommand() + '\n'
                + "Operating System: " + extraComponent.getOSComboBox().getSelectedItem() + '\n'
                + "Features: " + extraComponent.getFeatureTextArea().getText() + '\n'
                + "Available at: " + valuesWithoutBrackets + '\n'
                + "Rating: " + vendorsComponent.getRatingSlider().getValue();

            JOptionPane.showMessageDialog(null, info, "Device Information", JOptionPane.INFORMATION_MESSAGE);

        } else if (src == cancelButton) {
            nameField.setText("");
            brandField.setText("");
            priceField.setText("");
            extraComponent.getFeatureTextArea().setText("");
            smartPhoneButton.setSelected(true);
            extraComponent.getOSComboBox().setSelectedIndex(0);
            vendorsComponent.getVendorsList().clearSelection();
            vendorsComponent.getRatingSlider().setValue(5);
        }
    }

    /**
     * Constructs a new `MobileDeviceV8` instance with the specified title.
     *
     * @param title The title of the application window.
     */
    public MobileDeviceV8(String title) {
        super(title);
    }

    /**
     * Adds components to the frame, including the `ExtraPanelV2` for OS selection
     * and features. Sets default text for the features text area and applies
     * custom font and color settings.
     */
    @Override
    public void addComponents() {
        super.addComponents();

        // Set extra features and vendor rating
        extraComponent.getFeatureTextArea().setText(
                "- 200MP Camera \n- 1TB Storage \n- Snapdragon Gen 4 Processor \n- 5000mAh Battery \n- 6.8-inch AMOLED Display \n- 120Hz Refresh Rate \n Fast Charging ");

        // Apply font and color settings
        extraComponent.setFontAndColor();
        extraAndVendorsPanel.add(extraComponent.getPanel(), BorderLayout.NORTH);
    }

    /**
     * Creates and displays the GUI for the `MobileDeviceV8` application.
     * This method initializes the frame, adds components, sets up listeners,
     * and configures frame features.
     */
    public static void createAndShowGUI() {
        MobileDeviceV8 mdv8 = new MobileDeviceV8("Mobile Device V8");
        mdv8.addComponents();
        mdv8.addListeners();
        mdv8.addMenus();
        mdv8.setFrameFeatures();
    }

    /**
     * The entry point for the application. Ensures the GUI is created on the
     * Event Dispatch Thread for thread safety.
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
