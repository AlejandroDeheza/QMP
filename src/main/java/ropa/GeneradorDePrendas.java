package ropa;

import excepciones.PrendaInvalidaException;

public class GeneradorDePrendas {

  private TipoPrenda tipo;
  private MaterialConstruccion materialConstruccion;

  public GeneradorDePrendas(TipoPrenda tipo){
    this.tipo = tipo;
  }

  public void setMaterialPrenda(MaterialConstruccion materialConstruccion){
    this.validarMaterialPrenda(materialConstruccion);
    this.materialConstruccion = materialConstruccion;
  }

  private void validarMaterialPrenda(MaterialConstruccion materialConstruccion) {
    //TODO
    //que materiales serian inconsistentes segun el tipo de prenda?
  }

  public Prenda generarPrenda(){
    this.validarPrenda();
    return new Prenda(this.tipo, this.materialConstruccion);
  }

  private void validarPrenda() {

    if (esPrendaInvalida()) {
      throw new PrendaInvalidaException("Falta ingresar TIPO, MATERIAL DE CONSTRUCCION y/o COLOR PRINCIPAL de la prenda");
    }
  }

  private Boolean esPrendaInvalida(){
    return this.tipo == null
        || this.materialConstruccion.getTipoMaterial() == null
        || this.materialConstruccion.getColorPrincipal() == null;
  }

  public CategoriaPrenda identificarCategoria() {
    return tipo.getCategoria();
  }
}
