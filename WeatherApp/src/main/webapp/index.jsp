<!DOCTYPE html>
<html>
<head>
    <title>Weather App</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h1>Welcome to the Weather App</h1>
    <form action="weather" method="get">
        <label for="location">Enter Location:</label>
        <input type="text" id="location" name="location" required>
        <button type="submit">Get Weather</button>
    </form>
    <script src="js/app.js"></script>
</body>
</html>