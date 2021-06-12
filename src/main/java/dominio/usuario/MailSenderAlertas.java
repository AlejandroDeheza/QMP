package dominio.usuario;

import java.util.ArrayList;
import java.util.List;

public class MailSenderAlertas implements InteresadoEnAlertas {

  private String ciudad;
  private List<Usuario> suscritos = new ArrayList<>();
  private String texto = "Se recibieron las siguientes alertas meteorologicas: ";

  public MailSenderAlertas(String ciudad) {
    this.ciudad = ciudad;
  }

  public void avisar(List<String> alertas, String ciudad) {
    if (this.ciudad.equals(ciudad)) {
      this.suscritos.forEach(
          usuario -> usuario.enviarMail(texto.concat(String.join(", ", alertas)))
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
