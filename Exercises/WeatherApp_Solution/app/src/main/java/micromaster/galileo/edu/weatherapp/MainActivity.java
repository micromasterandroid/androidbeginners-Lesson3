package micromaster.galileo.edu.weatherapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import micromaster.galileo.edu.weatherapp.API.WeatherInterface;
import micromaster.galileo.edu.weatherapp.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

	/*these constants are used for the network call
    * BASE_URL gives the URL we want to query
    * API_KEY is out unique key we use to query the API
    * CITY_ID is the id of the city we want to query
    * RESPONSE_UNITS change the units of the temperature, blank is kelvin, metric is celsius and imperial is fahrenheit*/
    private final static String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private final static String API_KEY = "PASTE_YOUR_API_KEY_HERE";
    private final static String CITY_ID = "1689973";
    private final static String RESPONSE_UNITS = "metric";

    private TextView countryNameTextView;
    private TextView temperatureTextView;
    private TextView pressureTextView;
    private TextView humidityTextView;
    private TextView weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryNameTextView = findViewById(R.id.countryName);
        temperatureTextView = findViewById(R.id.temperature);
        pressureTextView = findViewById(R.id.pressure);
        humidityTextView = findViewById(R.id.humidity);
        weather = findViewById(R.id.weather);

        //Execute AsyncTask
        new GetWeatherInformation().execute();

    }

private class GetWeatherInformation extends AsyncTask<Void,Void, WeatherResponse>{

    @Override
    protected WeatherResponse doInBackground(Void... voids) {
		/*Retrofit helps us handle the HttpRequests, network calls, etc.
        * Here we give the library the URL which we will query
        * and also a converter, so it'll know what type of response to expect
        * in this case the API will return a JSON object*/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherInterface weatherInterface = retrofit.create(WeatherInterface.class);
        Call<WeatherResponse> call = weatherInterface.getWeatherFromCity(CITY_ID,API_KEY,RESPONSE_UNITS);
		/*The call to the Retrofit Interface will return a WeatherResponse object, for which
        * we have created a Object, so the library can convert the response from JSON, to an object
        * we can manipulate*/
        WeatherResponse weatherResponse = null;
        try {
            weatherResponse = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherResponse;
    }

    @Override
    protected void onPostExecute(WeatherResponse weatherResponse) {
        super.onPreExecute();
        if (weatherResponse != null) {
            countryNameTextView.setText(weatherResponse.getName());
            temperatureTextView.setText(String.valueOf(weatherResponse.getMain().getTemp()));
            pressureTextView.setText(String.valueOf(weatherResponse.getMain().getPressure()));
            humidityTextView.setText(String.valueOf(weatherResponse.getMain().getHumidity()));
            weather.setText(weatherResponse.getWeather().get(0).getDescription());
        }
    }
}
}
