package dominio.usuario;

import java.util.ArrayList;
import java.util.List;

public class NotificadorTormenta implements InteresadoEnAlertas {

  private String ciudad;
  private List<Usuario> suscritos = new ArrayList<>();
  private String texto = "Hay alerta de tormenta, es recomendable llevar paraguas";

  public NotificadorTormenta(String ciudad) {
    this.ciudad = ciudad;
  }

  public void avisar(List<String> alertas, String ciudad) {
    if (alertas.contains("STORM") && this.ciudad.equals(ciudad)) {
      this.suscritos.forEach(
          usuario -> usuario.notificar(texto)
      );
    }
  }

  public void suscribirse(Usuario usuario) {
    this.suscritos.add(usuario);
  }

  public void desuscribirse(Usuario usuario) {
    this.suscritos.remove(usuario);
  }

}
