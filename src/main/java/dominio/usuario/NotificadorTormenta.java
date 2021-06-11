package dominio.usuario;

import java.util.ArrayList;
import java.util.List;

public class NotificadorTormenta implements ObserverClima{

  private List<Usuario> suscritos = new ArrayList<>();
  private String texto = "Hay alerta de tormenta, es recomendable llevar paraguas";

  public void actualizar(List<String> alertas) {
    if (alertas.contains("STORM")) {
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
