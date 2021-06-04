package dominio.ropa;

import java.math.BigDecimal;

public class Prenda {

  private TipoPrenda tipo;
  private TipoMaterial tipoMaterial;
  private Trama trama;
  private Color colorPrincipal;
  private Color colorSecundario;
  private BigDecimal temperaturaMaximaDeUso;

  public Prenda(TipoPrenda tipo, TipoMaterial tipoMaterial, Trama trama, Color colorPrincipal, Color colorSecundario,
                BigDecimal temperaturaMaximaDeUso) {
    this.tipo = tipo;
    this.tipoMaterial = tipoMaterial;
    this.trama = trama;
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
    this.temperaturaMaximaDeUso = temperaturaMaximaDeUso;
  }

  public Boolean esAdecuadaPara(BigDecimal temperaturaActual) {
    return this.temperaturaMaximaDeUso.compareTo(temperaturaActual) >= 0;
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
