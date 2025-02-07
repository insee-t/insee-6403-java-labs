package thaopech.insee.lab8;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

/**
 * MobileDeviceV3 extends MobileDeviceV2 by adding a menu bar with 
 * file operations, configuration options for size, color, and font.
 * @author Insee Thaopech
 * @version 1.0
 */
public class MobileDeviceV3 extends MobileDeviceV2 {

  // Menu components
  protected JMenuBar menuBar;
  protected JMenu fileMenu, configMenu, sizeMenu, colorMenu, fontMenu;
  protected JMenuItem newMenuItem, openMenuItem, saveMenuItem, exitMenuItem;
  protected JMenuItem smallMenuItem, mediumMenuItem, largeMenuItem, extraLargeMenuItem;
  protected JMenuItem blackMenuItem, redMenuItem, greenMenuItem, blueMenuItem;
  protected JMenuItem font1MenuItem, font2MenuItem, font3MenuItem;

  /**
   * Constructor that sets the window title.
   * @param title The title of the window.
   */
  public MobileDeviceV3(String title) {
    super(title);
  }

  /**
   * Overrides addComponents to initialize menu components 
   * while retaining components from MobileDeviceV2.
   */
  @Override
  protected void addComponents() {
    super.addComponents(); // Call parent method to retain UI elements

    // Initialize menu bar and menus
    menuBar = new JMenuBar();
    fileMenu = new JMenu("File");
    configMenu = new JMenu("Config");

    // File menu items
    newMenuItem = new JMenuItem("New");
    openMenuItem = new JMenuItem("Open");
    saveMenuItem = new JMenuItem("Save");
    exitMenuItem = new JMenuItem("Exit");

    // Configuration submenus
    sizeMenu = new JMenu("Size");
    colorMenu = new JMenu("Color");
    fontMenu = new JMenu("Font");

    // Size menu items
    smallMenuItem = new JMenuItem("Small");
    mediumMenuItem = new JMenuItem("Medium");
    largeMenuItem = new JMenuItem("Large");
    extraLargeMenuItem = new JMenuItem("Extra Large");

    // Color menu items
    blackMenuItem = new JMenuItem("Black");
    redMenuItem = new JMenuItem("Red");
    greenMenuItem = new JMenuItem("Green");
    blueMenuItem = new JMenuItem("Blue");

    // Font menu items
    font1MenuItem = new JMenuItem("Font 1");
    font2MenuItem = new JMenuItem("Font 2");
    font3MenuItem = new JMenuItem("Font 3");
  }

  /**
   * Adds menus and submenus to the menu bar and sets it for the frame.
   */
  protected void addMenus() {
    // Add menu items to File menu
    fileMenu.add(newMenuItem);
    fileMenu.add(openMenuItem);
    fileMenu.add(saveMenuItem);
    fileMenu.add(exitMenuItem);

    // Add configuration menus
    configMenu.add(sizeMenu);
    configMenu.add(colorMenu);
    configMenu.add(fontMenu);

    // Add size options
    sizeMenu.add(smallMenuItem);
    sizeMenu.add(mediumMenuItem);
    sizeMenu.add(largeMenuItem);
    sizeMenu.add(extraLargeMenuItem);

    // Add color options
    colorMenu.add(blackMenuItem);
    colorMenu.add(redMenuItem);
    colorMenu.add(greenMenuItem);
    colorMenu.add(blueMenuItem);

    // Add font options
    fontMenu.add(font1MenuItem);
    fontMenu.add(font2MenuItem);
    fontMenu.add(font3MenuItem);

    // Add menus to the menu bar
    menuBar.add(fileMenu);
    menuBar.add(configMenu);

    // Set the menu bar for the frame
    setJMenuBar(menuBar);
  }

  /**
   * Main method to run the application in a separate thread
   * using SwingUtilities for thread safety.
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }

  /**
   * Creates and displays the MobileDeviceV3 window.
   */
  public static void createAndShowGUI() {
    MobileDeviceV3 mdv3 = new MobileDeviceV3("Mobile Device V3");
    mdv3.addComponents();
    mdv3.addMenus();
    mdv3.setFrameFeatures();
  }
}
