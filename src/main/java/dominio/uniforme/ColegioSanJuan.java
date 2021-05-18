package dominio.uniforme;

import dominio.ropa.BorradorDePrendas;
import dominio.ropa.*;

public class ColegioSanJuan extends Institucion {

  protected Prenda generarParteSuperior() {
    BorradorDePrendas borradorDePrendas = new BorradorDePrendas(TipoPrenda.CHOMBA)
        .setTipoMaterial(TipoMaterial.PIQUE)
        .setColorPrincipal(new Color(0, 255, 0));
    return borradorDePrendas.generarPrenda();
  }

  protected Prenda generarParteInferior() {
    BorradorDePrendas borradorDePrendas = new BorradorDePrendas(TipoPrenda.PANTALON)
        .setTipoMaterial(TipoMaterial.ACETATO)
        .setColorPrincipal(new Color(150, 152, 154));
    return borradorDePrendas.generarPrenda();
  }

  protected Prenda generarCalzado() {
    BorradorDePrendas borradorDePrendas = new BorradorDePrendas(TipoPrenda.ZAPATILLAS)
        .setTipoMaterial(TipoMaterial.POLIESTER)
        .setColorPrincipal(new Color(255, 255, 255));
    return borradorDePrendas.generarPrenda();
  }

}
