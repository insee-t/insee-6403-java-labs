package thaopech.insee.lab10;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionListener;

import java.util.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;

import thaopech.insee.lab10.MobileDeviceV9;

/**
 * The `MobileDeviceV10` class extends `MobileDeviceV9` to add additional functionality
 * for handling user interactions with the operating system combo box, vendor list,
 * and rating slider. It implements `ItemListener`, `ListSelectionListener`, and
 * `ChangeListener` to respond to changes in these components.
 */
public class MobileDeviceV10 extends MobileDeviceV9 implements ItemListener, ListSelectionListener, ChangeListener {

    /**
     * Adds listeners to the operating system combo box, vendor list, and rating slider
     * to handle user interactions.
     */
    @Override
    public void addListeners() {
        super.addListeners();
        extraComponent.getOSComboBox().addItemListener(this);
        vendorsComponent.getVendorsList().addListSelectionListener(this);
        vendorsComponent.getRatingSlider().addChangeListener(this);
    }

    /**
     * Handles item state changes for the operating system combo box.
     *
     * @param e The `ItemEvent` object representing the change in selection.
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == extraComponent.getOSComboBox() && e.getStateChange() == ItemEvent.SELECTED) {
            JOptionPane.showMessageDialog(this, "You selected Operating System: " + extraComponent.getOSComboBox().getSelectedItem(), "OS Selection", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Handles value changes for the vendor list selection.
     *
     * @param e The `ListSelectionEvent` object representing the change in selection.
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting() && e.getSource() == vendorsComponent.getVendorsList()) {
            List<String> selectedVendors = vendorsComponent.getVendorsList().getSelectedValuesList();
            String selectedVendorsString = String.join(", ", selectedVendors);
            JOptionPane.showMessageDialog(this, "Device is available at: " + selectedVendorsString, "Vendor Selection", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Handles state changes for the rating slider.
     *
     * @param e The `ChangeEvent` object representing the change in slider value.
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == vendorsComponent.getRatingSlider()) {
            JSlider Temp = (JSlider) e.getSource();
            if (!Temp.getValueIsAdjusting()) {
                JOptionPane.showMessageDialog(this, "New rating: " + vendorsComponent.getRatingSlider().getValue(), "Rating Adjustment", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    /**
     * Constructs a new `MobileDeviceV10` instance with the specified title.
     *
     * @param title The title of the application window.
     */
    public MobileDeviceV10(String title) {
        super(title);
    }

    /**
     * Creates and displays the GUI for the `MobileDeviceV10` application.
     * This method initializes the frame, adds components, sets up menus,
     * adds listeners, and configures frame features.
     */
    public static void createAndShowGUI() {
        MobileDeviceV10 mdv10 = new MobileDeviceV10("Mobile Device V10");
        mdv10.addComponents();
        mdv10.addMenus();
        mdv10.addListeners();
        mdv10.setFrameFeatures();
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
