package com.vollphil.WeatherAppBackend;

public class WeatherData {
    private String condition;
    private double temperature;

    public WeatherData(String condition, double temperature) {
        this.condition = condition;
        this.temperature = temperature;
    }

    public WeatherData() {
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

}
