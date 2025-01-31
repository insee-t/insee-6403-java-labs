package thaopech.insee.lab7;

/**
 * The TestApplewatchNike class is a test class to demonstrate the functionality
 * of the AppleWatchNike class, including inheritance, polymorphism, and health
 * and fitness metrics.
 * @author Insee Thaopech
 */
class TestApplewatchNike {
    public static void main(String[] args) {
        // Create an instance of AppleWatchNike
        AppleWatchNike nikeWatch = new AppleWatchNike("Space Gray", 12900.0,
                "Nike SE GPS", 42.5, 75, 7.5);

        // Display basic information about the AppleWatchNike
        System.out.println(nikeWatch); // Calls the overridden toString method

        // Display health and fitness metrics
        nikeWatch.displayRunningStats(); // Displays total distance run
        nikeWatch.displayHeartRates();   // Displays average heart rate
        nikeWatch.displaySleepHours();   // Displays average sleep hours

        // Test inheritance from AppleWatch
        System.out.println("Is this a watch? " + nikeWatch.isWatch()); // Should print true

        // Test polymorphism by upcasting to the base class (AppleWatch)
        AppleWatch baseWatch = nikeWatch; // Upcasting
        System.out.println("Through base reference: " + baseWatch); // Calls the overridden toString method
    }
}