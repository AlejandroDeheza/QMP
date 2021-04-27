package ropa;

public class Prenda {

  private TipoPrenda tipo;
  private MaterialConstruccion materialConstruccion;

  Prenda(TipoPrenda tipo, MaterialConstruccion materialConstruccion){
    this.tipo = tipo;
    this.materialConstruccion = materialConstruccion;
  }


  //GETTERS
  public TipoPrenda getTipo() {
    return tipo;
  }

  public CategoriaPrenda getCategoria() {
    return tipo.getCategoria();
  }

  public TipoMaterial getTipoMaterialConstruccion() {
    return materialConstruccion.getTipoMaterial();
  }

  public Trama getTrama() {
    return materialConstruccion.getTrama();
  }

  public Color getColorPrincipal() {
    return materialConstruccion.getColorPrincipal();
  }

  public Color getColorSecundario() {
    return materialConstruccion.getColorSecundario();
  }
}
