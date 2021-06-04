package dominio.usuario;

import com.google.common.collect.Sets;
import dominio.ropa.Atuendo;
import dominio.ropa.Prenda;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Guardarropa {

  private Set<Prenda> prendasSuperiores;
  private Set<Prenda> prendasInferiores;
  private Set<Prenda> calzados;
  private Set<Prenda> accesorios;

  Guardarropa(Set<Prenda> prendasSuperiores, Set<Prenda> prendasInferiores, Set<Prenda> calzados,
              Set<Prenda> accesorios) {
    this.prendasSuperiores = prendasSuperiores;
    this.prendasInferiores = prendasInferiores;
    this.calzados = calzados;
    this.accesorios = accesorios;
  }

  public List<Atuendo> generarSugerencias() {
    return Sets
        .cartesianProduct(prendasSuperiores, prendasInferiores, calzados, accesorios)
        .stream()
        .map((list) -> new Atuendo(list.get(0), list.get(1), list.get(2), list.get(3)))
        .collect(Collectors.toList());
  }

}
