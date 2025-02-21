package thaopech.insee.lab10;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.JMenuItem;

import thaopech.insee.lab9.MobileDeviceV7;

public class MobileDeviceV8 extends MobileDeviceV7 implements ActionListener {
  
    // Additional UI components
  protected ExtraPanelV2 extraComponent = new ExtraPanelV2();

  public void addListeners() {
    cancelButton.addActionListener(this);
    okButton.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object src = e.getSource();
    if (src == okButton) {

      smartPhoneButton.setActionCommand("Smartphone");
      tabletButton.setActionCommand("Tablet");
      String values = vendorsComponent.getVendorsList().getSelectedValuesList().toString();
      String valuesWithoutBrackets = values.substring(1, values.length() - 1);

      String info = "Device Name: " + nameField.getText() + '\n'
          + "Brand: " + brandField.getText() + '\n'
          + "Price: " + priceField.getText() + '\n'
          + "Type: " + deviceTypeGroup.getSelection().getActionCommand() + '\n'
          + "Operating System: " + extraComponent.getOSComboBox().getSelectedItem() + '\n'
          + "Features: " + extraComponent.getFeatureTextArea().getText() + '\n'
          + "Available at: " + valuesWithoutBrackets + '\n'
          + "Rating: " + vendorsComponent.getRatingSlider().getValue();

      JOptionPane.showMessageDialog(null, info, "Device Information", JOptionPane.INFORMATION_MESSAGE);

    } else if (src == cancelButton) {
      nameField.setText("");
      brandField.setText("");
      priceField.setText("");
      extraComponent.getFeatureTextArea().setText("");
      smartPhoneButton.setSelected(true);
      extraComponent.getOSComboBox().setSelectedIndex(0);
      vendorsComponent.getVendorsList().clearSelection();
      vendorsComponent.getRatingSlider().setValue(5);
    }
  }

  public MobileDeviceV8(String title) {
    super(title);
  }

  @Override
  public void addComponents() {
    super.addComponents();
    
    // Set extra features and vendor rating
    extraComponent.getFeatureTextArea().setText(
            "- 200MP Camera \n- 1TB Storage \n- Snapdragon Gen 4 Processor \n- 5000mAh Battery \n- 6.8-inch AMOLED Display \n- 120Hz Refresh Rate \n Fast Charging ");

    // Apply font and color settings
    extraComponent.setFontAndColor();
    extraAndVendorsPanel.add(extraComponent.getPanel(), BorderLayout.NORTH);
  }

  public static void createAndShowGUI() {
    MobileDeviceV8 mdv8 = new MobileDeviceV8("Mobile Device V8");
    mdv8.addComponents();
    mdv8.addListeners();
    mdv8.setFrameFeatures();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}
