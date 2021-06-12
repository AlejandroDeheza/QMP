package dominio.usuario;

import java.util.ArrayList;
import java.util.List;

public class NotificadorGranizo implements InteresadoEnAlertas {

  private String ciudad;
  private List<Usuario> suscritos = new ArrayList<>();
  private String texto = "Hay alerta de granizo, evite salir en auto";

  public NotificadorGranizo(String ciudad) {
    this.ciudad = ciudad;
  }

  public void avisar(List<String> alertas, String ciudad) {
    if (alertas.contains("HAIL") && this.ciudad.equals(ciudad)) {
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
