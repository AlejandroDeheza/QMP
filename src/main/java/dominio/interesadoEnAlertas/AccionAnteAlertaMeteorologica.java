package dominio.interesadoEnAlertas;

import dominio.clima.AlertaMeteorologica;
import dominio.usuario.Usuario;

import java.util.List;

public interface AccionAnteAlertaMeteorologica {

  void anteNuevasAlertasMeteorologicas(List<AlertaMeteorologica> alertasActuales, Usuario usuario);
}
