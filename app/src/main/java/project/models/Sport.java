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
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    // Metode abstrak untuk menghitung kalori yang dikeluarkan
    abstract double calculateCaloriesBurned();
}
