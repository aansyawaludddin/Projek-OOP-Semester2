package project.models;

// Class abstrak sport
abstract class Sport {
    private String name;
    private int duration; // dalam jam

    public Sport(String name ,int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration/60;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    // Metode abstrak untuk menghitung kalori yang dikeluarkan
    abstract double calculateCaloriesBurned();
}

// Class Lari (inherit dari Sport)
class Running extends Sport {
    private double distance; // dalam kilometer
    private double caloriePerKm;

    public Running(String name, int duration, double distance) {
        super(name, duration);
        this.distance = distance;
    }

    void setCaloriePerKm() {
        double speed = distance / getDuration(); // Kecepatan dalam km/jam
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


// Class Sepeda (inherit dari Sport)
class Cycling extends Sport {
    private double distance; // dalam kilometer
    private double caloriePerKm;

    public Cycling(String name, int duration, double distance) {
        super(name, duration );
        this.distance = distance;

        // Menghitung kalori per kilometer berdasarkan MET yang sesuai
        double met;
        if (distance >= 10 && distance <= 15) {
            met = 4.0; // MET untuk bersepeda santai (10-15 km/jam)
        } else if (distance >= 16 && distance <= 19) {
            met = 6.0; // MET untuk bersepeda sedang (16-19 km/jam)
        } else if (distance >= 20 && distance <= 25) {
            met = 8.0; // MET untuk bersepeda cepat (20-25 km/jam)
        } else if (distance > 25) {
            met = 10.0; // MET untuk bersepeda balap (lebih dari 25 km/jam)
        } else {
            met = 0.0; // Jika jarak tidak masuk dalam kategori yang ditentukan
        }

        // Menghitung jumlah kalori per kilometer
        caloriePerKm = met *duration;
    }

    @Override
    public double calculateCaloriesBurned() {
        return distance * caloriePerKm;
    }
}



// Class Renang (inherit dari Sport)
class Swimming extends Sport {
    private String style;
    private String intensity;

    public Swimming(String name, int duration, String style, String intensity) {
        super(name, duration);
        this.style = style;
        this.intensity = intensity;
    }

    @Override
    public double calculateCaloriesBurned() {
        double calories = 0.0;

        // Pengondisian berdasarkan gaya berenang dan intensitasnya
        if (style.equalsIgnoreCase("gaya bebas")) {
            if (intensity.equalsIgnoreCase("sedang")) {
                calories = 400.0;
            } else if (intensity.equalsIgnoreCase("tinggi")) {
                calories = 600.0;
            }
        } else if (style.equalsIgnoreCase("gaya dada")) {
            if (intensity.equalsIgnoreCase("sedang")) {
                calories = 350.0;
            } else if (intensity.equalsIgnoreCase("tinggi")) {
                calories = 550.0;
            }
        } else if (style.equalsIgnoreCase("gaya punggung")) {
            if (intensity.equalsIgnoreCase("sedang")) {
                calories = 250.0;
            } else if (intensity.equalsIgnoreCase("tinggi")) {
                calories = 400.0;
            }
        } else if (style.equalsIgnoreCase("gaya kupu-kupu")) {
            if (intensity.equalsIgnoreCase("sedang")) {
                calories = 600.0;
            } else if (intensity.equalsIgnoreCase("tinggi")) {
                calories = 750.0;
            }
        }

        return calories;
    }
}