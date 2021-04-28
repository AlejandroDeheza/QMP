package ropa;

public class ColegioSanJuan extends Institucion{

  @Override
  public Uniforme crearUniforme() {

    Prenda prendaSuperior = this.generarPrenda(
        TipoPrenda.CHOMBA, TipoMaterial.PIQUE, null, new Color(0, 255, 0), null);
    Prenda prendaInferior = this.generarPrenda(
        TipoPrenda.PANTALON, TipoMaterial.ACETATO, null, new Color(150, 152, 154), null);
    Prenda calzado = this.generarPrenda(
        TipoPrenda.ZAPATILLAS, TipoMaterial.POLIESTER, null, new Color(255, 255, 255), null);

    return new Uniforme(prendaSuperior, prendaInferior, calzado);
  }
}
