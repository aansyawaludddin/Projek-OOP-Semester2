package project.models;

// Class Sepeda (inherit dari Sport)
public class Cycling extends Sport {
    private double distance; // dalam kilometer
    private double caloriePerKm;

    public Cycling(String name, int duration, double distance) {
        super(name, duration);
        this.distance = distance;

        // Menghitung kalori per kilometer berdasarkan MET yang sesuai
        double met;
        if (distance >= 10 && distance <= 15) {
            met = 12.0; // MET untuk bersepeda santai (10-15 km/jam)
        } else if (distance >= 16 && distance <= 19) {
            met = 18.0; // MET untuk bersepeda sedang (16-19 km/jam)
        } else if (distance >= 20 && distance <= 25) {
            met = 24.0; // MET untuk bersepeda cepat (20-25 km/jam)
        } else if (distance > 25) {
            met = 30.0; // MET untuk bersepeda balap (lebih dari 25 km/jam)
        } else {
            met = 0.0; // Jika jarak tidak masuk dalam kategori yang ditentukan
        }

        // Menghitung jumlah kalori per kilometer
        double durationHours = duration / 60.0; 
        caloriePerKm = met * durationHours;
    }

    @Override
    public double calculateCaloriesBurned() {
        return distance * caloriePerKm;
    }
}
