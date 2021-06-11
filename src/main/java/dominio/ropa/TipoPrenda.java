package dominio.ropa;

public enum TipoPrenda {

  CHOMBA(CategoriaPrenda.PARTE_SUPERIOR),
  CAMISA(CategoriaPrenda.PARTE_SUPERIOR),
  REMERA(CategoriaPrenda.PARTE_SUPERIOR),
  BUZO(CategoriaPrenda.PARTE_SUPERIOR),
  CAMPERA(CategoriaPrenda.PARTE_SUPERIOR),
  LENTES(CategoriaPrenda.ACCESORIO),
  ZAPATILLAS(CategoriaPrenda.CALZADO),
  ZAPATOS(CategoriaPrenda.CALZADO),
  BOTAS(CategoriaPrenda.CALZADO),
  MEDIAS(CategoriaPrenda.PARTE_INFERIOR),
  BERMUDA(CategoriaPrenda.PARTE_INFERIOR),
  PANTALON(CategoriaPrenda.PARTE_INFERIOR);

  private final CategoriaPrenda categoria;

  TipoPrenda(CategoriaPrenda categoria) {
    this.categoria = categoria;
  }

  public CategoriaPrenda getCategoria() {
    return this.categoria;
  }

}
