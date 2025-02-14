/**
 * MobileDeviceV7 class extends MobileDeviceV6 and adds extra components such as
 * ExtraPanel, VendorsComponent, and an ImageComponent. It enhances the UI with
 * additional vendor and feature-related functionalities.
 *
 * @author Insee Thaopech
 * @version 1.0
 */

package thaopech.insee.lab9;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MobileDeviceV7 extends MobileDeviceV6 {
    // Additional UI components
    protected ExtraPanel extraComponent = new ExtraPanel();
    protected VendorsComponent vendorsComponent = new VendorsComponent();
    protected JPanel extraAndVendorsPanel = new JPanel(new BorderLayout());
    protected JPanel vendorsAndRatingPanel = new JPanel(new BorderLayout());
    protected ImageComponent imageComponent = new ImageComponent();

    /**
     * Overrides addComponents method to include additional UI elements.
     * It initializes component values and organizes their layout.
     */
    @Override
    public void addComponents() {
        super.addComponents();

        // Set default device details
        nameField.setText("Samsung Galaxy S25 Ultra");
        brandField.setText("Samsung");
        priceField.setText("46,900");

        // Set extra features and vendor rating
        extraComponent.getFeatureTextArea().setText(
                "- 200MP Camera \n- 1TB Storage \n- Snapdragon Gen 4 Processor \n- 5000mAh Battery \n- 6.8-inch AMOLED Display \n- 120Hz Refresh Rate \n Fast Charging ");
        vendorsComponent.getRatingSlider().setValue(9);

        // Apply font and color settings
        extraComponent.setFontAndColor();
        vendorsComponent.setFontAndColor();

        // Organize layout for vendor and extra features
        vendorsAndRatingPanel.add(vendorsComponent.getPanel(), BorderLayout.NORTH);
        vendorsAndRatingPanel.add(vendorsComponent.getRatingLabel(), BorderLayout.CENTER);
        vendorsAndRatingPanel.add(vendorsComponent.getRatingSlider(), BorderLayout.SOUTH);
        extraAndVendorsPanel.add(extraComponent.getPanel(), BorderLayout.NORTH);
        extraAndVendorsPanel.add(vendorsAndRatingPanel, BorderLayout.CENTER);
        extraAndVendorsPanel.add(imageComponent.getPanel(), BorderLayout.SOUTH);

        // Add to the main panel
        mainPanel.add(extraAndVendorsPanel, BorderLayout.CENTER);
    }

    /**
     * Constructor for MobileDeviceV7.
     * 
     * @param title Title of the application window.
     */
    public MobileDeviceV7(String title) {
        super(title);
    }

    /**
     * Creates and displays the MobileDeviceV7 UI.
     */
    public static void createAndShowGUI() {
        MobileDeviceV7 mdv7 = new MobileDeviceV7("Mobile Device V7");
        mdv7.addComponents();
        mdv7.addMenus();
        mdv7.setFrameFeatures();
    }

    /**
     * The main method that initializes the GUI in the Event Dispatch Thread.
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
