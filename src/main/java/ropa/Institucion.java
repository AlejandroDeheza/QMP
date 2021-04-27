package ropa;

public abstract class Institucion {

  public abstract Uniforme crearUniforme();

  public Prenda generarPrenda(TipoPrenda tipo, TipoMaterial material, Trama trama, Color colorPrimario, Color colorSecundario){
    GeneradorDePrendas generadorDePrendas = new GeneradorDePrendas(tipo);
    MaterialConstruccion materialConstruccion = new MaterialConstruccion(material, trama, colorPrimario, colorSecundario);
    generadorDePrendas.setMaterialPrenda(materialConstruccion);
    return generadorDePrendas.generarPrenda();
  }
}
