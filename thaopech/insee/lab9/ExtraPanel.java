package thaopech.insee.lab9;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.ListSelectionModel;
import java.awt.GridLayout;
import java.awt.*;

public class ExtraPanel {
    // Additional UI components
    private final ReadImage samsungGalaxyImage;
    private final JPanel extraPanel = new JPanel(new GridLayout(2, 2)); 
    private final JLabel OSLabel, featureLabel;
    private final String[] OperatingSystems = {"Android", "iOS", "Windows", "Others"};
    private final JComboBox <String> OSComboBox = new JComboBox<>(OperatingSystems);
    private final JTextArea featureTextArea;
    private final JScrollPane featureScrollPane;
    private final JPanel imagePanel = new JPanel(new BorderLayout());

    String hexLightYellow = "#FFFFC8";
    String hexDarkBlue = "#000080";
    Color darkBlue = Color.decode(hexDarkBlue);
    Color lightYellow = Color.decode(hexLightYellow);

    public ExtraPanel() {

        // Label and combo box for selecting operating system
        OSLabel = new JLabel("Operating System:");
        OSComboBox.setSelectedIndex(0); // Default selection is "Android"
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

        samsungGalaxyImage = new ReadImage("S25-ultra.jpg");
        samsungGalaxyImage.setPreferredSize(new Dimension(400, 400));
        imagePanel.add(samsungGalaxyImage, BorderLayout.NORTH);
        imagePanel.setPreferredSize(new Dimension(400, 400)); // Set appropriate width and height for your image
    }


    public JPanel getPanel() {
        return extraPanel;
    }

    public JLabel getOSLabel() {
	    return OSLabel;
    }

    public JLabel getFeatureLabel() {
	    return featureLabel;
    }

    public JTextArea getFeatureTextArea() {
	    return featureTextArea;
    }

    public void setFontAndColor() {

        JLabel[] labels = {
            this.getOSLabel(),
            this.getFeatureLabel(),
        };

        for (JLabel label : labels) {
            label.setFont(new Font("Arial", Font.BOLD, 14));
            label.setForeground(darkBlue);
        }

        this.getFeatureTextArea().setForeground(Color.DARK_GRAY);
        this.getFeatureTextArea().setBackground(lightYellow);
        this.getFeatureTextArea().setFont(new Font("Arial", Font.ITALIC, 14));
    }
}
