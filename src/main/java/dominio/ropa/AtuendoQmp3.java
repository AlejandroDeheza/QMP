package dominio.ropa;

import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Atuendo {

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
}

class Guardarropa {

  private Set<Prenda> prendasSuperiores;
  private Set<Prenda> prendasInferiores;
  private Set<Prenda> calzados;
  private Set<Prenda> accesorios;

  public List<Atuendo> generarSugerencia() {
    return Sets
        .cartesianProduct(prendasSuperiores, prendasInferiores, calzados, accesorios)
        .stream()
        .map((list) -> new Atuendo(list.get(0), list.get(1), list.get(2), list.get(3)))
        .collect(Collectors.toList());
  }
}


