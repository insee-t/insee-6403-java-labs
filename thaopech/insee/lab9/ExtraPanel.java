/**
 * ExtraPanel class provides additional UI components for selecting an 
 * operating system and displaying device features. It includes a combo box 
 * for OS selection, a text area for features, and an associated scroll pane.
 *
 * This class also applies custom fonts and colors to improve UI aesthetics.
 *
 * @author Insee Thaopech
 * @version 1.0
 */

package thaopech.insee.lab9;

import javax.swing.*;
import java.awt.*;

public class ExtraPanel {
    // UI Components
    private final JPanel extraPanel = new JPanel(new GridLayout(2, 2));
    private final JLabel OSLabel, featureLabel;
    private final String[] OperatingSystems = {"Android", "iOS", "Windows", "Others"};
    private final JComboBox<String> OSComboBox = new JComboBox<>(OperatingSystems);
    private final JTextArea featureTextArea;
    private final JScrollPane featureScrollPane;
    private final JPanel imagePanel = new JPanel(new BorderLayout());
    private final ReadImage samsungGalaxyImage;

    // Custom Colors
    private final Color darkBlue = Color.decode("#000080");  // Dark Blue
    private final Color lightYellow = Color.decode("#FFFFC8"); // Light Yellow

    /**
     * Constructor initializes the UI components including labels, combo box, 
     * text area, and image display.
     */
    public ExtraPanel() {
        // Label and combo box for selecting operating system
        OSLabel = new JLabel("Operating System:");
        OSComboBox.setSelectedIndex(0); // Default selection: "Android"
        OSComboBox.setEditable(false); // Prevent manual text entry

        // Label and text area for entering additional device features
        featureLabel = new JLabel("Features:");
        featureTextArea = new JTextArea(3, 25);
        featureTextArea.setLineWrap(true); // Enable text wrapping
        featureScrollPane = new JScrollPane(featureTextArea); // Add scroll functionality

        // Add components to the extra panel
        extraPanel.add(OSLabel);
        extraPanel.add(OSComboBox);
        extraPanel.add(featureLabel);
        extraPanel.add(featureScrollPane);

        // Load and display an image
        samsungGalaxyImage = new ReadImage("S25-ultra.jpg");
        samsungGalaxyImage.setPreferredSize(new Dimension(400, 400));
        imagePanel.add(samsungGalaxyImage, BorderLayout.NORTH);
        imagePanel.setPreferredSize(new Dimension(400, 400)); // Set image panel size
    }

    /**
     * Returns the panel containing OS selection and feature components.
     * 
     * @return JPanel with extra components.
     */
    public JPanel getPanel() {
        return extraPanel;
    }

    /**
     * Returns the OS selection label.
     * 
     * @return JLabel for operating system.
     */
    public JLabel getOSLabel() {
        return OSLabel;
    }

    /**
     * Returns the feature label.
     * 
     * @return JLabel for device features.
     */
    public JLabel getFeatureLabel() {
        return featureLabel;
    }

    /**
     * Returns the text area for entering device features.
     * 
     * @return JTextArea for features.
     */
    public JTextArea getFeatureTextArea() {
        return featureTextArea;
    }

    /**
     * Sets custom font and color styling for the panel components.
     */
    public void setFontAndColor() {
        JLabel[] labels = {getOSLabel(), getFeatureLabel()};

        for (JLabel label : labels) {
            label.setFont(new Font("Arial", Font.BOLD, 14));
            label.setForeground(darkBlue);
        }

        featureTextArea.setForeground(Color.DARK_GRAY);
        featureTextArea.setBackground(lightYellow);
        featureTextArea.setFont(new Font("Arial", Font.ITALIC, 14));
    }
}
