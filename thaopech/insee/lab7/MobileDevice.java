package thaopech.insee.lab7;

/**
 * Represents an abstract class for mobile devices.
 * This class serves as a base class for specific types of mobile devices,
 * providing common properties and behaviors such as color and price.
 * It also defines an abstract method `isWatch` that must be implemented
 * by subclasses to indicate whether the device is a watch.
 * @author Insee Thaopech
 */
public abstract class MobileDevice {
    protected String color; // Stores the color of the mobile device
    protected double price; // Stores the price of the mobile device

    /**
     * Constructor for creating a MobileDevice object.
     *
     * @param color The color of the mobile device.
     * @param price The price of the mobile device.
     */
    public MobileDevice(String color, double price) {
        this.color = color; // Initializes the color property
        this.price = price; // Initializes the price property
    }

    /**
     * Retrieves the color of the mobile device.
     *
     * @return The color of the mobile device.
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the mobile device.
     *
     * @param color The new color to set.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Retrieves the price of the mobile device.
     *
     * @return The price of the mobile device.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the mobile device.
     *
     * @param price The new price to set.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Abstract method to determine if the mobile device is a watch.
     * This method must be implemented by subclasses.
     *
     * @return true if the device is a watch, false otherwise.
     */
    public abstract boolean isWatch();

    /**
     * Overrides the toString method to provide a string representation
     * of the MobileDevice object, including its color and price.
     *
     * @return A string representation of the MobileDevice object.
     */
    @Override
    public String toString() {
        return "color=" + color + ", price=" + price;
    }
}