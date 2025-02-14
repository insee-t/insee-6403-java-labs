/**
 * MobileDeviceV5 class extends MobileDeviceV4 and introduces additional UI components.
 * This version includes an ExtraPanel for displaying additional device features
 * and a VendorsComponent for vendor and rating details.
 *
 * The class organizes these components into a structured layout for better user experience.
 *
 * @author Insee Thaopech
 * @version 1.0
 */

package thaopech.insee.lab9;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

public class MobileDeviceV5 extends MobileDeviceV4 {
    // Additional UI components
    protected ExtraPanel extraComponent = new ExtraPanel();
    protected VendorsComponent vendorsComponent = new VendorsComponent();
    protected JPanel extraAndVendorsPanel = new JPanel(new BorderLayout());
    protected JPanel vendorsAndRatingPanel = new JPanel(new BorderLayout());

    /**
     * Constructor initializes the MobileDeviceV5 window with a title.
     * 
     * @param title Title of the application window.
     */
    public MobileDeviceV5(String title) {
        super(title);
    }

    /**
     * Overrides addComponents method to include the extra and vendor components.
     * It organizes them in a structured panel layout.
     */
    @Override
    protected void addComponents() {
        super.addComponents();

        // Add vendor component sections
        vendorsAndRatingPanel.add(vendorsComponent.getPanel(), BorderLayout.NORTH);
        vendorsAndRatingPanel.add(vendorsComponent.getRatingLabel(), BorderLayout.CENTER);
        vendorsAndRatingPanel.add(vendorsComponent.getRatingSlider(), BorderLayout.SOUTH);

        // Organize extra features and vendor details
        extraAndVendorsPanel.add(extraComponent.getPanel(), BorderLayout.NORTH);
        extraAndVendorsPanel.add(vendorsAndRatingPanel, BorderLayout.CENTER);

        // Add the combined panel to the main panel
        mainPanel.add(extraAndVendorsPanel, BorderLayout.CENTER);
    }

    /**
     * Creates and displays the MobileDeviceV5 UI.
     */
    public static void createAndShowGUI() {
        MobileDeviceV5 mdv5 = new MobileDeviceV5("Mobile Device V5");
        mdv5.addComponents();
        mdv5.addMenus();
        mdv5.setFrameFeatures();
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
