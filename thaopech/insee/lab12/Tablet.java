/**
 * Tablet class represents a mobile device categorized as a tablet. 
 * It extends the MobileDevice class and implements the Serializable interface 
 * to allow object serialization.
 * 
 * The class includes attributes for the tablet's name, brand, color, and price. 
 * It provides constructors to initialize these attributes and a toString method 
 * for formatted output.
 *
 * @author Insee Thaopech
 * @version 1.0
 */
package thaopech.insee.lab12;

import thaopech.insee.lab7.MobileDevice;

public class Tablet extends MobileDevice implements java.io.Serializable {

    /** Name of the tablet. */
    private String name;

    /** Brand of the tablet. */
    private String brand;

    /** Color of the tablet. */
    private String color;

    /** Price of the tablet. */
    private double price;

    /**
     * Constructs a Tablet with the specified name, brand, and price. 
     * The color is not set initially.
     *
     * @param name  the name of the tablet
     * @param brand the brand of the tablet
     * @param price the price of the tablet
     */
    public Tablet(String name, String brand, double price) {
        super("Color is not being set yet", price);
        this.name = name;
        this.brand = brand;
    }
    
    /**
     * Returns the name of the tablet.
     *
     * @return the tablet name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Returns the brand of the tablet.
     *
     * @return the tablet brand
     */
    public String getBrand() {
        return this.brand;
    }
    
    /**
     * Determines whether the device is a watch.
     *
     * @return false since a tablet is not a watch
     */
    @Override
    public boolean isWatch() {
        return false;
    }
    
    /**
     * Constructs a Tablet with the specified name, brand, price, and color.
     *
     * @param name  the name of the tablet
     * @param brand the brand of the tablet
     * @param price the price of the tablet
     * @param color the color of the tablet
     */
    public Tablet(String name, String brand, double price, String color) {
        super(color, price);
        this.name = name;
        this.brand = brand;
    }
    
    /**
     * Returns a string representation of the tablet, including its name, brand, and price.
     *
     * @return a formatted string describing the tablet
     */
    @Override
    public String toString() {
        return "Tablet: " + this.getName() +
                                " (" + this.getBrand() +
                                ") " + this.getPrice() +
                                " Baht";
    }
}