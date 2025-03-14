/**
 * MobileDeviceV13 extends MobileDeviceV12 by adding functionality for managing
 * a list of mobile devices. It introduces two buttons: one for adding devices
 * to a list and another for displaying them in a dialog box.
 *
 * This class maintains a list of MobileDevice objects, allowing users to add
 * SmartPhones and Tablets dynamically.
 *
 * @author Insee Thaopech
 * @version 1.0
 */
package thaopech.insee.lab12;

import java.util.List;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import thaopech.insee.lab7.MobileDevice;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MobileDeviceV13 extends MobileDeviceV12 {
    
    /** Button for adding a mobile device to the list. */
    private JButton addButton = new JButton("Add");

    /** Button for displaying the list of mobile devices. */
    private JButton displayButton = new JButton("Display");

    /** List to store added mobile devices. */
    private List<MobileDevice> deviceList = new ArrayList<>();
    
    /**
     * Gets the add button.
     *
     * @return the add button
     */
    public JButton getAddButton() {
        return addButton;
    }

    /**
     * Gets the display button.
     *
     * @return the display button
     */
    public JButton getDisplayButton() {
        return displayButton;
    }
    
    /**
     * Gets the list of mobile devices.
     *
     * @return the list of mobile devices
     */
    public List<MobileDevice> getDeviceList() {
        return deviceList;
    }

    /**
     * Constructs a MobileDeviceV13 window with the given title.
     *
     * @param title the title of the window
     */
    public MobileDeviceV13(String title) {
        super(title);
    }

    /**
     * Adds components to the UI and sets the default price field value.
     */
    @Override
    public void addComponents() {
        super.addComponents();
        priceField.setText("46900");
    }
    
    /**
     * Adds the "Add" and "Display" buttons to the button panel.
     */
    public void addDisplayAndAddButton() {
        this.buttonPanel.add(this.addButton);
        this.buttonPanel.add(this.displayButton);
    }

    /**
     * Registers action listeners for the "Add" and "Display" buttons.
     */
    @Override
    public void addListeners() {
        super.addListeners();
        getAddButton().addActionListener(this);
        getDisplayButton().addActionListener(this);
    }

    /**
     * Handles the add button click event by creating and storing a new mobile device.
     * Displays a confirmation message upon successful addition.
     */
    public void handleAddButton() {
        String mobileDeviceString = "";
        if (smartPhoneButton.isSelected()) {
            SmartPhone smartPhone = new SmartPhone(nameField.getText(), brandField.getText(), Double.parseDouble(priceField.getText()));
            mobileDeviceString += "SmartPhone " + smartPhone.getName() + " is added";
            deviceList.add(smartPhone);
        } else if (tabletButton.isSelected()) {
            Tablet tablet = new Tablet(nameField.getText(), brandField.getText(), Double.parseDouble(priceField.getText()));
            mobileDeviceString += "Tablet " + tablet.getName() + " is added";
            deviceList.add(tablet);
        }
        JOptionPane.showMessageDialog(null, mobileDeviceString, "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Handles the display button click event by showing all stored mobile devices
     * in a message dialog.
     */
    public void handleDisplayButton() {
        String mobileDevicesString = "";
        for (MobileDevice device : deviceList) {
            if (device instanceof SmartPhone) {
                SmartPhone smartPhone = (SmartPhone) device;
                mobileDevicesString += "SmartPhone: " + smartPhone.getName() +
                        " (" + smartPhone.getBrand() + ") " + smartPhone.getPrice() + " Baht\n";
            } else {
                Tablet tablet = (Tablet) device;
                mobileDevicesString += "Tablet: " + tablet.getName() +
                        " (" + tablet.getBrand() + ") " + tablet.getPrice() + " Baht\n";
            }
        }
        JOptionPane.showMessageDialog(null, mobileDevicesString, "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Handles action events for the add and display buttons. Calls the parent class
     * method for other actions.
     *
     * @param e the action event triggered by a UI component
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object srcObject = e.getSource();
        if (srcObject == addButton) {
            handleAddButton();
        } else if (srcObject == displayButton) {
            handleDisplayButton();
        } else {
            super.actionPerformed(e);
        }
    }

    /**
     * Creates and displays the MobileDeviceV13 UI.
     */
    public static void createAndShowGUI() {
        MobileDeviceV13 window13 = new MobileDeviceV13("Mobile Device V13");
        window13.addComponents();
        window13.addMenus();
        window13.addListeners(); 
        window13.addMnemonicsAndAccelerators();
        window13.setFrameFeatures();
        window13.addDisplayAndAddButton();
    }
    
    /**
     * The main method that launches the application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}