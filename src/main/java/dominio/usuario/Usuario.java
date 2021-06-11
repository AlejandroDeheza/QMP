package dominio.usuario;

import dominio.ropa.Atuendo;

import java.util.List;

public class Usuario {
  private List<Guardarropa> guardarropas;
  private List<PropuestaGuardarropa> propuestasPendientes;
  private List<PropuestaGuardarropa> propuestasAceptadas;
  private List<Atuendo> sugerencias;

  public Usuario(List<Guardarropa> guardarropas, List<PropuestaGuardarropa> propuestasPendientes,
                 List<PropuestaGuardarropa> propuestasAceptadas, List<Atuendo> sugerencias) {
    this.guardarropas = guardarropas;
    this.propuestasPendientes = propuestasPendientes;
    this.propuestasAceptadas = propuestasAceptadas;
    this.sugerencias = sugerencias;
  }

  public void agregarSugerencia(Atuendo sugerencia) {
    sugerencias.add(sugerencia);  // de qmp anteriores
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


  // GETTERS

  public List<PropuestaGuardarropa> getPropuestasPendientes() {
    return propuestasPendientes;
  }

  public List<PropuestaGuardarropa> getPropuestasAceptadas() {
    return propuestasAceptadas;
  }

}
