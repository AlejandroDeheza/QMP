package dominio.interesadoEnAlertas;

import dominio.clima.AlertaMeteorologica;
import dominio.usuario.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class EmisorDeCorreoAnteAlertas implements AccionAnteAlertaMeteorologica {

  private Correo correo;
  private String texto = "Se recibieron las siguientes alertas meteorologicas: ";

  public EmisorDeCorreoAnteAlertas(Correo correo) {
    this.correo = correo;
  }

  @Override
  public void anteNuevasAlertasMeteorologicas(List<AlertaMeteorologica> alertas, Usuario usuario) {
    List<String> nombresAlertas = alertas.stream().map(Enum::toString).collect(Collectors.toList());
    correo.enviarCorreo(usuario.getEmail(), texto.concat(String.join(", ", nombresAlertas)));
  }
}
