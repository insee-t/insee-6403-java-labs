package thaopech.insee.lab10;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;

/**
 * The `MobileDeviceV9` class extends `MobileDeviceV8` to add additional functionality
 * for handling file operations (open, save, new), font size and family customization,
 * and color changes for text fields. It also includes menu items for these actions.
 */
public class MobileDeviceV9 extends MobileDeviceV8 {

    public JTextField getDeviceNameField() {
        return nameField;
    }

    public JTextField getBrandField() {
        return brandField;
    }

    public JTextField getPriceField() {
        return priceField;
    }
    
    /**
     * Adds action listeners to menu items for handling user interactions such as
     * file operations, font size and family changes, and color changes.
     */
    @Override
    public void addListeners() {
        super.addListeners();
        newMenuItem.addActionListener(this);
        openMenuItem.addActionListener(this);
        saveMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);
        smallMenuItem.addActionListener(this);
        mediumMenuItem.addActionListener(this);
        largeMenuItem.addActionListener(this);
        extraLargeMenuItem.addActionListener(this);
        blackMenuItem.addActionListener(this);
        redMenuItem.addActionListener(this);
        greenMenuItem.addActionListener(this);
        blueMenuItem.addActionListener(this);
        font1MenuItem.addActionListener(this);
        font2MenuItem.addActionListener(this);
        font3MenuItem.addActionListener(this);
    }

    /**
     * Handles action events triggered by user interactions with menu items.
     *
     * @param e The `ActionEvent` object representing the user's action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String fontFamily = extraComponent.getFeatureTextArea().getFont().getFamily();
        int fontSize = extraComponent.getFeatureTextArea().getFont().getSize();
        Color fontColor = extraComponent.getFeatureTextArea().getForeground();

        Object src = e.getSource();
        super.actionPerformed(e);
        JMenuItem currentMenuItem = null;

        if (src instanceof JMenuItem) {
            currentMenuItem = (JMenuItem) src;
        }

        if (src == newMenuItem) {
            nameField.setText("");
            brandField.setText("");
            priceField.setText("");
            extraComponent.getFeatureTextArea().setText("");
            smartPhoneButton.setSelected(true);
            OSComboBox.setSelectedIndex(0);
            vendorsComponent.getVendorsList().clearSelection();
            vendorsComponent.getRatingSlider().setValue(5);
            return;
        }

        if (src == openMenuItem) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                JOptionPane.showMessageDialog(this, "Opening: " + selectedFile.getName(), "Message", JOptionPane.INFORMATION_MESSAGE);
            }
            return;
        }

        if (src == saveMenuItem) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showSaveDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                JOptionPane.showMessageDialog(this, "Data is saved to " + selectedFile.getName() + " successfully", "Save", JOptionPane.INFORMATION_MESSAGE);
            }
            return;
        }

        if (src == exitMenuItem) {
            System.exit(1);
        }

        if (src == smallMenuItem
            || src == mediumMenuItem
            || src == largeMenuItem
            || src == extraLargeMenuItem) {
            fontSize = currentMenuItem.getFont().getSize();
            setAllFont(fontFamily, fontSize);
            return;
        }

        if (src == font1MenuItem
            || src == font2MenuItem
            || src == font3MenuItem) {
            fontFamily = currentMenuItem.getFont().getFamily();
            setAllFont(fontFamily, fontSize);
            return;
        }

        if (src == blackMenuItem
            || src == redMenuItem
            || src == greenMenuItem
            || src == blueMenuItem) {
            fontColor = currentMenuItem.getForeground();
            nameField.setForeground(fontColor);
            brandField.setForeground(fontColor);
            priceField.setForeground(fontColor);
            extraComponent.getFeatureTextArea().setForeground(fontColor);
            return;
        }
    }

    /**
     * Sets the font family and size for all text fields and the features text area.
     *
     * @param fontFamily The font family to apply.
     * @param fontSize   The font size to apply.
     */
    public void setAllFont(String fontFamily, int fontSize) {
        nameField.setFont(new Font(fontFamily, nameField.getFont().getStyle(), fontSize));
        brandField.setFont(new Font(fontFamily, brandField.getFont().getStyle(), fontSize));
        priceField.setFont(new Font(fontFamily, priceField.getFont().getStyle(), fontSize));
        extraComponent.getFeatureTextArea().setFont(new Font(fontFamily, extraComponent.getFeatureTextArea().getFont().getStyle(), fontSize));
    }

    /**
     * Constructs a new `MobileDeviceV9` instance with the specified title.
     *
     * @param title The title of the application window.
     */
    public MobileDeviceV9(String title) {
        super(title);
    }

    /**
     * Creates and displays the GUI for the `MobileDeviceV9` application.
     * This method initializes the frame, adds components, sets up menus,
     * adds listeners, and configures frame features.
     */
    public static void createAndShowGUI() {
        MobileDeviceV9 mdv9 = new MobileDeviceV9("Mobile Device V9");
        mdv9.addComponents();
        mdv9.addMenus();
        mdv9.addListeners();
        mdv9.setFrameFeatures();
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
