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

  public CategoriaPrenda identificarCategoria() {
    return tipo.getCategoria();
  }

  public void setMaterialPrenda(MaterialConstruccion materialConstruccion){
    this.validarMaterialPrenda(materialConstruccion);
    this.materialConstruccion = materialConstruccion;
  }

  public Prenda generarPrenda(){
    return new Prenda(this.tipo, this.materialConstruccion);
  }

  private void validarMaterialPrenda(MaterialConstruccion materialConstruccion) {
    if(materialConstruccion.getTipoMaterial() == null){
      throw new PrendaInvalidaException("Falta ingresar el TIPO DE MATERIAL DE CONSTRUCCION de la prenda");
    }
    if(materialConstruccion.getColorPrincipal() == null){
      throw new PrendaInvalidaException("Falta ingresar COLOR PRINCIPAL de la prenda");
    }
    if(tipoMaterialNoCondiceConTipoPrenda(materialConstruccion.getTipoMaterial())){
      throw new PrendaInvalidaException(
          "El TIPO DE MATERIAL DE CONSTRUCCION ingresado no condice con el TIPO DE PRENDA ingresado anteriormente");
    }
  }

  private boolean tipoMaterialNoCondiceConTipoPrenda(TipoMaterial tipoMaterial) {
    if(tipoMaterial == TipoMaterial.CUERO && this.tipo == TipoPrenda.CAMISA){
      return true;
    }
    if(tipoMaterial == TipoMaterial.CUERO && this.tipo == TipoPrenda.LENTES){
      return true;
    }
    if(tipoMaterial == TipoMaterial.DE_VESTIR && this.tipo == TipoPrenda.BERMUDA){
      return true;
    }
    if(tipoMaterial == TipoMaterial.DE_VESTIR && this.tipo == TipoPrenda.LENTES){
      return true;
    }

    //Aca se podrían agregar mas condiciones a mano, no es muy mantenible pero no le estoy dando mucha importancia porque
    //no era muy importante en el ejercicio
    return false;
  }
}
