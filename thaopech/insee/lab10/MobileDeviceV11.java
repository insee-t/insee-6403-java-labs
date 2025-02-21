package thaopech.insee.lab10;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionListener;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JSlider;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;

import thaopech.insee.lab10.MobileDeviceV9;

/**
 * The `MobileDeviceV11` class extends `MobileDeviceV10` to add additional functionality
 * for handling user interactions with radio buttons (smartphone and tablet) and
 * adding mnemonics and accelerators to menu items for improved accessibility and usability.
 */
public class MobileDeviceV11 extends MobileDeviceV10 {

    /**
     * Adds listeners to the radio buttons (smartphone and tablet) to handle user interactions.
     * When a radio button is selected, a message dialog is displayed to inform the user.
     */
    @Override
    public void addListeners() {
        super.addListeners();

        // ActionListener for RadioButtons
        ActionListener radioListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton selectedButton = (JRadioButton) e.getSource();
                JOptionPane.showMessageDialog(null, selectedButton.getText() + " is selected", "Device Type Selection", JOptionPane.INFORMATION_MESSAGE);
            }
        };

        smartPhoneButton.addActionListener(radioListener);
        tabletButton.addActionListener(radioListener);
    }

    /**
     * Adds mnemonics and accelerators to menu items for improved accessibility and usability.
     * Mnemonics allow users to navigate menus using keyboard shortcuts, while accelerators
     * provide quick access to menu items using key combinations.
     */
    protected void addMnemonicsAndAccelerators() {
        // Add Mnemonics
        newMenuItem.setMnemonic('N'); // Mnemonic for New
        openMenuItem.setMnemonic('O'); // Mnemonic for Open
        saveMenuItem.setMnemonic('S'); // Mnemonic for Save
        exitMenuItem.setMnemonic('X'); // Mnemonic for Exit

        // Add Accelerators
        newMenuItem.setAccelerator(KeyStroke.getKeyStroke("ctrl N")); // Accelerator for New
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O")); // Accelerator for Open
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S")); // Accelerator for Save
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke("ctrl Q")); // Accelerator for Exit
    }

    /**
     * Constructs a new `MobileDeviceV11` instance with the specified title.
     *
     * @param title The title of the application window.
     */
    public MobileDeviceV11(String title) {
        super(title);
    }

    /**
     * Creates and displays the GUI for the `MobileDeviceV11` application.
     * This method initializes the frame, adds components, sets up menus,
     * adds listeners, configures mnemonics and accelerators, and sets frame features.
     */
    public static void createAndShowGUI() {
        MobileDeviceV11 mdv11 = new MobileDeviceV11("Mobile Device V11");
        mdv11.addComponents();
        mdv11.addMenus();
        mdv11.addListeners();
        mdv11.addMnemonicsAndAccelerators();
        mdv11.setFrameFeatures();
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
}}
