package project.models;
// Class Lari (inherit dari Sport)
public class Running extends Sport {
    private double distance; // dalam kilometer
    private double caloriePerKm;

    public Running(String name, int duration, double distance) {
        super(name, duration);
        this.distance = distance;
    }

    public void setCaloriePerKm() {
        double speed = distance / getDuration()/ 60; // Kecepatan dalam km/jam
        if (speed >= 3 && speed <= 4) {
            caloriePerKm = 30; // Jalan kaki ringan
        } else if (speed >= 5 && speed <= 6) {
            caloriePerKm = 50; // Lari pelan
        } else if (speed >= 7 && speed <= 8) {
            caloriePerKm = 80; // Lari sedang
        } else if (speed >= 9 && speed <= 10) {
            caloriePerKm = 100; // Lari cepat
        } else if (speed >= 11 && speed <= 12) {
            caloriePerKm = 130; // Lari cepat
        } else if (speed > 12) {
            caloriePerKm = 170; // Sprint
        } else {
            caloriePerKm = 0; // Tidak ada data kalori yang tersedia
        }
    }

    @Override
    public double calculateCaloriesBurned() {
        return distance * caloriePerKm;
    }
}
