/**
 * MobileDeviceV14 extends MobileDeviceV13 by adding file handling capabilities. 
 * It allows users to save and load mobile device data using a file chooser.
 *
 * This class provides methods to save a list of mobile devices to a file 
 * and read stored devices from a file, displaying them in the application.
 *
 * @author Insee Thaopech
 * @version 1.0
 */
package thaopech.insee.lab12;

import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import thaopech.insee.lab7.MobileDevice;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MobileDeviceV14 extends MobileDeviceV13 {
    
    /**
     * Constructs a MobileDeviceV14 window with the specified title.
     *
     * @param title the title of the window
     */
    public MobileDeviceV14(String title) {
        super(title);
    }
    
    /**
     * Handles the save menu action by allowing the user to select a file 
     * and saving the list of mobile devices to the file.
     */
    public void handleMenuSave() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            // Writing to the file
            try (FileWriter writer = new FileWriter(selectedFile.getPath())) {
                String mobileDevicesString = "";
                for (MobileDevice device : getDeviceList()) {
                    if (device instanceof SmartPhone) {
                        SmartPhone smartPhone = (SmartPhone) device;
                        mobileDevicesString += smartPhone.toString() + '\n';
                    } else {
                        Tablet tablet = (Tablet) device;
                        mobileDevicesString += tablet.toString() + '\n';
                    }
                }
                writer.write(mobileDevicesString);

                JOptionPane.showMessageDialog(this, "Data is saved to " + selectedFile.getName() + " successfully",
                        "Save",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            // Handle exceptions during file writing
            catch (IOException e) {
                System.out.println("An error occurred while writing"
                        + " to the file: " + e.getMessage());
            }
        }
    }
    
    /**
     * Handles the open menu action by allowing the user to select a file 
     * and loading the list of mobile devices from the file.
     */
    public void handleMenuOpen() {

        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            getDeviceList().clear();
            File selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(this, "Opening: " + selectedFile.getAbsolutePath(), "Message", JOptionPane.INFORMATION_MESSAGE);
            try {
                Scanner scanner = new Scanner(new File(selectedFile.getAbsolutePath()));
                String mobileDevicesString = "";
                while(scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    mobileDevicesString += line + '\n';
                    String[] splittedString = line.split(":");
                    int brandStartIndex = splittedString[1].indexOf("("); 
                    int brandEndIndex = splittedString[1].indexOf(")");
                    int priceEndIndex = splittedString[1].indexOf("Baht");

                    double price = Double.parseDouble(splittedString[1].substring(brandEndIndex + 1, priceEndIndex));
                    String name = splittedString[1].substring(1, brandStartIndex - 1);
                    String brand = splittedString[1].substring(brandStartIndex + 1, brandEndIndex);
                    
                    if (splittedString[0].equals("SmartPhone")) {
                        getDeviceList().add(new SmartPhone(name, brand, price));
                    } else {
                        getDeviceList().add(new Tablet(name, brand, price));
                    }
                }
                JOptionPane.showMessageDialog(this, "Read devices from the file " + selectedFile.getAbsolutePath() + " are as follows:\n" + mobileDevicesString, "Message", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                System.err.println("An I/O error occurred: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Handles action events for the save and open menu items.
     * Calls the appropriate method based on the source of the event.
     *
     * @param e the action event triggered by a menu item
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object srcObject = e.getSource();
        if (srcObject == saveMenuItem) {
            handleMenuSave();
        } else if (srcObject == openMenuItem) {
            handleMenuOpen();
        } else {
            super.actionPerformed(e);
        }
    }

    /**
     * Creates and displays the MobileDeviceV14 UI.
     */
    public static void createAndShowGUI() {
        MobileDeviceV14 window14 = new MobileDeviceV14("Mobile Device V14");
        window14.addComponents();
        window14.addMenus();
        window14.addListeners(); 
        window14.addMnemonicsAndAccelerators();
        window14.setFrameFeatures();
        window14.addDisplayAndAddButton();
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