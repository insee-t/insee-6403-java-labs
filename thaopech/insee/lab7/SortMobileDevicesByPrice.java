package thaopech.insee.lab7;

import java.util.Comparator;
import java.util.Arrays;

/**
 * The SortMobileDevicesByPrice class implements the Comparator interface
 * to sort MobileDevice objects based on their price in ascending order.
 * @author Insee Thaopech
 */
public class SortMobileDevicesByPrice implements Comparator<MobileDevice> {

    /**
     * Main method to test the sorting functionality.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Create array of mobile devices
        MobileDevice[] devices = new MobileDevice[4];
        devices[0] = new IPadAir("Rose Gold", 19900.0, 64);
        devices[1] = new IPadAir("Silver", 24900.0, 256);
        devices[2] = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");
        devices[3] = new AppleWatch("Space Gray", 12900.0, "Apple Watch Ultra");

        // Sort the devices using our comparator
        Arrays.sort(devices, new SortMobileDevicesByPrice());

        // Display sorted devices
        System.out.println("Mobile devices sorted by price:");

        for (MobileDevice device : devices) {
            System.out.println(device);
        }
    }

    /**
     * Compares two MobileDevice objects based on their price.
     *
     * @param device1 The first MobileDevice to compare.
     * @param device2 The second MobileDevice to compare.
     * @return A negative integer, zero, or a positive integer if the first device's
     *         price is less than, equal to, or greater than the second device's price.
     */
    @Override
    public int compare(MobileDevice device1, MobileDevice device2) {
        // Compare the price of both objects
        if (device1.getPrice() < device2.getPrice()) {
            return -1; // device1 is cheaper than device2
        }
        if (device1.getPrice() > device2.getPrice()) {
            return 1; // device1 is more expensive than device2
        }
        return 0; // device1 and device2 have the same price
    }
}