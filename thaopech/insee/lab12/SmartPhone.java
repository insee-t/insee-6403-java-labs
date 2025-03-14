/**
 * SmartPhone class represents a mobile device categorized as a smartphone. 
 * It extends the MobileDevice class and implements the Serializable interface 
 * to allow object serialization.
 * 
 * The class includes attributes for the smartphone's name, brand, color, and price. 
 * It provides constructors to initialize these attributes and a toString method 
 * for formatted output.
 *
 * @author Insee Thaopech
 * @version 1.0
 */
package thaopech.insee.lab12;

import thaopech.insee.lab7.MobileDevice;

public class SmartPhone extends MobileDevice implements java.io.Serializable {

    /** Name of the smartphone. */
    private String name;

    /** Brand of the smartphone. */
    private String brand;

    /** Color of the smartphone. */
    private String color;

    /** Price of the smartphone. */
    private double price;

    /**
     * Constructs a SmartPhone with the specified name, brand, and price. 
     * The color is not set initially.
     *
     * @param name  the name of the smartphone
     * @param brand the brand of the smartphone
     * @param price the price of the smartphone
     */
    public SmartPhone(String name, String brand, double price) {
        super("Color is not being set yet", price);
        this.name = name;
        this.brand = brand;
    }
    
    /**
     * Returns the name of the smartphone.
     *
     * @return the smartphone name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Returns the brand of the smartphone.
     *
     * @return the smartphone brand
     */
    public String getBrand() {
        return this.brand;
    }

    /**
     * Determines whether the device is a watch.
     *
     * @return false since a smartphone is not a watch
     */
    @Override
    public boolean isWatch() {
        return false;
    }

    /**
     * Constructs a SmartPhone with the specified name, brand, price, and color.
     *
     * @param name  the name of the smartphone
     * @param brand the brand of the smartphone
     * @param price the price of the smartphone
     * @param color the color of the smartphone
     */
    public SmartPhone(String name, String brand, double price, String color) {
        super(color, price);
        this.name = name;
        this.brand = brand;
    }
    
    /**
     * Returns a string representation of the smartphone, including its name, brand, and price.
     *
     * @return a formatted string describing the smartphone
     */
    @Override
    public String toString() {
        return "SmartPhone: " + this.getName() +
                                " (" + this.getBrand() +
                                ") " + this.getPrice() +
                                " Baht";
    }
}