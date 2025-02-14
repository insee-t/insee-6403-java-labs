package thaopech.insee.lab9;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Font;

/**
 * MobileDeviceV6
 */
public class MobileDeviceV6 extends MobileDeviceV5 {
    protected ExtraPanel extraComponent = new ExtraPanel();
    protected VendorsComponent vendorsComponent = new VendorsComponent();
    protected JPanel extraAndVendorsPanel = new JPanel(new BorderLayout());
    protected JPanel vendorsAndRatingPanel = new JPanel(new BorderLayout());

    @Override
    public void addComponents() {
        super.addComponents();

        String hexDarkBlue = "#000080";

        Color darkBlue = Color.decode(hexDarkBlue);

        JLabel[] labels = {
            nameLabel,
            brandLabel,
            priceLabel,
            typeLabel,
        };

        for (JLabel label : labels) {
            label.setFont(new Font("Arial", Font.BOLD, 14));
            label.setForeground(darkBlue);
        }

        extraComponent.setFontAndColor();
        vendorsComponent.setFontAndColor();

        nameField.setBackground(Color.LIGHT_GRAY);
        brandField.setBackground(Color.LIGHT_GRAY);
        priceField.setBackground(Color.LIGHT_GRAY);

        nameField.setForeground(Color.DARK_GRAY);
        brandField.setForeground(Color.DARK_GRAY);
        priceField.setForeground(Color.DARK_GRAY);

        okButton.setForeground(Color.GREEN);
        okButton.setBackground(Color.WHITE);
        cancelButton.setForeground(Color.RED);
        cancelButton.setBackground(Color.WHITE);

        vendorsAndRatingPanel.add(vendorsComponent.getPanel(), BorderLayout.NORTH);
        vendorsAndRatingPanel.add(vendorsComponent.getRatingLabel(), BorderLayout.CENTER);
        vendorsAndRatingPanel.add(vendorsComponent.getRatingSlider(), BorderLayout.SOUTH);
        extraAndVendorsPanel.add(extraComponent.getPanel(), BorderLayout.NORTH);
        extraAndVendorsPanel.add(vendorsAndRatingPanel, BorderLayout.CENTER);
        mainPanel.add(extraAndVendorsPanel , BorderLayout.CENTER);
    }

    public MobileDeviceV6(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        MobileDeviceV6 mdv6 = new MobileDeviceV6("Mobile Device V6");
        mdv6.addComponents();
        mdv6.addMenus();
        mdv6.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
