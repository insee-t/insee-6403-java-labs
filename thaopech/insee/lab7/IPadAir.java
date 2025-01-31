package thaopech.insee.lab7;

/**
 * Represents an iPad Air, which is a type of MobileDevice.
 * This class extends the MobileDevice class and adds specific properties
 * and behaviors for an iPad Air, such as storage capacity and chip information.
 * @author Insee Thaopech
 */
public class IPadAir extends MobileDevice {
    private double storage; // Stores the storage capacity of the iPad Air (in GB)
    private static final String CHIP_NAME = "Apple M2"; // Constant for the chip name

    /**
     * Constructor for creating an IPadAir object.
     *
     * @param color   The color of the iPad Air.
     * @param price   The price of the iPad Air.
     * @param storage The storage capacity of the iPad Air (in GB).
     */
    public IPadAir(String color, double price, double storage) {
        super(color, price); // Calls the constructor of the parent class (MobileDevice)
        this.storage = storage; // Initializes the storage property
    }

    /**
     * Retrieves the storage capacity of the iPad Air.
     *
     * @return The storage capacity of the iPad Air (in GB).
     */
    public double getStorage() {
        return storage;
    }

    /**
     * Sets the storage capacity of the iPad Air.
     *
     * @param storage The new storage capacity to set (in GB).
     */
    public void setStorage(double storage) {
        this.storage = storage;
    }

    /**
     * Overrides the toString method to provide a string representation
     * of the IPadAir object, including its color, price, storage capacity,
     * and chip name.
     *
     * @return A string representation of the IPadAir object.
     */
    @Override
    public String toString() {
        return "IPadAir " +
            '[' + super.toString() + // Calls the toString method of the parent class
            ", storage=" + (int) storage + // Displays storage as an integer
            ", chip=" + CHIP_NAME + // Includes the chip name
            ']';
    }

    /**
     * Retrieves the name of the chip used in the iPad Air.
     *
     * @return The chip name (constant value: "Apple M2").
     */
    public static String getChipName() {
        return CHIP_NAME;
    }

    /**
     * Overrides the isWatch method to indicate that this device is not a watch.
     *
     * @return false, since this device is not a watch.
     */
    @Override
    public boolean isWatch() {
        return false;
    }
}