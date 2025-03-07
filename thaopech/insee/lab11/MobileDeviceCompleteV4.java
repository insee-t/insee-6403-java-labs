package thaopech.insee.lab11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A class that extends MobileDeviceCompleteV2 and adds a configurable color menu 
 * allowing users to change the text color of input fields.
 */
public class MobileDeviceCompleteV4 extends MobileDeviceCompleteV2 {

    /**
     * Constructor that initializes the MobileDeviceCompleteV4 with a title.
     *
     * @param title The title of the window.
     */
    public MobileDeviceCompleteV4(String title) {
        super(title);
    }

    /**
     * Adds a "Config" menu with a "Color" submenu, allowing users to select a custom text color.
     */
    private void addColorMenu() {
        JMenu configMenu = new JMenu("Config");
        JMenu colorMenu = new JMenu("Color");
        JMenuItem customItem = new JMenuItem("Custom");

        customItem.addActionListener(new ActionListener() {
            /**
             * Opens a color chooser dialog to select a new text color for input fields.
             *
             * @param e The action event triggered when the "Custom" menu item is clicked.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Color selectedColor = JColorChooser.showDialog(
                    MobileDeviceCompleteV4.this,
                    "Select Text Color",
                    deviceNameField.getForeground()
                );
                if (selectedColor != null) {
                    updateTextFieldsColor(selectedColor);
                }
            }
        });

        colorMenu.add(customItem);
        configMenu.add(colorMenu);
        menuBar.add(configMenu);
    }

    /**
     * Updates the text color of the input fields based on the selected color.
     *
     * @param color The new color to apply to the text fields.
     */
    private void updateTextFieldsColor(Color color) {
        deviceNameField.setForeground(color);
        brandField.setForeground(color);
        priceField.setForeground(color);
    }

    /**
     * The main method that launches the application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MobileDeviceCompleteV4 window = new MobileDeviceCompleteV4("Mobile Device Complete V4");
            window.addComponents();
            window.addMenus();
            window.addColorMenu();
            window.setFrameFeatures();
        });
    }
}