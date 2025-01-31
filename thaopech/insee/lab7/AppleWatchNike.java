package thaopech.insee.lab7;

/**
 * Represents an Apple Watch Nike, which is a specialized version of the Apple Watch.
 * This class extends the AppleWatch class and implements the HealthMonitorer and
 * RunnerStatsCollector interfaces to provide additional functionality for monitoring
 * health metrics and collecting running statistics.
 * @author Insee Thaopech
 */
public class AppleWatchNike extends AppleWatch implements HealthMonitorer, RunnerStatsCollector {
    private double pace;
    private double totalDistance; 
    private double time;
    private double avgHeartRate;
    private double maxHeartRate;
    private double avgSleepHours; 

    /**
     * Constructor for creating an AppleWatchNike object with basic properties.
     *
     * @param color     The color of the Apple Watch Nike.
     * @param price     The price of the Apple Watch Nike.
     * @param modelName The model name of the Apple Watch Nike.
     */
    public AppleWatchNike(String color, double price, String modelName) {
        super(color, price, modelName); // Calls the constructor of the parent class (AppleWatch)
    }

    /**
     * Constructor for creating an AppleWatchNike object with additional health and running metrics.
     *
     * @param color          The color of the Apple Watch Nike.
     * @param price          The price of the Apple Watch Nike.
     * @param modelName      The model name of the Apple Watch Nike.
     * @param totalDistance  The total distance run (in kilometers).
     * @param avgHeartRate   The average heart rate during activities (in bpm).
     * @param avgSleepHours  The average sleep duration (in hours).
     */
    public AppleWatchNike(String color, double price, String modelName, double totalDistance, double avgHeartRate, double avgSleepHours) {
        super(color, price, modelName); // Calls the constructor of the parent class (AppleWatch)
        setTotalDistance(totalDistance); // Initializes the total distance
        setAvgHeartRate(avgHeartRate); // Initializes the average heart rate
        setAvgSleepHours(avgSleepHours); // Initializes the average sleep hours
    }

    // Getter and Setter methods for pace
    public double getPace() {
        return pace;
    }
    public void setPace(double pace) {
        this.pace = pace;
    }

    // Getter and Setter methods for time
    public double getTime() {
        return time;
    }
    public void setTime(double time) {
        this.time = time;
    }

    // Getter and Setter methods for average heart rate
    public double getAvgHeartRate() {
        return avgHeartRate;
    }
    public void setAvgHeartRate(double avgHeartRate) {
        this.avgHeartRate = avgHeartRate;
    }

    // Getter and Setter methods for maximum heart rate
    public double getMaxHeartRate() {
        return maxHeartRate;
    }
    public void setMaxHeartRate(double maxHeartRate) {
        this.maxHeartRate = maxHeartRate;
    }

    // Getter and Setter methods for average sleep hours
    public double getAvgSleepHours() {
        return avgSleepHours;
    }
    public void setAvgSleepHours(double avgSleepHours) {
        this.avgSleepHours = avgSleepHours;
    }

    // Getter and Setter methods for total distance
    public double getTotalDistance() {
        return totalDistance;
    }
    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    /**
     * Displays the total distance run by the user.
     */
    public void displayRunningStats() {
        System.out.println(String.format("Total distance run: %.2f km", getTotalDistance()));
    }

    /**
     * Displays the average heart rate of the user.
     */
    public void displayHeartRates() {
        System.out.println(String.format("Average heart rate: %d bpm", (int) getAvgHeartRate()));
    }

    /**
     * Displays the average sleep duration of the user.
     */
    public void displaySleepHours() {
        System.out.println(String.format("Average sleep duration: %.2f hours", getAvgSleepHours()));
    }

    /**
     * Overrides the toString method to provide a string representation
     * of the AppleWatchNike object, including its color, price, model name,
     * and total distance run.
     *
     * @return A string representation of the AppleWatchNike object.
     */
    @Override
    public String toString() {
        return "AppleWatchNike" +
            "(color: " + getColor() +
            " price:" + getPrice() +
            " model name:" + getModelName() +
            " GPS distance:" + getTotalDistance() +
            " km)";
    }
}