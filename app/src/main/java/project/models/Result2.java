package project.models;

public class Result2 {
    private String name;
    private String sport;
    private double duration;
    private String style;
    private String intensity;
    private double calori;
    private double recommendCalori;

    public Result2(String name, String sport, double duration, String style, String intensity, double calori, double recommendCalori) {
        this.name = name;
        this.sport = sport;
        this.duration = duration;
        this.style = style;
        this.intensity = intensity;
        this.calori = calori;
        this.recommendCalori = recommendCalori;
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

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public double getCalori() {
        return calori;
    }

    public void setCalori(double calori) {
        this.calori = calori;
    }

    public double getRecommendCalori() {
        return recommendCalori;
    }

    public void setRecommendCalori(double recommendCalori) {
        this.recommendCalori = recommendCalori;
    }

}