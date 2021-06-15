package dominio.interesadoEnAlertas;

import dominio.clima.AlertaMeteorologica;
import dominio.usuario.Usuario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificadorAnteAlertas implements AccionAnteAlertaMeteorologica {

  private Notificador notificador;
  private Map<AlertaMeteorologica, String> mensaje = new HashMap<AlertaMeteorologica, String>() {{
    put(AlertaMeteorologica.TORMENTA, "Hay alerta de tormenta, es recomendable llevar paraguas");
    put(AlertaMeteorologica.GRANIZO, "Hay alerta de granizo, evite salir en auto");
  }}; // un "if" tambien hubiera estado bien

  public NotificadorAnteAlertas(Notificador notificador) {
    this.notificador = notificador;
  }

  @Override
  public void anteNuevasAlertasMeteorologicas(List<AlertaMeteorologica> alertas, Usuario usuario) {
    alertas.forEach(alerta -> notificador.mostrarNotificacion(mensaje.get(alerta)));
    // como hago para los usuarios que estan interesados solo en Tormentas o solo en Granizo ?
    // podria separar esta clase en 2 acciones, una para Tormentas y otra para Granizo
  }

}
