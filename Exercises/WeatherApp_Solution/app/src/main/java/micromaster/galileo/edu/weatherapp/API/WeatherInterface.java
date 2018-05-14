package micromaster.galileo.edu.weatherapp.API;

import micromaster.galileo.edu.weatherapp.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Byron on 3/18/2017.
 */

public interface WeatherInterface {

/*    @GET("weather?")
    Call<WeatherResponse> getWeatherFromZip(
            @Query("zip") String zip,
            @Query("APPID") String appId
    );*/


    @GET("{api_key}/conditions/q/CA/San_Francisco.json")
    Call<WeatherResponse> getWeatherFromSanFrancisco(
            @Path("api_key") String apiKey
    );

}
