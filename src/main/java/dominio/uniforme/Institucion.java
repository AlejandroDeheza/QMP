package dominio.uniforme;

import dominio.ropa.Prenda;

public abstract class Institucion {

  public Uniforme crearUniforme() {
    return new Uniforme(this.generarParteSuperior(), this.generarParteInferior(), this.generarCalzado());
  }

  protected abstract Prenda generarParteSuperior();
  protected abstract Prenda generarParteInferior();
  protected abstract Prenda generarCalzado();

}
