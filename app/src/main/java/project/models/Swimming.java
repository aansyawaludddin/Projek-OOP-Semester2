package project.models;

// Class Renang (inherit dari Sport)
public class Swimming extends Sport {
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
