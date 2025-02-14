package thaopech.insee.lab9;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import thaopech.insee.lab9.ExtraPanel;
import thaopech.insee.lab9.VendorsComponent;

import java.awt.BorderLayout;

public class MobileDeviceV5 extends MobileDeviceV4 {
    protected ExtraPanel extraComponent = new ExtraPanel();
    protected VendorsComponent vendorsComponent = new VendorsComponent();
    protected JPanel extraAndVendorsPanel = new JPanel(new BorderLayout());
    protected JPanel vendorsAndRatingPanel = new JPanel(new BorderLayout());

    public MobileDeviceV5(String title) {
        super(title);
    }

    @Override
    protected void addComponents() {
        super.addComponents();
        vendorsAndRatingPanel.add(vendorsComponent.getPanel(), BorderLayout.NORTH);
        vendorsAndRatingPanel.add(vendorsComponent.getRatingLabel(), BorderLayout.CENTER);
        vendorsAndRatingPanel.add(vendorsComponent.getRatingSlider(), BorderLayout.SOUTH);
        extraAndVendorsPanel.add(extraComponent.getPanel(), BorderLayout.NORTH);
        extraAndVendorsPanel.add(vendorsAndRatingPanel, BorderLayout.CENTER);
        mainPanel.add(extraAndVendorsPanel , BorderLayout.CENTER);
    }

    public static void createAndShowGUI() {
        MobileDeviceV5 mdv5 = new MobileDeviceV5("Mobile Device V5");
        mdv5.addComponents();
        mdv5.addMenus();
        mdv5.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
