package dominio.ropa;

public class Prenda {

  private final TipoPrenda tipo;
  private final TipoMaterial tipoMaterial;
  private final Trama trama;
  private final Color colorPrincipal;
  private final Color colorSecundario;

  public Prenda(TipoPrenda tipo, TipoMaterial tipoMaterial, Trama trama, Color colorPrincipal, Color colorSecundario) {
    this.tipo = tipo;
    this.tipoMaterial = tipoMaterial;
    this.trama = trama;
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
  }

  public Boolean esAdecuadaPara(Integer temperatura) {
    return getTipo().esAdecuadaPara(temperatura);
  }

  //GETTERS
  public TipoPrenda getTipo() {
    return tipo;
  }

  public CategoriaPrenda getCategoria() {
    return tipo.getCategoria();
  }

  public TipoMaterial getTipoMaterial() {
    return tipoMaterial;
  }

  public Trama getTrama() {
    return trama;
  }

  public Color getColorPrincipal() {
    return colorPrincipal;
  }

  public Color getColorSecundario() {
    return colorSecundario;
  }

}
