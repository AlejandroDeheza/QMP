package dominio.usuario;

import java.util.List;

public interface InteresadoEnAlertas {

  void avisar(List<String> alertasActuales, String ciudad);

  void suscribirse(Usuario usuario);

  void desuscribirse(Usuario usuario);
}
