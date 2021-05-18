package dominio.usuario;

import dominio.clima.ServicioClima;
import dominio.ropa.Atuendo;
import dominio.ropa.Prenda;
import dominio.uniforme.Uniforme;

import java.util.List;

public class Usuario {

  private final List<Prenda> guardarropas;
  private final List<Atuendo> sugerencias;
  private final List<Uniforme> sugerenciasUniformes;
  private final GeneradorSugerencias generadorSugerencias;
  private final ServicioClima servicioClima;

  public Usuario(List<Prenda> guardarropas, List<Atuendo> sugerencias, List<Uniforme> sugerenciasUniformes,
                 GeneradorSugerencias generadorSugerencias, ServicioClima servicioClima) {
    this.guardarropas = guardarropas;
    this.sugerencias = sugerencias;
    this.sugerenciasUniformes = sugerenciasUniformes;
    this.generadorSugerencias = generadorSugerencias;
    this.servicioClima = servicioClima;
  }

  public Integer getTemperaturaCelciusActual(String ciudad) {
    return servicioClima.getTemperaturaCelciusActual(ciudad);
  }

  public void agregarSugerencia(Atuendo sugerencia) {
    sugerencias.add(sugerencia);
  }

  public void pedirSugerenciaSegunClimaActual(String ciudad) {
    agregarSugerencia(generadorSugerencias.generarSugerenciaSegunClimaActual(ciudad, guardarropas));
  }


  public void agregarSugerenciaUniforme(Uniforme sugerencia) {
    sugerenciasUniformes.add(sugerencia);
  }
}
