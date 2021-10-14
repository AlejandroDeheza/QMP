package dominio.usuario;

import com.google.common.collect.Sets;
import dominio.ropa.Atuendo;
import dominio.ropa.CategoriaPrenda;
import dominio.ropa.Prenda;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Guardarropa {

  private String criterioGuardarropa;
  private Set<Prenda> prendasSuperiores;
  private Set<Prenda> prendasInferiores;
  private Set<Prenda> calzados;
  private Set<Prenda> accesorios;

  public Guardarropa(String criterioGuardarropa, Set<Prenda> prendasSuperiores, Set<Prenda> prendasInferiores,
              Set<Prenda> calzados, Set<Prenda> accesorios) {
    this.criterioGuardarropa = criterioGuardarropa;
    this.prendasSuperiores = prendasSuperiores;
    this.prendasInferiores = prendasInferiores;
    this.calzados = calzados;
    this.accesorios = accesorios;
  }

  public void agregarPrenda(Prenda prenda) {
    if (prenda.getCategoria() == CategoriaPrenda.PARTE_SUPERIOR) prendasSuperiores.add(prenda);
    if (prenda.getCategoria() == CategoriaPrenda.PARTE_INFERIOR) prendasInferiores.add(prenda);
    if (prenda.getCategoria() == CategoriaPrenda.CALZADO) calzados.add(prenda);
    if (prenda.getCategoria() == CategoriaPrenda.ACCESORIO) accesorios.add(prenda);
  } // consultar y justificar, esto es valido?
  // segun lo que entendi de la clase 8, esto es valido porque aplicar polimorfismo sobre la "CategoriaPrenda"
  // para que se agregue a la lista correcta del guardarropas no tendria sentido,
  // la logica para eso la tiene que conocer el "Guardarropa", no la "CategoriaPrenda"

  public void quitarPrenda(Prenda prenda) {
    if (prenda.getCategoria() == CategoriaPrenda.PARTE_SUPERIOR) prendasSuperiores.remove(prenda);
    if (prenda.getCategoria() == CategoriaPrenda.PARTE_INFERIOR) prendasInferiores.remove(prenda);
    if (prenda.getCategoria() == CategoriaPrenda.CALZADO) calzados.remove(prenda);
    if (prenda.getCategoria() == CategoriaPrenda.ACCESORIO) accesorios.remove(prenda);
  }

  public List<Atuendo> generarSugerencias() {
    return Sets
        .cartesianProduct(prendasSuperiores, prendasInferiores, calzados, accesorios)
        .stream()
        .map((list) -> new Atuendo(list.get(0), list.get(1), list.get(2), list.get(3)))
        .collect(Collectors.toList());
  }

  public String getCriterioGuardarropa() {
    return criterioGuardarropa;
  }

}
