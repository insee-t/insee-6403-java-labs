package thaopech.insee.lab9;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.ListSelectionModel;
import java.awt.*;

public class VendorsComponent {

    private final String[] vendors = { "AIS", "True", "DTAC", "Shopee" };
    private final JList<String> vendorsList = new JList<String>(vendors);
    private final JScrollPane vendorsScrollPane = new JScrollPane(vendorsList);
    private final JSlider ratingSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
    private final JPanel vendorsPanel = new JPanel(new GridLayout(1, 2));
    private final JLabel vendorsLabel = new JLabel("The device is available at:");
    private final JLabel ratingLabel = new JLabel("Rate the device (0-10):");

    String hexDarkBlue = "#000080";
    String hexDarkGreen = "#006400";

    Color darkBlue = Color.decode(hexDarkBlue);
    Color darkGreen = Color.decode(hexDarkGreen);

    public VendorsComponent() {

        vendorsList.setSelectedIndex(0);
        vendorsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        vendorsList.setVisibleRowCount(4);
        ratingSlider.setPaintTicks(true);
        ratingSlider.setPaintLabels(true);
        ratingSlider.setMajorTickSpacing(1);
        vendorsPanel.add(vendorsLabel);
        vendorsPanel.add(vendorsScrollPane);
    }

    public JPanel getPanel() {
	    return vendorsPanel;
    }

    public JLabel getRatingLabel() {
        return ratingLabel;
    }

    public JLabel getVendorsLabel() {
        return vendorsLabel;
    }

    public JSlider getRatingSlider() {
	    return ratingSlider;
    }

    public JList<String> getVendorsList() {
        return vendorsList;
    }

    public void setFontAndColor() {

        JLabel[] labels = {
            this.getRatingLabel(),
            this.getVendorsLabel()
        };

        for (JLabel label : labels) {
            label.setFont(new Font("Arial", Font.BOLD, 14));
            label.setForeground(darkBlue);
        }

        this.getVendorsList().setBackground(Color.LIGHT_GRAY);
        this.getVendorsList().setForeground(darkGreen);
        this.getVendorsList().setFont(new Font("Arial", Font.BOLD, 14));
        this.getVendorsList().setSelectionBackground(Color.YELLOW);
        this.getVendorsList().setSelectionForeground(Color.BLACK);
    }
}
