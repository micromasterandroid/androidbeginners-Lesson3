package micromaster.galileo.edu.weatherapp.model;

public class Sys
{
    private int type;

    public int getType() { return this.type; }

    public void setType(int type) { this.type = type; }

    private int id;

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    private double message;

    public double getMessage() { return this.message; }

    public void setMessage(double message) { this.message = message; }

    private String country;

    public String getCountry() { return this.country; }

    public void setCountry(String country) { this.country = country; }

    private int sunrise;

    public int getSunrise() { return this.sunrise; }

    public void setSunrise(int sunrise) { this.sunrise = sunrise; }

    private int sunset;

    public int getSunset() { return this.sunset; }

    public void setSunset(int sunset) { this.sunset = sunset; }
}
