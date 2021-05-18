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
  private final GeneradorSugerencias generador;
  private final ServicioClima servicioClima;

  public Usuario(List<Prenda> guardarropas, List<Atuendo> sugerencias, List<Uniforme> sugerenciasUniformes,
                 GeneradorSugerencias generador, ServicioClima servicioClima) {
    this.guardarropas = guardarropas;
    this.sugerencias = sugerencias;
    this.sugerenciasUniformes = sugerenciasUniformes;
    this.generador = generador;
    this.servicioClima = servicioClima;
  }

  public Integer getTemperaturaCelciusActual(String ciudad) {
    return servicioClima.getTemperaturaCelciusActual(ciudad);
  }

  public void agregarSugerencia(Atuendo sugerencia) {
    sugerencias.add(sugerencia);
  }

  public void pedirSugerenciaSegunClimaActual(String ciudad) {
    agregarSugerencia(generador.generarSugerenciaSegunClimaActual(ciudad, guardarropas));
  }


  public void agregarSugerenciaUniforme(Uniforme sugerencia) {
    sugerenciasUniformes.add(sugerencia);
  }
}
