package ropa;

import excepciones.PrendaInvalidaException;

public class GeneradorDePrendas {

  private TipoPrenda tipo;
  private MaterialConstruccion materialConstruccion;

  public GeneradorDePrendas(TipoPrenda tipo){
    if(tipo == null){
      throw new PrendaInvalidaException("Falta ingresar TIPO de la prenda");
    }
    this.tipo = tipo;
  }

  public void setMaterialPrenda(MaterialConstruccion materialConstruccion){
    this.validarMaterialPrenda(materialConstruccion);
    this.materialConstruccion = materialConstruccion;
  }

  private void validarMaterialPrenda(MaterialConstruccion materialConstruccion) {
    if(materialConstruccion.getTipoMaterial() == null){
      throw new PrendaInvalidaException("Falta ingresar el TIPO DE MATERIAL DE CONSTRUCCION de la prenda");
    }
    if(materialConstruccion.getColorPrincipal() == null){
      throw new PrendaInvalidaException("Falta ingresar COLOR PRINCIPAL de la prenda");
    }
    if(materialConstruccionNoCondiceConElTipo(materialConstruccion)){
      throw new PrendaInvalidaException(
          "El TIPO DE MATERIAL DE CONSTRUCCION ingresado no condice con el TIPO DE PRENDA ingresado anteriormente");
    }
  }

  private boolean materialConstruccionNoCondiceConElTipo(MaterialConstruccion materialConstruccion) {
    throw new Error("METHOD materialConstruccionNoCondiceConElTipo() NOT IMPLEMENTED. class GeneradorDePrendas");
    //TODO
    //que materiales serian inconsistentes segun el tipo de prenda?
  }

  public Prenda generarPrenda(){
    return new Prenda(this.tipo, this.materialConstruccion);
  }

  public CategoriaPrenda identificarCategoria() {
    return tipo.getCategoria();
  }
}
