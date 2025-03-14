/**
 * MobileDeviceV15 extends MobileDeviceV14 by introducing support for 
 * saving and loading mobile device data in both text and binary formats.
 * 
 * Users can choose between text and binary file formats through a menu option. 
 * The class handles serialization and deserialization of MobileDevice objects 
 * for binary file storage.
 *
 * @author Insee Thaopech
 * @version 1.0
 */
package thaopech.insee.lab12;

import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import thaopech.insee.lab7.MobileDevice;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;

public class MobileDeviceV15 extends MobileDeviceV14 {
    
    /** Menu for selecting file format (Text or Binary). */
    private JMenu formatMenu = new JMenu("Format");

    /** Radio button for selecting text format. */
    private JRadioButtonMenuItem textRadioMenu = new JRadioButtonMenuItem("Text");

    /** Radio button for selecting binary format. */
    private JRadioButtonMenuItem binaryRaidoMenu = new JRadioButtonMenuItem("Binary");

    /** Button group to ensure only one format is selected at a time. */
    private ButtonGroup formatButtonGroup = new ButtonGroup();

    /**
     * Constructs a MobileDeviceV15 window with the specified title.
     *
     * @param title the title of the window
     */
    public MobileDeviceV15(String title) {
        super(title);
    }        
    
    /**
     * Adds menus to the application, including options for choosing 
     * between text and binary file formats.
     */
    @Override
    public void addMenus() {
        super.addMenus();
        formatMenu.add(textRadioMenu);
        formatMenu.add(binaryRaidoMenu);
        formatButtonGroup.add(textRadioMenu);
        formatButtonGroup.add(binaryRaidoMenu);
        textRadioMenu.setSelected(true);
        configMenu.add(formatMenu);
    }
    
    /**
     * Adds event listeners for format selection menu options.
     */
    @Override
    public void addListeners() {
        super.addListeners();
        textRadioMenu.addActionListener(this);
        binaryRaidoMenu.addActionListener(this);
    }
    
    /**
     * Handles saving mobile device data in either text or binary format 
     * based on user selection.
     */
    @Override
    public void handleMenuSave() {
        if (textRadioMenu.isSelected()) {
            super.handleMenuSave();
        } else {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showSaveDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();

                try (FileOutputStream fos = new FileOutputStream(selectedFile);
                     ObjectOutputStream oos = new ObjectOutputStream(fos)) {

                    for (MobileDevice device : getDeviceList()) {
                        oos.writeObject(device);
                    }
                    
                    JOptionPane.showMessageDialog(this, "Data is saved to " + selectedFile.getName() + " successfully",
                                                  "Save", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException e) {
                    System.out.println("An error occurred while writing to the file: " + e.getMessage());
                }
            }
        }
    }
    
    /**
     * Handles opening mobile device data from a file, supporting both text 
     * and binary formats based on user selection.
     */
    @Override
    public void handleMenuOpen() {
        if (textRadioMenu.isSelected()) {
            super.handleMenuOpen();
        } else {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try (FileInputStream fis = new FileInputStream(selectedFile);
                     ObjectInputStream ois = new ObjectInputStream(fis)) {

                    String mobileDevicesString = "";
                    while (true) {
                        try {
                            MobileDevice device = (MobileDevice) ois.readObject();
                            mobileDevicesString += device.toString() + '\n';
                        } catch (EOFException e) {
                            break; // End of file reached
                        }
                    }

                    JOptionPane.showMessageDialog(this, "Read devices from the file " + selectedFile.getAbsolutePath() + 
                                                  " are as follows:\n" + mobileDevicesString, "Message", 
                                                  JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException e) {
                    System.err.println("An I/O error occurred: " + e.getMessage());
                    e.printStackTrace();
                } catch (Exception e) {
                    System.err.println("An unexpected error occurred: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Creates and displays the MobileDeviceV15 UI.
     */
    public static void createAndShowGUI() {
        MobileDeviceV15 window15 = new MobileDeviceV15("Mobile Device V15");
        window15.addComponents();
        window15.addMenus();
        window15.addListeners(); 
        window15.addMnemonicsAndAccelerators();
        window15.setFrameFeatures();
        window15.addDisplayAndAddButton();
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