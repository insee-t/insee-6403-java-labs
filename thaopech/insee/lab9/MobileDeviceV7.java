package thaopech.insee.lab9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import thaopech.insee.lab9.ExtraPanel;
import thaopech.insee.lab9.VendorsComponent;

public class MobileDeviceV7 extends MobileDeviceV6 {
    protected ExtraPanel extraComponent = new ExtraPanel();
    protected VendorsComponent vendorsComponent = new VendorsComponent();
    protected JPanel extraAndVendorsPanel = new JPanel(new BorderLayout());
    protected JPanel vendorsAndRatingPanel = new JPanel(new BorderLayout());
    protected ImageComponent imageComponent = new ImageComponent();

    @Override
    public void addComponents() {
        super.addComponents();
        nameField.setText("Samsung Galaxy S25 Ultra");
        brandField.setText("Samsung");
        priceField.setText("46,900");
        extraComponent.getFeatureTextArea().setText(
                "- 200MP Camera \n- 1TB Storage \n- Snapdragon Gen 4 Processor \n- 5000mAh Battery \n- 6.8-inch AMOLED Display \n- 120Hz Refresh Rate \n Fast Charging ");
        vendorsComponent.getRatingSlider().setValue(9);

        extraComponent.setFontAndColor();
        vendorsComponent.setFontAndColor();

        vendorsAndRatingPanel.add(vendorsComponent.getPanel(), BorderLayout.NORTH);
        vendorsAndRatingPanel.add(vendorsComponent.getRatingLabel(), BorderLayout.CENTER);
        vendorsAndRatingPanel.add(vendorsComponent.getRatingSlider(), BorderLayout.SOUTH);
        extraAndVendorsPanel.add(extraComponent.getPanel(), BorderLayout.NORTH);
        extraAndVendorsPanel.add(vendorsAndRatingPanel, BorderLayout.CENTER);
        extraAndVendorsPanel.add(imageComponent.getPanel(), BorderLayout.SOUTH);
        mainPanel.add(extraAndVendorsPanel , BorderLayout.CENTER);
    }

    public MobileDeviceV7(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        MobileDeviceV7 mdv7 = new MobileDeviceV7("Mobile Device V7");
        mdv7.addComponents();
        mdv7.addMenus();
        mdv7.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
