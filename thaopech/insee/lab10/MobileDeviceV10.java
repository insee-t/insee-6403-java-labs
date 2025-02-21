package thaopech.insee.lab10;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionListener;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;

import thaopech.insee.lab10.MobileDeviceV9;

public class MobileDeviceV10 extends MobileDeviceV9 implements ItemListener, ListSelectionListener, ChangeListener {

    @Override
    public void addListeners() {
        super.addListeners();
        extraComponent.getOSComboBox().addItemListener(this);
        vendorsComponent.getVendorsList().addListSelectionListener(this);
        vendorsComponent.getRatingSlider().addChangeListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == extraComponent.getOSComboBox() && e.getStateChange() == ItemEvent.SELECTED) {
            JOptionPane.showMessageDialog(this, "You selected Operating System: " + extraComponent.getOSComboBox().getSelectedItem(), "OS Selection", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting() && e.getSource() == vendorsComponent.getVendorsList()) {
            List<String> selectedVendors = vendorsComponent.getVendorsList().getSelectedValuesList();
            String selectedVendorsString = String.join(", ", selectedVendors);
            JOptionPane.showMessageDialog(this, "Device is available at: " + selectedVendorsString, "Vendor Selection", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == vendorsComponent.getRatingSlider()) {
            JSlider Temp = (JSlider) e.getSource();
            if (!Temp.getValueIsAdjusting()) {
                JOptionPane.showMessageDialog(this, "New rating: " + vendorsComponent.getRatingSlider().getValue(), "Rating Adjustment", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public MobileDeviceV10(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        MobileDeviceV10 mdv10 = new MobileDeviceV10("Mobile Device V10");
        mdv10.addComponents();
        mdv10.addMenus();
        mdv10.addListeners();
        mdv10.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}