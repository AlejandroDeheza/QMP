package dominio.usuario;

import dominio.ropa.Prenda;

public class AgregarPrenda implements PropuestaGuardarropa{

  private Guardarropa guardarropa;
  private Prenda prenda;

  public AgregarPrenda(Guardarropa guardarropa, Prenda prenda) {
    this.guardarropa = guardarropa;
    this.prenda = prenda;
  }

  @Override
  public void aplicar() {
    guardarropa.agregarPrenda(prenda);
  }

  @Override
  public void deshacer() {
    guardarropa.quitarPrenda(prenda);
  }
}
