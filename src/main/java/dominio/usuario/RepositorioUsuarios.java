package dominio.usuario;

import java.util.List;
import java.util.Random;

public class RepositorioUsuarios {

  private List<Usuario> usuarios;

  public void calcularSugerenciasDiarias(String ciudad, AsesorDeImagen asesor) {
    Random aleatorio = new Random();
    usuarios.forEach(
      usuario -> usuario.agregarSugerencia(
          asesor.sugerirAtuendo(
              ciudad,
              usuario.getGuardarropas().get(aleatorio.nextInt(usuario.getGuardarropas().size()))
          )
      )
    );
  }

  //SINGLETON <--------------------------------
  private static RepositorioUsuarios INSTANCE = new RepositorioUsuarios();
  //usariamos el constructor solo para tests
  public RepositorioUsuarios() {
  }
  //usariamos el getInstance en el codigo
  public static RepositorioUsuarios getInstance() {
    return INSTANCE;
  }

}
