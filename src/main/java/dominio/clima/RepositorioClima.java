package dominio.clima;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.temporal.ChronoUnit.HOURS;

public class RepositorioClima {

  private final Map<String, Object> condicionesClimaticas = new HashMap<>();
  private final Map<String, List<AlertaMeteorologica>> alertasMeteorologicas = new HashMap<>();

  public EstadoDelClima getCondicionClimatica(String ciudad) {
    return ((List<EstadoDelClima>) condicionesClimaticas.get(ciudad)).get(horarioAUtilizar(ciudad));
  }

  public List<AlertaMeteorologica> getAlertasMeteorologicas(String ciudad) {
    return (List<AlertaMeteorologica>) alertasMeteorologicas.get(ciudad);
  } // los usuarios pueden consultar de aca

  public void setAlertasMeteorologicas(String ciudad, List<AlertaMeteorologica> alertas) {
    this.alertasMeteorologicas.put(ciudad, alertas);
  }

  public void setCondicionesClimaticas(String ciudad, LocalDateTime ultimaActualizacion,
                                       List<EstadoDelClima> condicionesClimaticas) {
    this.condicionesClimaticas.put(ciudad, condicionesClimaticas);
    this.condicionesClimaticas.put(ciudad + "ultimaActualizacion", ultimaActualizacion);
  }

  public Boolean climaEstaDesactualizado(String ciudad, Long periodoDeActualizacion) {
    if (this.ultimaActualizacionDe(ciudad) == null) return true;
    return HOURS.between(LocalDateTime.now(), this.ultimaActualizacionDe(ciudad)) >= periodoDeActualizacion;
  }

  private int horarioAUtilizar(String ciudad) {
    return (int) Duration.between(LocalDateTime.now(), this.ultimaActualizacionDe(ciudad)).toHours();
  }

  private LocalDateTime ultimaActualizacionDe(String ciudad) {
    return (LocalDateTime) condicionesClimaticas.get(ciudad + "ultimaActualizacion");
  }


  //SINGLETON <--------------------------------
  private static RepositorioClima INSTANCE = new RepositorioClima();
  //usariamos el constructor solo para tests
  public RepositorioClima() {
  }
  //usariamos el getInstance en el codigo
  public static RepositorioClima getInstance() {
    return INSTANCE;
  }
}
