package dominio.usuario;

import dominio.ropa.Prenda;

public class QuitarPrenda implements PropuestaGuardarropa{

  private Guardarropa guardarropa;
  private Prenda prenda;

  public QuitarPrenda(Guardarropa guardarropa, Prenda prenda) {
    this.guardarropa = guardarropa;
    this.prenda = prenda;
  }

  @Override
  public void aplicar() {
    guardarropa.quitarPrenda(prenda);
  }

  @Override
  public void deshacer() {
    guardarropa.agregarPrenda(prenda);
  }
}
