package ropa;

import java.util.List;

public class Usuario {

  private List<Uniforme> sugerencias;

  public void agregarSugerencia(Uniforme sugerencia){
    sugerencias.add(sugerencia);
  }
}
