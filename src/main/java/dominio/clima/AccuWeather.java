package dominio.clima;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.HOURS;

public class AccuWeather implements ServicioClima {

  private List<Map<String, Object>> condicionesClimaticas;
  LocalDateTime ultimaConsultaDelCLima = LocalDateTime.now().minus(DAYS.getDuration());


  private static AccuWeather INSTANCE;

  //usariamos el constructor solo para tests
  public AccuWeather() { }

  //usariamos el getInstance en el codigo
  public static AccuWeather getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new AccuWeather();
    }
    return INSTANCE;
  }

  @Override
  public Integer getProbabilidadDePrecipitacionesActual(String ciudad) {
    validarUltimaConsulta(ciudad); //logica repetida, no creo que valga la pena arreglarlo
    return (Integer) condicionesClimaticas.get(0).get("PrecipitationProbability"); //Devuelve un número del 0 al 1
  }

  @Override
  public Integer getTemperaturaCelciusActual(String ciudad) {
    validarUltimaConsulta(ciudad); //logica repetida, no creo que valga la pena arreglarlo
    return pasarACelcius(
        (Integer) ((HashMap<String, Object>) condicionesClimaticas.get(0).get("Temperature")).get("Value"));
  }

  private void validarUltimaConsulta(String ciudad) {
    if (seConsultoClimaHaceMasDe(12L)) {
      AccuWeatherAPI apiClima = new AccuWeatherAPI();
      condicionesClimaticas = apiClima.getWeather(ciudad);
      ultimaConsultaDelCLima = LocalDateTime.now();
    }
  }

  private Boolean seConsultoClimaHaceMasDe(Long periodo) {
    return HOURS.between(LocalDateTime.now(), ultimaConsultaDelCLima) >= periodo;
  }

  private Integer pasarACelcius(Integer fahrenheit) {
    return 33;  //TODO
  }

}
