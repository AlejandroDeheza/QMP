package ropa;

import java.util.List;
import java.util.Map;

public interface IAccuWeatherAPI {

  List<Map<String, Object>> getWeather(String ciudad);
}
