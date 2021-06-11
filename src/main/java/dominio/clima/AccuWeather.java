package dominio.clima;

import dominio.usuario.AsesorDeImagen;
import dominio.usuario.ObserverClima;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AccuWeather implements ServicioMeteorologico {

  private AccuWeatherAPI apiClima;
  private RepositorioClima repositorioClima;
  private Long periodoDeActualizacion = 12L;
  private List<ObserverClima> observersClima;

  public AccuWeather(AccuWeatherAPI apiClima, RepositorioClima repositorioClima) {
    this.apiClima = apiClima;
    this.repositorioClima = repositorioClima;
  }

  @Override
  public EstadoDelClima obtenerCondicionesClimaticas(String ciudad) {
    validarUltimaConsulta(ciudad);
    return repositorioClima.getCondicionClimatica(ciudad);
  }

  @Override
  public void actualizarAlertasMeteorologicas(String ciudad, AsesorDeImagen asesor) {
    Map<String, Object> alertas = apiClima.getAlertas(ciudad);
    List<String> alertasActuales = (List<String>) alertas.get("CurrentAlerts");
    //Devuelve un objeto como [“STORM”, “HAIL”, ...]
    if (!alertasActuales.isEmpty()) this.observersClima.forEach(o -> o.actualizar(alertasActuales));
    this.repositorioClima.setAlertasMeteorologicas(ciudad, alertasActuales);
  } // los empleados disparan el proceso desde aca

  private void validarUltimaConsulta(String ciudad) {
    if (repositorioClima.climaEstaDesactualizado(ciudad, periodoDeActualizacion)) {
      repositorioClima.setCondicionesClimaticas(
          ciudad,
          LocalDateTime.now(),
          consultarApi(ciudad)
      );
    }
  }

  //devuelve una lista con 12 elementos, uno por cada hora (AccuWeatherAPI devuelve el pronostico de 12 horas)
  private List<EstadoDelClima> consultarApi(String ciudad) {
    return apiClima
        .getWeather(ciudad)
        .stream()
        .map(this::generarEstadoDelClima)
        .collect(Collectors.toList());
  }

  private EstadoDelClima generarEstadoDelClima(Map<String, Object> clima) {
    return new EstadoDelClima(
        (BigDecimal) clima.get("PrecipitationProbability"),
        pasarACelcius((BigDecimal) ((HashMap<String, Object>) clima.get("Temperature")).get("Value"))
        );
  }

  private BigDecimal pasarACelcius(BigDecimal fahrenheit) {
    return (fahrenheit.subtract(new BigDecimal(32))).multiply(new BigDecimal(5/9));
  }

}
