package ropa;

import excepciones.PrendaInvalidaException;

public class Prenda {

  //deprecated
  private String tipo;
  private CategoriaPrenda categoria;

  //deprecated
  Prenda(){}

  //refactorizado
  private TipoPrenda tipo2;
  private MaterialConstruccion materialConstruccion;
  private Color colorPrincipal;
  private Color colorSecundario;

  Prenda(TipoPrenda tipo2, MaterialConstruccion materialConstruccion, Color colorPrincipal, Color colorSecundario){
    this.validarPrenda(tipo2, materialConstruccion, colorPrincipal);
    this.tipo2 = tipo2;
    this.materialConstruccion = materialConstruccion;
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
  }

  private void validarPrenda(TipoPrenda tipo2, MaterialConstruccion materialConstruccion, Color colorPrincipal) {
    if(tipo == null || materialConstruccion == null || colorPrincipal == null){
      throw new PrendaInvalidaException("Falta ingresar TIPO, MATERIAL DE CONSTRUCCION o COLOR PRINCIPAL de la prenda");
    }
  }

  //SETTERS //deprecated
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public void setCategoria(CategoriaPrenda categoria) {
    this.categoria = categoria;
  }

  public void setMaterialConstruccion(MaterialConstruccion materialConstruccion) {
    this.materialConstruccion = materialConstruccion;
  }

  public void setColorPrincipal(Color colorPrincipal) {
    this.colorPrincipal = colorPrincipal;
  }

  public void setColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
  }


  //GETTERS
  public String getTipo() {
    return tipo;
  } //deprecated

  public TipoPrenda getTipo2() {
    return tipo2;
  }

  public CategoriaPrenda getCategoria() {
    return categoria;
  } //deprecated

  public MaterialConstruccion getMaterialConstruccion() {
    return materialConstruccion;
  }

  public Color getColorPrincipal() {
    return colorPrincipal;
  }

  public Color getColorSecundario() {
    return colorSecundario;
  }
}
