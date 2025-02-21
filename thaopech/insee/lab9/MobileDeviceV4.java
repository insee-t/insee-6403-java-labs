/**
 * MobileDeviceV4 class extends MobileDeviceV3 and introduces a menu system.
 * It includes options for file operations, font size adjustments, color changes, 
 * and font selections, enhancing the GUI's functionality.
 *
 * This class utilizes JMenu, JMenuItem, and JMenuBar for menu configuration.
 *
 * @author Insee Thaopech
 * @version 1.0
 */

package thaopech.insee.lab9;

import thaopech.insee.lab8.*;
import javax.swing.JMenu; import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import java.awt.*;

public class MobileDeviceV4 extends MobileDeviceV3 {
    // Menu bar and menus
    /**
     * Constructor initializes the MobileDeviceV4 window with a title.
     * 
     * @param title Title of the application window.
     */
    public MobileDeviceV4(String title) {
        super(title);
    }

    /**
     * Overrides addComponents method to initialize menu components.
     * Adds file operations, font size settings, color options, and font choices.
     */
    @Override
    protected void addComponents() {
        super.addComponents();

        // Set icons for file menu items
        newMenuItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./images/new_icon.png")));
        openMenuItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./images/open_icon.png")));
        saveMenuItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./images/save_icon.png")));
        exitMenuItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./images/exit_icon.png")));

        // Set font sizes
        smallMenuItem.setFont(new Font("Arial", Font.PLAIN, 10));
        mediumMenuItem.setFont(new Font("Arial", Font.PLAIN, 14));
        largeMenuItem.setFont(new Font("Arial", Font.PLAIN, 18));
        extraLargeMenuItem.setFont(new Font("Arial", Font.PLAIN, 22));


        // Set foreground colors
        blackMenuItem.setForeground(Color.BLACK);
        redMenuItem.setForeground(Color.RED);
        greenMenuItem.setForeground(Color.GREEN);
        blueMenuItem.setForeground(Color.BLUE);

        // Set font styles
        font1MenuItem.setFont(new Font("Serif", Font.PLAIN, 14));
        font2MenuItem.setFont(new Font("SansSerif", Font.PLAIN, 14));
        font3MenuItem.setFont(new Font("Monospaced", Font.PLAIN, 14));
    }

    /**
     * Overrides addMenus method to structure and add menus to the menu bar.
     */
    /**
     * Creates and displays the MobileDeviceV4 UI.
     */
    public static void createAndShowGUI() {
        MobileDeviceV4 mdv4 = new MobileDeviceV4("Mobile Device V4");
        mdv4.addComponents();
        mdv4.addMenus();
        mdv4.setFrameFeatures();
    }

    /**
     * The main method initializes the GUI in the Event Dispatch Thread.
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
