package dominio.usuario;

import dominio.ropa.Atuendo;

import java.util.List;

public class Usuario {
  private final Guardarropa guardarropa;
  private final List<Atuendo> sugerencias;

  public Usuario(Guardarropa guardarropa, List<Atuendo> sugerencias) {
    this.guardarropa = guardarropa;
    this.sugerencias = sugerencias;
  }

  public void agregarSugerencia(Atuendo sugerencia) {
    sugerencias.add(sugerencia);
  }

}
