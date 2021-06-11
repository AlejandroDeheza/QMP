package dominio.usuario;

import java.util.List;

public interface ObserverClima {

  void actualizar(List<String> alertasActuales);

  void suscribirse(Usuario usuario);

  void desuscribirse(Usuario usuario);
}
