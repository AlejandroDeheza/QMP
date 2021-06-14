package dominio.interesadoEnAlertas;

import dominio.clima.AlertaMeteorologica;
import dominio.usuario.Usuario;

import java.util.List;

public class ActualizadorSugerenciasAnteAlerta implements AccionAnteAlertaMeteorologica {

  @Override
  public void anteNuevasAlertasMeteorologicas(List<AlertaMeteorologica> alertasActuales, Usuario usuario) {
    usuario.calcularSugerenciaDiaria();
  }
}
