package dominio.ropa;

import java.math.BigDecimal;

public class Atuendo {

  private Prenda prendaSuperior;
  private Prenda prendaInferior;
  private Prenda calzado;
  private Prenda accesorio;

  public Atuendo(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado, Prenda accesorio) {
    this.prendaSuperior = prendaSuperior;
    this.prendaInferior = prendaInferior;
    this.calzado = calzado;
    this.accesorio = accesorio;
  }

  public Boolean esAdecuadoPara(BigDecimal temperaturaActual) {
    return this.prendaSuperior.esAdecuadaPara(temperaturaActual) &&
        this.prendaInferior.esAdecuadaPara(temperaturaActual) &&
        this.calzado.esAdecuadaPara(temperaturaActual) &&
        this.accesorio.esAdecuadaPara(temperaturaActual);
  }

  public Prenda getPrendaSuperiores() {
    return prendaSuperior;
  }

  public Prenda getPrendaInferiores() {
    return prendaInferior;
  }

  public Prenda getCalzados() {
    return calzado;
  }

  public Prenda getAccesorios() {
    return accesorio;
  }

}
