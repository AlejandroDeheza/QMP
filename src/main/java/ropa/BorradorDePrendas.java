package ropa;

import excepciones.PrendaInvalidaException;

public class BorradorDePrendas {

  private TipoPrenda tipoPrenda;
  private TipoMaterial tipoMaterial;
  private Trama trama = Trama.LISA; //valor por defecto
  private Color colorPrincipal;
  private Color colorSecundario;

  public BorradorDePrendas(TipoPrenda tipoPrenda){
    if(tipoPrenda == null)
      throw new PrendaInvalidaException("Falta ingresar TIPO a la prenda");
    this.tipoPrenda = tipoPrenda;
  }

  public BorradorDePrendas setTipoMaterial(TipoMaterial tipoMaterial){
    if(tipoMaterialNoCondiceConTipoPrenda(tipoMaterial)){
      throw new PrendaInvalidaException(
          "El TIPO DE MATERIAL DE CONSTRUCCION ingresado no condice con el TIPO DE PRENDA ingresado anteriormente");
    }
    this.tipoMaterial = tipoMaterial;
    return this;
  }

  public BorradorDePrendas setTrama(Trama trama){
    if(trama != null){
      this.trama = trama;
    }
    return this;
  }

  public BorradorDePrendas setColorPrincipal(Color colorPrincipal){
    if(colorPrincipal == null)
      throw new PrendaInvalidaException("Falta ingresar COLOR PRINCIPAL a la prenda");
    this.colorPrincipal = colorPrincipal;
    return this;
  }

  public BorradorDePrendas setColorSecundario(Color colorSecundario){
    this.colorSecundario = colorSecundario;
    return this;
  }

  public CategoriaPrenda identificarCategoria() {
    return tipoPrenda.getCategoria();
  }

  public Prenda generarPrenda(){
    if(tipoMaterial == null)
      throw new PrendaInvalidaException("Falta ingresar TIPO DE MATERIAL DE CONSTRUCCION a la prenda");
    if(colorPrincipal == null)
      throw new PrendaInvalidaException("Falta ingresar COLOR PRINCIPAL a la prenda");

    return new Prenda(tipoPrenda, tipoMaterial, trama, colorPrincipal, colorSecundario);
  }

  private boolean tipoMaterialNoCondiceConTipoPrenda(TipoMaterial tipoMaterial) {
    if(tipoMaterial == TipoMaterial.CUERO && this.tipoPrenda == TipoPrenda.CAMISA){
      return true;
    }
    if(tipoMaterial == TipoMaterial.CUERO && this.tipoPrenda == TipoPrenda.LENTES){
      return true;
    }
    if(tipoMaterial == TipoMaterial.DE_VESTIR && this.tipoPrenda == TipoPrenda.BERMUDA){
      return true;
    }
    if(tipoMaterial == TipoMaterial.DE_VESTIR && this.tipoPrenda == TipoPrenda.LENTES){
      return true;
    }

    //Aca se podrían agregar mas condiciones a mano, no es muy mantenible pero no le estoy dando mucha importancia porque
    //no era muy importante en el ejercicio
    return false;
  }
}
