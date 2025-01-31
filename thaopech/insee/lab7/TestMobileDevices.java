package thaopech.insee.lab7;

/**
 * The TestMobileDevices class is a test class to demonstrate the functionality
 * of the IPadAir and AppleWatch classes, including inheritance, method overriding,
 * and price comparison.
 * @author Insee Thaopech
 */
public class TestMobileDevices {
    public static void main(String[] args) {
        // Create instances of IPadAir and AppleWatch
        IPadAir ipadAir1 = new IPadAir("Rose Gold", 19900.0, 64);
        IPadAir ipadAir2 = new IPadAir("Silver", 24900.0, 256);
        AppleWatch appleWatch1 = new AppleWatch("Silver", 9400.0,
                                                "Apple Watch Nike SE GPS");

        // Display the chip name of the IPadAir
        System.out.println("IPadAir chip name is " + IPadAir.getChipName());

        // Check if the IPadAir is a watch
        if (ipadAir2.isWatch()) {
            System.out.println(ipadAir2 + " is a watch");
        } else {
            System.out.println(ipadAir2 + " is not a watch");
        }

        // Compare prices of devices
        comparePrice(ipadAir1, ipadAir2); // Compare two iPads
        comparePrice(ipadAir1, appleWatch1); // Compare an iPad and an Apple Watch
    }

    /**
     * Compares the prices of two MobileDevice objects and prints the result.
     *
     * @param device1 The first MobileDevice to compare.
     * @param device2 The second MobileDevice to compare.
     */
    public static void comparePrice(MobileDevice device1, MobileDevice device2) {
        String result = comparePriceResponse(device1, device2);
        System.out.println(result);
    }

    /**
     * Compares the prices of two MobileDevice objects and returns a string
     * describing the result of the comparison.
     *
     * @param device1 The first MobileDevice to compare.
     * @param device2 The second MobileDevice to compare.
     * @return A string describing which device is cheaper or if they are the same price.
     */
    public static String comparePriceResponse(MobileDevice device1, MobileDevice device2) {
        if (device1.getPrice() < device2.getPrice()) {
            return String.format("%s is cheaper than %s", device1, device2);
        }
        if (device1.getPrice() > device2.getPrice()) {
            return String.format("%s is cheaper than %s", device2, device1);
        }
        return String.format("%s is as cheap as %s", device1, device2);
    }
}