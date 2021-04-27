package ropa;

public class InstitutoJohnson extends Institucion{

  @Override
  public Uniforme crearUniforme() {

    Prenda prendaSuperior = this.generarPrenda(
        TipoPrenda.CAMISA, TipoMaterial.ALGODON, null, new Color(255, 255, 255), null);
    Prenda prendaInferior = this.generarPrenda(
        TipoPrenda.PANTALON, TipoMaterial.DE_VESTIR, null, new Color(0, 0, 0), null);
    Prenda calzado = this.generarPrenda(
        TipoPrenda.ZAPATOS, TipoMaterial.CUERO, null, new Color(0, 0, 0), null);

    return new Uniforme(prendaSuperior, prendaInferior, calzado);
  }
}
