package micromaster.galileo.edu.weatherapp.model;

public class Weather {
    private int id;

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    private String main;

    public String getMain() { return this.main; }

    public void setMain(String main) { this.main = main; }

    private String description;

    public String getDescription() { return this.description; }

    public void setDescription(String description) { this.description = description; }

    private String icon;

    public String getIcon() { return this.icon; }

    public void setIcon(String icon) { this.icon = icon; }
}
