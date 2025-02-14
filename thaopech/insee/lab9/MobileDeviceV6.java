/**
 * MobileDeviceV6 class extends MobileDeviceV5 and enhances the UI with 
 * additional styling for labels, text fields, and buttons. It improves 
 * readability by applying custom fonts and colors.
 *
 * This version ensures a more visually appealing and consistent design 
 * by modifying the text fields, labels, and buttons.
 *
 * @author [Your Name]
 * @version 1.0
 */

package thaopech.insee.lab9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MobileDeviceV6 extends MobileDeviceV5 {
    // Additional UI components
    protected ExtraPanel extraComponent = new ExtraPanel();
    protected VendorsComponent vendorsComponent = new VendorsComponent();
    protected JPanel extraAndVendorsPanel = new JPanel(new BorderLayout());
    protected JPanel vendorsAndRatingPanel = new JPanel(new BorderLayout());

    /**
     * Overrides the addComponents method to apply custom styling and organize components.
     */
    @Override
    public void addComponents() {
        super.addComponents();

        // Define custom color
        Color darkBlue = Color.decode("#000080"); // Dark Blue

        // Apply font and color styling to labels
        JLabel[] labels = {nameLabel, brandLabel, priceLabel, typeLabel};
        for (JLabel label : labels) {
            label.setFont(new Font("Arial", Font.BOLD, 14));
            label.setForeground(darkBlue);
        }

        // Apply font and color styling to extra and vendor components
        extraComponent.setFontAndColor();
        vendorsComponent.setFontAndColor();

        // Customize text field appearance
        nameField.setBackground(Color.LIGHT_GRAY);
        brandField.setBackground(Color.LIGHT_GRAY);
        priceField.setBackground(Color.LIGHT_GRAY);

        nameField.setForeground(Color.DARK_GRAY);
        brandField.setForeground(Color.DARK_GRAY);
        priceField.setForeground(Color.DARK_GRAY);

        // Customize button appearance
        okButton.setForeground(Color.GREEN);
        okButton.setBackground(Color.WHITE);
        cancelButton.setForeground(Color.RED);
        cancelButton.setBackground(Color.WHITE);

        // Add vendor components to the panel
        vendorsAndRatingPanel.add(vendorsComponent.getPanel(), BorderLayout.NORTH);
        vendorsAndRatingPanel.add(vendorsComponent.getRatingLabel(), BorderLayout.CENTER);
        vendorsAndRatingPanel.add(vendorsComponent.getRatingSlider(), BorderLayout.SOUTH);

        // Organize extra and vendor components into a combined panel
        extraAndVendorsPanel.add(extraComponent.getPanel(), BorderLayout.NORTH);
        extraAndVendorsPanel.add(vendorsAndRatingPanel, BorderLayout.CENTER);

        // Add the combined panel to the main panel
        mainPanel.add(extraAndVendorsPanel, BorderLayout.CENTER);
    }

    /**
     * Constructor initializes the MobileDeviceV6 window with a title.
     * 
     * @param title Title of the application window.
     */
    public MobileDeviceV6(String title) {
        super(title);
    }

    /**
     * Creates and displays the MobileDeviceV6 UI.
     */
    public static void createAndShowGUI() {
        MobileDeviceV6 mdv6 = new MobileDeviceV6("Mobile Device V6");
        mdv6.addComponents();
        mdv6.addMenus();
        mdv6.setFrameFeatures();
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
