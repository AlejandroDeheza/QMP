package dominio.ropa;

import java.util.List;

public class Atuendo {

  private final List<Prenda> prendaSuperiores;
  private final List<Prenda> prendaInferiores;
  private final List<Prenda> calzados;
  private final List<Prenda> accesorios;

  public Atuendo(List<Prenda> prendaSuperiores, List<Prenda> prendaInferiores, List<Prenda> calzados,
                 List<Prenda> accesorios) {
    this.prendaSuperiores = prendaSuperiores;
    this.prendaInferiores = prendaInferiores;
    this.calzados = calzados;
    this.accesorios = accesorios;
  }

  public List<Prenda> getPrendaSuperiores() {
    return prendaSuperiores;
  }

  public List<Prenda> getPrendaInferiores() {
    return prendaInferiores;
  }

  public List<Prenda> getCalzados() {
    return calzados;
  }

  public List<Prenda> getAccesorios() {
    return accesorios;
  }

}
