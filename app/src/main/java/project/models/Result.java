package project.models;

public class Result {
    private String name;
    private String sport;
    private double duration;
    private double distance;
    private double calori;

    public Result(String name, String sport, double duration, double distance, double calori ) {
        this.name = name;
        this.sport = sport;
        this.duration = duration;
        this.distance = distance;
        this.calori = calori;
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
}
