// remove get path and add space.
package thaopech.insee.lab10;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MobileDeviceV9 extends MobileDeviceV8 {

    @Override
    public void addListeners() {
        super.addListeners();
        newMenuItem.addActionListener(this);
        openMenuItem.addActionListener(this);
        saveMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);
        smallMenuItem.addActionListener(this);
        mediumMenuItem.addActionListener(this);
        largeMenuItem.addActionListener(this);
        extraLargeMenuItem.addActionListener(this);
        blackMenuItem.addActionListener(this);
        redMenuItem.addActionListener(this);
        greenMenuItem.addActionListener(this);
        blueMenuItem.addActionListener(this);
        font1MenuItem.addActionListener(this);
        font2MenuItem.addActionListener(this);
        font3MenuItem.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String fontFamily = extraComponent.getFeatureTextArea().getFont().getFamily();
        int fontSize = extraComponent.getFeatureTextArea().getFont().getSize();
        Color fontColor = extraComponent.getFeatureTextArea().getForeground();

        Object src = e.getSource();
        super.actionPerformed(e);
        JMenuItem currentMenuItem = null;

        if (src instanceof JMenuItem) {
            currentMenuItem = (JMenuItem) src;
        }

        if (src == newMenuItem) {
            nameField.setText("");
            brandField.setText("");
            priceField.setText("");
            extraComponent.getFeatureTextArea().setText("");
            smartPhoneButton.setSelected(true);
            OSComboBox.setSelectedIndex(0);
            vendorsComponent.getVendorsList().clearSelection();
            vendorsComponent.getRatingSlider().setValue(5);
            return;
        }

        if (src == openMenuItem) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                JOptionPane.showMessageDialog(this, "Opening: " + selectedFile.getName(), "Message", JOptionPane.INFORMATION_MESSAGE);
            }
            return;
        }

        if (src == saveMenuItem) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showSaveDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                JOptionPane.showMessageDialog(this, "Data is saved to " + selectedFile.getName() + " successfully", "Save", JOptionPane.INFORMATION_MESSAGE);
            }
            return;
        }

        if (src == exitMenuItem) {
            System.exit(1);
        }

        if (src == smallMenuItem
            || src == mediumMenuItem
            || src == largeMenuItem
            || src == extraLargeMenuItem) {
            fontSize = currentMenuItem.getFont().getSize();
            setAllFont(fontFamily, fontSize);
            return;
        }
        
        if (src == font1MenuItem
            || src == font2MenuItem
            || src == font3MenuItem) {
            fontFamily = currentMenuItem.getFont().getFamily();
            setAllFont(fontFamily, fontSize);
            return;
        }

        if (src == blackMenuItem
            || src == redMenuItem
            || src == greenMenuItem
            || src == blueMenuItem) {
            fontColor = currentMenuItem.getForeground();
            nameField.setForeground(fontColor);
            brandField.setForeground(fontColor);
            priceField.setForeground(fontColor);
            extraComponent.getFeatureTextArea().setForeground(fontColor);
            return;
        }

    }
    
    public void setAllFont(String fontFamily, int fontSize) {
        nameField.setFont(new Font(fontFamily, nameField.getFont().getStyle(), fontSize));
        brandField.setFont(new Font(fontFamily, brandField.getFont().getStyle(), fontSize));
        priceField.setFont(new Font(fontFamily, priceField.getFont().getStyle(), fontSize));
        extraComponent.getFeatureTextArea().setFont(new Font(fontFamily, extraComponent.getFeatureTextArea().getFont().getStyle(), fontSize));
    }

    public MobileDeviceV9(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        MobileDeviceV9 mdv9 = new MobileDeviceV9("Mobile Device V9");
        mdv9.addComponents();
        mdv9.addMenus();
        mdv9.addListeners();
        mdv9.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
