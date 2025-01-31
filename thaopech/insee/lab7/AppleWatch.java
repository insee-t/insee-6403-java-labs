package thaopech.insee.lab7;

/**
 * Represents an Apple Watch, which is a type of MobileDevice.
 * This class extends the MobileDevice class and adds specific properties
 * and behaviors for an Apple Watch.
 * @author Insee Thaopech
 */
public class AppleWatch extends MobileDevice {
    private String modelName; // Stores the model name of the Apple Watch

    /**
     * Constructor for creating an AppleWatch object.
     *
     * @param color     The color of the Apple Watch.
     * @param price     The price of the Apple Watch.
     * @param modelName The model name of the Apple Watch.
     */
    public AppleWatch(String color, double price, String modelName) {
        super(color, price); // Calls the constructor of the parent class (MobileDevice)
        this.modelName = modelName; // Initializes the modelName property
    }

    /**
     * Sets the model name of the Apple Watch.
     *
     * @param modelName The new model name to set.
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * Retrieves the model name of the Apple Watch.
     *
     * @return The model name of the Apple Watch.
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Overrides the toString method to provide a string representation
     * of the AppleWatch object, including its color, price, and model name.
     *
     * @return A string representation of the AppleWatch object.
     */
    @Override
    public String toString() {
        return "AppleWatch " +
            '[' + super.toString() + // Calls the toString method of the parent class
            ", modelName=" + modelName +
            ']';
    }

    /**
     * Overrides the isWatch method to indicate that this device is a watch.
     *
     * @return true, since this device is a watch.
     */
    @Override
    public boolean isWatch() {
        return true;
    }
}