package micromaster.galileo.edu.weatherapp.API;

import micromaster.galileo.edu.weatherapp.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Byron on 3/18/2017.
 */

public interface WeatherInterface {

    @GET("weather?")
    Call<WeatherResponse> getWeatherFromCity(
            @Query("id") String id,
            @Query("APIKEY") String api_key,
            @Query("units") String units
    );

}
