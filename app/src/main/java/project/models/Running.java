package project.models;

public class Running extends Sport {
    private double distance; // in kilometers
    private double caloriePerKm;

    public Running(String name, int duration, double distance) {
        super(name, duration);
        this.distance = distance;

        double speed ; // Speed in km/h
        if (distance >= 3 && distance <= 4) {
            speed = 15; // Light walking
        } else if (distance >= 5 && distance <= 6) {
            speed = 25; // Slow running
        } else if (distance >= 7 && distance <= 8) {
            speed = 40; // Moderate running
        } else if (distance >= 9 && distance <= 10) {
            speed = 50; // Fast running
        } else if (distance >= 11 && distance <= 12) {
            speed = 65; // Fast running
        } else if (distance > 12) {
            speed = 85; // Sprint
        } else {
            speed = 0; // No calorie data available
        }

        // Menghitung jumlah kalori per kilometer
        double durationHours = duration / 60.0; 
        caloriePerKm = speed * durationHours;
    }

    @Override
    public double calculateCaloriesBurned() {
        return distance * caloriePerKm * (getDuration() / 60.0); // Multiply by duration in hours
    }
}

