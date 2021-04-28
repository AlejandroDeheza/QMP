package ropa;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

  private List<Uniforme> sugerencias = new ArrayList<>();

  public void agregarSugerencia(Uniforme sugerencia){
    sugerencias.add(sugerencia);
  }
}
