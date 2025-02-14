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
    protected JMenuBar menuBar;
    protected JMenu file, config, size, color, font;
    
    // Menu items
    protected JMenuItem newFile, openFile, saveFile, exitFile;
    protected JMenuItem smallFont, mediumFont, largeFont, extraLargeFont;
    protected JMenuItem black, red, green, blue;
    protected JMenuItem font1, font2, font3;

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

        // Initialize menu bar and menus
        menuBar = new JMenuBar();
        file = new JMenu("File");
        config = new JMenu("Config");

        // File menu items
        newFile = new JMenuItem("New");
        openFile = new JMenuItem("Open");
        saveFile = new JMenuItem("Save");
        exitFile = new JMenuItem("Exit");

        // Set icons for file menu items
        newFile.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./images/new_icon.png")));
        openFile.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./images/open_icon.png")));
        saveFile.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./images/save_icon.png")));
        exitFile.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./images/exit_icon.png")));

        // Config menu sections
        size = new JMenu("Size");
        color = new JMenu("Color");
        font = new JMenu("Font");

        // Font size options
        smallFont = new JMenuItem("Small");
        mediumFont = new JMenuItem("Medium");
        largeFont = new JMenuItem("Large");
        extraLargeFont = new JMenuItem("Extra Large");

        // Set font sizes
        smallFont.setFont(new Font("Arial", Font.PLAIN, 10));
        mediumFont.setFont(new Font("Arial", Font.PLAIN, 14));
        largeFont.setFont(new Font("Arial", Font.PLAIN, 18));
        extraLargeFont.setFont(new Font("Arial", Font.PLAIN, 22));

        // Color options
        black = new JMenuItem("Black");
        red = new JMenuItem("Red");
        green = new JMenuItem("Green");
        blue = new JMenuItem("Blue");

        // Set foreground colors
        black.setForeground(Color.BLACK);
        red.setForeground(Color.RED);
        green.setForeground(Color.GREEN);
        blue.setForeground(Color.BLUE);

        // Font type options
        font1 = new JMenuItem("Font 1");
        font2 = new JMenuItem("Font 2");
        font3 = new JMenuItem("Font 3");

        // Set font styles
        font1.setFont(new Font("Serif", Font.PLAIN, 14));
        font2.setFont(new Font("SansSerif", Font.PLAIN, 14));
        font3.setFont(new Font("Monospaced", Font.PLAIN, 14));
    }

    /**
     * Overrides addMenus method to structure and add menus to the menu bar.
     */
    @Override
    protected void addMenus() {
        // Add file menu items
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        file.add(exitFile);

        // Add configuration menus
        config.add(size);
        config.add(color);
        config.add(font);

        // Add font size options
        size.add(smallFont);
        size.add(mediumFont);
        size.add(largeFont);
        size.add(extraLargeFont);

        // Add color options
        color.add(black);
        color.add(red);
        color.add(green);
        color.add(blue);

        // Add font type options
        font.add(font1);
        font.add(font2);
        font.add(font3);

        // Add menus to menu bar
        menuBar.add(file);
        menuBar.add(config);

        // Set menu bar for the frame
        setJMenuBar(menuBar);
    }

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
