package thaopech.insee.lab11;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.Timer;

/**
 * A class that extends MobileDeviceCompleteV2 and adds component event listeners,
 * including handling window resizing, movement, visibility, and hiding events.
 */
public class MobileDeviceCompleteV3 extends MobileDeviceCompleteV2 {

    /** Timer to delay resize event handling to prevent excessive updates. */
    private Timer resizeTimer;

    /**
     * Constructor that initializes the MobileDeviceCompleteV3 with a title.
     *
     * @param title The title of the window.
     */
    public MobileDeviceCompleteV3(String title) {
        super(title);
    }

    /**
     * Adds action listeners for component events such as resizing, movement, visibility, and hiding.
     */
    @Override
    protected void addListeners() {
        super.addListeners();
        addComponentListener(new ComponentAdapter() {
            /**
             * Handles window resize events by triggering a delayed response.
             *
             * @param e The component event triggered when the window is resized.
             */
            @Override
            public void componentResized(ComponentEvent e) {
                handleResizeEvent();
            }

            /**
             * Handles window movement events and displays the new window position.
             *
             * @param e The component event triggered when the window is moved.
             */
            @Override
            public void componentMoved(ComponentEvent e) {
                JOptionPane.showMessageDialog(MobileDeviceCompleteV3.this, "Window moved to: X=" + getX() + " Y=" + getY());
            }

            /**
             * Handles window visibility events and notifies when the window becomes visible.
             *
             * @param e The component event triggered when the window is shown.
             */
            @Override
            public void componentShown(ComponentEvent e) {
                JOptionPane.showMessageDialog(MobileDeviceCompleteV3.this, "Window is now visible.");
            }

            /**
             * Handles window hiding events and notifies when the window is hidden.
             *
             * @param e The component event triggered when the window is hidden.
             */
            @Override
            public void componentHidden(ComponentEvent e) {
                JOptionPane.showMessageDialog(MobileDeviceCompleteV3.this, "Window is now hidden.");
            }
        });
    }

    /**
     * Handles resize events by using a timer to delay notifications and prevent excessive updates.
     */
    private void handleResizeEvent() {
        if (resizeTimer != null && resizeTimer.isRunning()) {
            resizeTimer.stop();
        }

        resizeTimer = new Timer(500, e -> {
            JOptionPane.showMessageDialog(MobileDeviceCompleteV3.this, "Window resized to: " + getWidth() + " x " + getHeight());
            resizeTimer.stop();
        });

        resizeTimer.setRepeats(false);
        resizeTimer.start();
    }

    /**
     * The main method that launches the application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MobileDeviceCompleteV3 window = new MobileDeviceCompleteV3("Mobile Device Complete V3");
            window.addComponents();
            window.addMenus();
            window.addListeners();
            window.setFrameFeatures();
        });
    }
}