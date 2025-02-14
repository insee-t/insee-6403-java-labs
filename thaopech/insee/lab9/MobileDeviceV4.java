package thaopech.insee.lab9;

import thaopech.insee.lab8.*;
import javax.swing.JMenu; import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import java.awt.*;

public class MobileDeviceV4 extends MobileDeviceV3 {

  protected JMenuBar menuBar;
  protected JMenu file, config, size, color, font;
  protected JMenuItem newFile, openFile, saveFile ,exitFile, smallFont, mediumFont, largeFont, extraLargeFont, black, red, green, blue, font1, font2, font3;

  public MobileDeviceV4(String title) {
    super(title);
  }

  @Override
  protected void addComponents() {
    super.addComponents();

    menuBar = new JMenuBar();
    file = new JMenu("File");
    config = new JMenu("Config");

    newFile = new JMenuItem("New");
    openFile = new JMenuItem("Open");
    saveFile = new JMenuItem("Save");
    exitFile = new JMenuItem("Exit");

    newFile.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./images/new_icon.png")));
    openFile.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./images/open_icon.png")));
    saveFile.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./images/save_icon.png")));
    exitFile.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./images/exit_icon.png")));

    size = new JMenu("Size");
    color = new JMenu("Color");
    font = new JMenu("Font");

    smallFont = new JMenuItem("Small");
    mediumFont = new JMenuItem("Medium");
    largeFont = new JMenuItem("Large");
    extraLargeFont = new JMenuItem("Extra Large");

    smallFont.setFont(new Font("Arial", Font.PLAIN, 10));
    mediumFont.setFont(new Font("Arial", Font.PLAIN, 14));
    largeFont.setFont(new Font("Arial", Font.PLAIN, 18));
    extraLargeFont.setFont(new Font("Arial", Font.PLAIN, 22));

    black = new JMenuItem("Black");
    red = new JMenuItem("Red");
    green = new JMenuItem("Green");
    blue = new JMenuItem("Blue");

    black.setForeground(Color.BLACK);
    red.setForeground(Color.RED);
    green.setForeground(Color.GREEN);
    blue.setForeground(Color.BLUE);

    font1 = new JMenuItem("Font 1");
    font2 = new JMenuItem("Font 2");
    font3 = new JMenuItem("Font 3");

    font1.setFont(new Font("Serif", Font.PLAIN, 14));
    font2.setFont(new Font("SansSerif", Font.PLAIN, 14));
    font3.setFont(new Font("Monospaced", Font.PLAIN, 14));
  }

  @Override
  protected void addMenus() {
    file.add(newFile);
    file.add(openFile);
    file.add(saveFile);
    file.add(exitFile);

    config.add(size);
    config.add(color);
    config.add(font);

    size.add(smallFont);
    size.add(mediumFont);
    size.add(largeFont);
    size.add(extraLargeFont);

    color.add(black);
    color.add(red);
    color.add(green);
    color.add(blue);

    font.add(font1);
    font.add(font2);
    font.add(font3);

    menuBar.add(file);
    menuBar.add(config);

    setJMenuBar(menuBar);
  }

  public static void createAndShowGUI() {
    MobileDeviceV4 mdv4 = new MobileDeviceV4("Mobile Device V4");
    mdv4.addComponents();
    mdv4.addMenus();
    mdv4.setFrameFeatures();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}
