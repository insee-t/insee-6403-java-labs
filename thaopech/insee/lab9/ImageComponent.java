/**
 * ImageComponent class is responsible for displaying an image 
 * representing a mobile device. It utilizes the ReadImage class 
 * to load and display the image within a JPanel.
 * 
 * This component is designed to be integrated into a GUI layout.
 *
 * @author Insee Thaopech
 * @version 1.0
 */

package thaopech.insee.lab9;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class ImageComponent {
    // Image display component
    private final ReadImage samsungGalaxyImage;
    private final JPanel imagePanel = new JPanel(new BorderLayout());

    /**
     * Constructor initializes the image panel with a specified image.
     * The image is displayed at the top of the panel.
     */
    public ImageComponent() {
        // Load image of Samsung Galaxy S25 Ultra
        samsungGalaxyImage = new ReadImage("S25-ultra.jpg");
        samsungGalaxyImage.setPreferredSize(new Dimension(400, 350));

        // Add image to panel and set preferred size
        imagePanel.add(samsungGalaxyImage, BorderLayout.NORTH);
        imagePanel.setPreferredSize(new Dimension(400, 350)); // Adjust panel size as needed
    }

    /**
     * Provides the JPanel containing the image.
     * 
     * @return JPanel with the loaded image.
     */
    public JPanel getPanel() {
        return imagePanel;
    }
}
