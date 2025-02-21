package thaopech.insee.lab10;

import javax.swing.*;
import java.awt.*;

public class ExtraPanelV2 {
    // UI Components
    protected JPanel extraPanel = new JPanel(new GridLayout(2, 2));
    protected JLabel oSLabel, featureLabel;
    protected String[] OperatingSystems = {"Android", "iOS", "Windows", "Others"};
    protected JComboBox<String> oSComboBox = new JComboBox<>(OperatingSystems);
    protected JTextArea featureTextArea;
    protected JScrollPane featureScrollPane;

    // Custom Colors
    protected Color darkBlue = Color.decode("#000080");  // Dark Blue
    protected Color lightYellow = Color.decode("#FFFFC8"); // Light Yellow

    /**
     * Constructor initializes the UI components including labels, combo box, 
     * text area, and image display.
     */
    public ExtraPanelV2() {
        // Label and combo box for selecting operating system
        oSLabel = new JLabel("Operating System:");
        oSComboBox.setSelectedIndex(0); // Default selection: "Android"
        oSComboBox.setEditable(false); // Prevent manual text entry

        // Label and text area for entering additional device features
        featureLabel = new JLabel("Features:");
        featureTextArea = new JTextArea(3, 25);
        featureTextArea.setLineWrap(true); // Enable text wrapping
        featureScrollPane = new JScrollPane(featureTextArea); // Add scroll functionality

        // Add components to the extra panel
        extraPanel.add(oSLabel);
        extraPanel.add(oSComboBox);
        extraPanel.add(featureLabel);
        extraPanel.add(featureScrollPane);
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
        return oSLabel;
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
    
    public JComboBox<String> getOSComboBox() {
        return oSComboBox;
    }
    
    public JScrollPane getFeatureScrollPane() {
        return featureScrollPane;
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
