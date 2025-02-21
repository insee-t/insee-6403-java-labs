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

public class MobileDeviceV11 extends MobileDeviceV10 {

    @Override
    public void addListeners() {
        super.addListeners();

        // ActionListener for RadioButtons
        ActionListener radioListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton selectedButton = (JRadioButton) e.getSource();
                JOptionPane.showMessageDialog(null, selectedButton.getText() + " is selected", "Rating Adjustment", JOptionPane.INFORMATION_MESSAGE);
            }
        };
        
        smartPhoneButton.addActionListener(radioListener);
        tabletButton.addActionListener(radioListener);
    }

    protected void addMnemonicsAndAccelerators() {
        // Add Mnemonics
        newMenuItem.setMnemonic('N'); // Mnemonic for File
        openMenuItem.setMnemonic('O'); // Mnemonic for Open
        saveMenuItem.setMnemonic('S'); // Mnemonic for Save
        exitMenuItem.setMnemonic('X'); // Mnemonic for Exit

        // Add Accelerators
        newMenuItem.setAccelerator(KeyStroke.getKeyStroke("ctrl N")); // Accelerator for Open
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O")); // Accelerator for Save
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S")); // Accelerator for Copy
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke("ctrl Q")); // Accelerator for Paste / Default Paste
    }

    public MobileDeviceV11(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        MobileDeviceV11 mdv11 = new MobileDeviceV11("Mobile Device V11");
        mdv11.addComponents();
        mdv11.addMenus();
        mdv11.addListeners();
        mdv11.addMnemonicsAndAccelerators();
        mdv11.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}