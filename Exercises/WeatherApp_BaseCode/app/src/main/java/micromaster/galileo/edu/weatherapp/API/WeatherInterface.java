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

    /*This function queries the weather, the first parameter 'id' is the ID from the city
    * the second query will be our API KEY
    * and finally the third one is the units in which the response will be
    *   blank is kelvin, metric is celsius, and imperial is fahrenheit*/
    @GET("weather?")
    Call<WeatherResponse> getWeatherFromCity(
            @Query("id") String id,
            @Query("APIKEY") String api_key,
            @Query("units") String units
    );

}
