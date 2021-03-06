package dominio.clima;

public interface ServicioMeteorologico {

  EstadoDelClima obtenerCondicionesClimaticas(String ciudad);

  void actualizarAlertasMeteorologicas(String ciudad);
}
