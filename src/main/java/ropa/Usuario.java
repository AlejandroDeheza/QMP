package ropa;

import java.util.List;

public class Usuario {

  private List<Prenda> guardarropas;
  private final List<Atuendo> sugerencias;
  private final List<Uniforme> sugerenciasUniformes;
  private GeneradorSugerencias generador;
  private ServicioClima servicioClima;

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

  public void agregarSugerencia(Atuendo sugerencia){
    sugerencias.add(sugerencia);
  }

  public void pedirSugerenciaSegunClimaActual(String ciudad) {
    agregarSugerencia(generador.generarSugerenciaSegunClimaActual(ciudad, guardarropas));
  }



  public void agregarSugerenciaUniforme(Uniforme sugerencia){
    sugerenciasUniformes.add(sugerencia);
  }
}
