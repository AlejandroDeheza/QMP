package dominio.ropa;

public enum TipoPrenda {

  CHOMBA(CategoriaPrenda.PARTE_SUPERIOR, 50),
  CAMISA(CategoriaPrenda.PARTE_SUPERIOR, 50),
  REMERA(CategoriaPrenda.PARTE_SUPERIOR, 50),
  BUZO(CategoriaPrenda.PARTE_SUPERIOR, 17),
  CAMPERA(CategoriaPrenda.PARTE_SUPERIOR, 15),
  LENTES(CategoriaPrenda.ACCESORIO, 50),
  ZAPATILLAS(CategoriaPrenda.CALZADO, 50),
  ZAPATOS(CategoriaPrenda.CALZADO, 50),
  BOTAS(CategoriaPrenda.CALZADO, 25),
  MEDIAS(CategoriaPrenda.PARTE_INFERIOR, 50),
  BERMUDA(CategoriaPrenda.PARTE_INFERIOR, 50),
  PANTALON(CategoriaPrenda.PARTE_INFERIOR, 37);

  private final CategoriaPrenda categoria;
  private final Integer temperaturaMaximaDeUso;

  TipoPrenda(CategoriaPrenda categoria, Integer temperaturaMaximaDeUso) {
    this.categoria = categoria;
    this.temperaturaMaximaDeUso = temperaturaMaximaDeUso;
  }

  public CategoriaPrenda getCategoria() {
    return this.categoria;
  }

  public Integer getTemperaturaMaximaDeUso() {
    return this.temperaturaMaximaDeUso;
  }

  public Boolean esAdecuadaPara(Integer temperaturaActual) {
    return this.temperaturaMaximaDeUso >= temperaturaActual;
  }
}
