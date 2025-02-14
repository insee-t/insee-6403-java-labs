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

public class ImageComponent {
    // Additional UI components
    private final ReadImage samsungGalaxyImage;
    private final JPanel imagePanel = new JPanel(new BorderLayout());
    public ImageComponent() {

        samsungGalaxyImage = new ReadImage("S25-ultra.jpg");
        samsungGalaxyImage.setPreferredSize(new Dimension(400, 350));
        imagePanel.add(samsungGalaxyImage, BorderLayout.NORTH);
        imagePanel.setPreferredSize(new Dimension(400, 350)); // Set appropriate width and height for your image
    }

    public JPanel getPanel() {
	return imagePanel;
}
}
