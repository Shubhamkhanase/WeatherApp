<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Weather Details</title>
</head>
<body>
    <h2>Weather Details for <%= request.getAttribute("weatherData").getLocation() %></h2>
    <p>Temperature: <%= request.getAttribute("weatherData").getTemperature() %> °
    </body>
    </html>