package project.models;

public class Result2 {
    private String name;
    private String sport;
    private double duration;
    private double distance;
    private double calori;
    private double recommed;

    public Result2(String name, String sport, double duration, double distance, double calori, double recommed) {
        this.name = name;
        this.sport = sport;
        this.duration = duration;
        this.distance = distance;
        this.calori = calori;
        this.recommed = recommed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getCalori() {
        return calori;
    }

    public void setCalori(double calori) {
        this.calori = calori;
    }

    public double getRecommed() {
        return recommed;
    }

    public void setRecommedCalori(double recommed) {
        this.recommed = recommed;
    }
}
