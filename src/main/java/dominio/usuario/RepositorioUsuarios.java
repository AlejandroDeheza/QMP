package dominio.usuario;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuarios {

  private List<Usuario> usuarios = new ArrayList<>();

  public void calcularSugerenciasDiarias() {
    usuarios.forEach(Usuario::calcularSugerenciaDiaria);
  }

  public void agregarUsuario(Usuario usuario) {
    usuarios.add(usuario);
  }

  public List<Usuario> getUsuarios() {
    return usuarios;
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
