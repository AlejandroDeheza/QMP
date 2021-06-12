package dominio.clima;

import dominio.usuario.AsesorDeImagen;

public interface ServicioMeteorologico {

  EstadoDelClima obtenerCondicionesClimaticas(String ciudad);

  void actualizarAlertasMeteorologicas(String ciudad);
}
