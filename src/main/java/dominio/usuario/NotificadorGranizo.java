package dominio.usuario;

import java.util.ArrayList;
import java.util.List;

public class NotificadorGranizo implements ObserverClima{

  private List<Usuario> suscritos = new ArrayList<>();
  private String texto = "Hay alerta de granizo, evite salir en auto";

  public void actualizar(List<String> alertas) {
    if (alertas.contains("HAIL")) {
      this.suscritos.forEach(
          usuario -> usuario.notificar(texto));
    }
  }

  public void suscribirse(Usuario usuario) {
    this.suscritos.add(usuario);
  }

  public void desuscribirse(Usuario usuario) {
    this.suscritos.remove(usuario);
  }
}
