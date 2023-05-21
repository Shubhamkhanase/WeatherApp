package controllers;

import models.WeatherData;
import services.WeatherService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class WeatherServlet extends HttpServlet {

    private WeatherService weatherService;

    @Override
    public void init() throws ServletException {
        super.init();
        weatherService = new WeatherService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String location = req.getParameter("location");
        WeatherData weatherData = weatherService.getCurrentWeather(location);
        req.setAttribute("weatherData", weatherData);
        req.getRequestDispatcher("/WEB-INF/views/weather.jsp").forward(req, resp);
    }
}