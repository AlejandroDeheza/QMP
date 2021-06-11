package dominio.usuario;

import java.util.ArrayList;
import java.util.List;

public class MailSenderAlertas implements ObserverClima{

  private List<Usuario> suscritos = new ArrayList<>();
  private String texto = "Se recibieron las siguientes alertas meteorologicas: ";

  public void actualizar(List<String> alertas) {
    this.suscritos.forEach(
        usuario -> usuario.enviarMail(texto.concat(alertas)));
  }

  public void suscribirse(Usuario usuario) {
    this.suscritos.add(usuario);
  }

  public void desuscribirse(Usuario usuario) {
    this.suscritos.remove(usuario);
  }
}
