package thaopech.insee.lab7;

import java.util.Comparator;
import java.util.Arrays;

/**
 * The SortMobileDevices class implements the Comparator interface to sort
 * MobileDevice objects based on multiple criteria, such as price, storage
 * (for iPads), and model name (for Apple Watches).
 * @author Insee Thaopech
 */
public class SortMobileDevices implements Comparator<MobileDevice> {

    /**
     * Main method to test the sorting functionality.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Create array of mobile devices with test cases
        MobileDevice[] devices = new MobileDevice[7];
        devices[0] = new IPadAir("Rose Gold", 19900.0, 64);
        devices[1] = new IPadAir("Silver", 24900.0, 256);
        // Same price, different storage
        devices[2] = new IPadAir("Space Gray", 19900.0, 128);
        devices[3] = new IPadAir("Silver", 19900.0, 64);
        // AppleWatches with different prices
        devices[4] = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");
        // Same price, different models
        devices[5] = new AppleWatch("Space Gray", 12900.0, "Apple Watch Ultra");
        devices[6] = new AppleWatch("Gold", 12900.0, "Apple Watch Series 7");

        // Sort the devices using our comparator
        Arrays.sort(devices, new SortMobileDevices());

        // Display sorted devices
        System.out.println("Mobile devices sorted by multiple criteria:");

        for (MobileDevice device : devices) {
            System.out.println(device);
        }
    }

    /**
     * Compares two MobileDevice objects based on multiple criteria:
     * 1. Price (ascending order).
     * 2. If both devices are IPadAir, compare by storage (ascending order).
     * 3. If both devices are AppleWatch, compare by model name (alphabetical order).
     * 4. If the devices are of different types, compare by color (alphabetical order).
     *
     * @param device1 The first MobileDevice to compare.
     * @param device2 The second MobileDevice to compare.
     * @return A negative integer, zero, or a positive integer if the first device
     *         is less than, equal to, or greater than the second device.
     */
    @Override
    public int compare(MobileDevice device1, MobileDevice device2) {
        // Compare by price first
        if (device1.getPrice() < device2.getPrice()) {
            return -1;
        }
        if (device1.getPrice() > device2.getPrice()) {
            return 1;
        }

        // Handle the case where both devices are IPadAir
        if (device1 instanceof IPadAir && device2 instanceof IPadAir) {
            return compareIPadAirs((IPadAir) device1, (IPadAir) device2);
        }

        // Handle the case where both devices are AppleWatch
        if (device1 instanceof AppleWatch && device2 instanceof AppleWatch) {
            return compareAppleWatches((AppleWatch) device1, (AppleWatch) device2);
        }

        // Handle the case where only one of the devices is an IPadAir
        return device1.getColor().compareTo(device2.getColor());
    }

    /**
     * Compares two IPadAir objects based on storage capacity and color.
     *
     * @param ipad1 The first IPadAir to compare.
     * @param ipad2 The second IPadAir to compare.
     * @return A negative integer, zero, or a positive integer if the first iPad
     *         is less than, equal to, or greater than the second iPad.
     */
    private int compareIPadAirs(IPadAir ipad1, IPadAir ipad2) {
        if (ipad1.getStorage() < ipad2.getStorage()) {
            return -1;
        }
        if (ipad1.getStorage() > ipad2.getStorage()) {
            return 1;
        }
        return ipad1.getColor().compareTo(ipad2.getColor());
    }

    /**
     * Compares two AppleWatch objects based on model name and color.
     *
     * @param watch1 The first AppleWatch to compare.
     * @param watch2 The second AppleWatch to compare.
     * @return A negative integer, zero, or a positive integer if the first watch
     *         is less than, equal to, or greater than the second watch.
     */
    private int compareAppleWatches(AppleWatch watch1, AppleWatch watch2) {
        int compareModelResult = watch1.getModelName().compareTo(watch2.getModelName());
        if (compareModelResult != 0) {
            return compareModelResult;
        }
        return watch1.getColor().compareTo(watch2.getColor());
    }
}