package ropa;

public class MaterialConstruccion {

  private TipoMaterial tipoMaterial;
  private Trama trama = Trama.LISA;
  private Color colorPrincipal;
  private Color colorSecundario;

  public MaterialConstruccion(TipoMaterial tipoMaterial, Trama trama, Color colorPrincipal, Color colorSecundario){
    this.tipoMaterial = tipoMaterial;
    if(trama != null){
      this.trama = trama;
    }
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
  }


  //GETTERS
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
