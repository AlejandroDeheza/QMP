package dominio.clima;

import dominio.usuario.RepositorioUsuarios;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AccuWeather implements ServicioMeteorologico {

  private AccuWeatherAPI apiClima;
  private RepositorioClima repositorioClima;
  private Long periodoDeActualizacion = 12L;
  private RepositorioUsuarios repoUsuarios;

  public AccuWeather(AccuWeatherAPI apiClima, RepositorioClima repositorioClima, RepositorioUsuarios repoUsuarios) {
    this.apiClima = apiClima;
    this.repositorioClima = repositorioClima;
    this.repoUsuarios = repoUsuarios;
  }

  @Override
  public EstadoDelClima obtenerCondicionesClimaticas(String ciudad) {
    validarUltimaConsulta(ciudad);
    return repositorioClima.getCondicionClimatica(ciudad);
  }

  @Override
  public void actualizarAlertasMeteorologicas(String ciudad) {
    Map<String, Object> alertas = apiClima.getAlertas(ciudad);
    List<AlertaMeteorologica> alertasAdaptadas = adaptarAlertas( (List<String>) alertas.get("CurrentAlerts") );
    if (!alertasAdaptadas.isEmpty()) {
      repoUsuarios.getUsuarios().forEach(usuario -> usuario.realizarAccionesSobreAlertas(alertasAdaptadas, ciudad));
      repositorioClima.setAlertasMeteorologicas(ciudad, alertasAdaptadas);
    }
  } // los empleados disparan el proceso desde aca

  private List<AlertaMeteorologica> adaptarAlertas(List<String> alertasActuales) {
    List<AlertaMeteorologica> alertasAdaptadas = new ArrayList<>();
    if (alertasActuales.contains("STORM")) alertasAdaptadas.add(AlertaMeteorologica.TORMENTA);
    if (alertasActuales.contains("HAIL")) alertasAdaptadas.add(AlertaMeteorologica.GRANIZO);
    return alertasAdaptadas;
  }

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
        BigDecimal.valueOf((int) clima.get("PrecipitationProbability")) ,
        pasarACelcius(( BigDecimal.valueOf(
            (int) ((HashMap<String, Object>) clima.get("Temperature")).get("Value")
        )))
        );
  }

  private BigDecimal pasarACelcius(BigDecimal fahrenheit) {
    return (fahrenheit.subtract(new BigDecimal(32))).multiply(new BigDecimal(5/9));
  }

}
