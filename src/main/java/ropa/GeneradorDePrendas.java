package ropa;

import excepciones.FaltaTipoDePrendaException;
import excepciones.PrendaInvalidaException;

public class GeneradorDePrendas {

  private Prenda prenda = new Prenda();



  public void configurarNuevaPrenda() {
    prenda = new Prenda();
  }



  public void setTipoConCategoria(String tipoPrenda) {
    CategoriaPrenda categoria = RepositorioTipoPrendas.instance().buscarCategoria(tipoPrenda);
    prenda.setTipo(tipoPrenda);
    prenda.setCategoria(categoria);
  }

  public void setMaterialConstruccion(MaterialConstruccion materialConstruccion) {
    prenda.setMaterialConstruccion(materialConstruccion);
  }

  public void setColorPrincipal(Color colorPrincipal) {
    prenda.setColorPrincipal(colorPrincipal);
  }

  public void setColorSecundario(Color colorSecundario) {
    prenda.setColorSecundario(colorSecundario);
  }




  public CategoriaPrenda identificarCategoria() {

    if (this.prenda.getTipo() == null) {
      throw new FaltaTipoDePrendaException("Para Identificar la CATEGORIA de tu prenda primero es necesario ingresar su TIPO");
    }
    return prenda.getCategoria();
  }

  public Prenda getPrendaValida() {

    if (esPrendaInvalida()) {
      throw new PrendaInvalidaException("Falta tipo de prenda, material de construccion y/o color primario");
    } else {
      return prenda;
    }
  }

  private Boolean esPrendaInvalida(){
    return this.prenda.getTipo() == null
        || this.prenda.getMaterialConstruccion() == null
        || this.prenda.getColorPrincipal() == null;
  }
}
