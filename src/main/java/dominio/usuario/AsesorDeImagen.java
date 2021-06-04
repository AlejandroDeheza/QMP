package dominio.usuario;

import dominio.clima.ServicioMeteorologico;
import dominio.ropa.Atuendo;

import java.math.BigDecimal;
import java.util.stream.Collectors;

public class AsesorDeImagen {

  private ServicioMeteorologico servicioMeteorologico;

  public AsesorDeImagen(ServicioMeteorologico servicioMeteorologico) {
    this.servicioMeteorologico = servicioMeteorologico;
  }

  public Atuendo sugerirAtuendo(String ciudad, Guardarropa guardarropa) {
    BigDecimal temperaturaActual = servicioMeteorologico.obtenerCondicionesClimaticas(ciudad).getTemperatura();
    return guardarropa.generarSugerencias().stream()
        .filter(atuendo -> atuendo.esAdecuadoPara(temperaturaActual))
        .collect(Collectors.toList())
        .get(0);
  }
}
