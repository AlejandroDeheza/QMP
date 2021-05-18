package dominio.uniforme;

import dominio.ropa.*;

public class InstitutoJohnson extends Institucion{

  protected Prenda generarParteSuperior(){
    BorradorDePrendas borradorDePrendas = new BorradorDePrendas(TipoPrenda.CAMISA)
        .setTipoMaterial(TipoMaterial.ALGODON)
        .setColorPrincipal(new Color(255, 255, 255));
    return borradorDePrendas.generarPrenda();
  }

  protected Prenda generarParteInferior(){
    BorradorDePrendas borradorDePrendas = new BorradorDePrendas(TipoPrenda.PANTALON)
        .setTipoMaterial(TipoMaterial.DE_VESTIR)
        .setColorPrincipal(new Color(0, 0, 0));
    return borradorDePrendas.generarPrenda();
  }

  protected Prenda generarCalzado(){
    BorradorDePrendas borradorDePrendas = new BorradorDePrendas(TipoPrenda.ZAPATOS)
        .setTipoMaterial(TipoMaterial.CUERO)
        .setColorPrincipal(new Color(0, 0, 0));
    return borradorDePrendas.generarPrenda();
  }

}
