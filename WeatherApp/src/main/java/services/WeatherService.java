package services;

import constants.APIConstants;
import dao.WeatherDataDAO;
import models.WeatherData;
import utils.DatabaseUtil;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherService {

    private WeatherDataDAO weatherDataDAO;

    public WeatherService() {
        weatherDataDAO = new WeatherDataDAOImpl(DatabaseUtil.getConnection();
    }

    public WeatherData getCurrentWeather(String location) {
        WeatherData weatherData = null;
        try {
            URL url = new URL(APIConstants.OPENWEATHERMAP_API_URL + "?q=" + location + "&appid=" + APIConstants.OPENWEATHERMAP_API_KEY);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                JSONObject jsonResponse = new JSONObject(response.toString());
                // Parse the JSON response to extract the required weather data
                String temperature = jsonResponse.getJSONObject("main").getString("temp");

                weatherData = new WeatherData();
                weatherData.setLocation(location);
                weatherData.setTemperature(temperature);

                weatherDataDAO.saveWeatherData(weatherData);
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return weatherData;
    }
}