package dominio.usuario;

import dominio.clima.AlertaMeteorologica;
import dominio.interesadoEnAlertas.AccionAnteAlertaMeteorologica;
import dominio.ropa.Atuendo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Usuario {
  private List<Guardarropa> guardarropas;
  private List<PropuestaGuardarropa> propuestasPendientes = new ArrayList<>();
  private List<PropuestaGuardarropa> propuestasAceptadas = new ArrayList<>();
  private AsesorDeImagen asesor;
  private String ciudad;
  private Atuendo sugerenciaDiaria;
  private List<AccionAnteAlertaMeteorologica> accionesSobreAlertas = new ArrayList<>();
  private String email;

  public Usuario(List<Guardarropa> guardarropas, AsesorDeImagen asesor, String ciudad, String email) {
    this.guardarropas = guardarropas;
    this.asesor = asesor;
    this.ciudad = ciudad;
    this.email = email;
  }

  public void agregarGuardarropa(Guardarropa guardarropa) {
    this.guardarropas.add(guardarropa);
  }

  public void removerGuardarropa(Guardarropa guardarropa) {
    this.guardarropas.remove(guardarropa);
  }

  public void agregarPropuesta(PropuestaGuardarropa propuesta) {
    propuestasPendientes.add(propuesta);
  }

  public void rechazarPropuesta(PropuestaGuardarropa propuesta) {
    propuestasPendientes.remove(propuesta);
  } // no valido que la "propuesta" este en "propuestas" -> confiar en el adentro
  // la "propuesta" seguramente se obtenga de un listado (en la UI) generado a partir de esta misma lista "propuestas"

  public void aceptarPropuesta(PropuestaGuardarropa propuesta) {
    propuesta.aplicar();
    this.propuestasPendientes.remove(propuesta);
    this.propuestasAceptadas.add(propuesta);
  }

  public void deshacerPropuesta(PropuestaGuardarropa propuesta) {
    propuesta.deshacer();
    this.propuestasAceptadas.remove(propuesta);
    this.propuestasPendientes.add(propuesta);
  }

  public void calcularSugerenciaDiaria() {
    Random aleatorio = new Random();
    this.sugerenciaDiaria = asesor.sugerirAtuendo( ciudad, guardarropas.get(aleatorio.nextInt(guardarropas.size())) );
  }

  public void suscribirAccionSobreAlertas(AccionAnteAlertaMeteorologica accion) {
    this.accionesSobreAlertas.add(accion);
  }

  public void desuscribirAccionSobreAlertas(AccionAnteAlertaMeteorologica accion) {
    this.accionesSobreAlertas.remove(accion);
  }

  public void realizarAccionesSobreAlertas(List<AlertaMeteorologica> alertas, String ciudad) {
    if (this.ciudad.equals(ciudad)) this.accionesSobreAlertas.forEach(
        accion -> accion.anteNuevasAlertasMeteorologicas(alertas, this)
    );
  }


  // GETTERS

  public List<PropuestaGuardarropa> getPropuestasPendientes() {
    return propuestasPendientes;
  }

  public List<PropuestaGuardarropa> getPropuestasAceptadas() {
    return propuestasAceptadas;
  }

  public Atuendo getSugerenciaDiaria() {
    return sugerenciaDiaria;
  }

  public String getEmail() {
    return email;
  }

}
