package tests;

import excepciones.PrendaInvalidaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ropa.*;

public class RopaTest {

  @BeforeAll
  public static void hacerAlgo() {
  }

  @Test
  public void elGeneradorDePrendasIdentificaCategoriaCorrectamente(){
    GeneradorDePrendas generadorDePrendas = new GeneradorDePrendas(TipoPrenda.BUZO);
    Assertions.assertEquals(generadorDePrendas.identificarCategoria(), CategoriaPrenda.PARTE_SUPERIOR);
    generadorDePrendas = new GeneradorDePrendas(TipoPrenda.ZAPATILLAS);
    Assertions.assertEquals(generadorDePrendas.identificarCategoria(), CategoriaPrenda.CALZADO);
    generadorDePrendas = new GeneradorDePrendas(TipoPrenda.PANTALON);
    Assertions.assertEquals(generadorDePrendas.identificarCategoria(), CategoriaPrenda.PARTE_INFERIOR);
    generadorDePrendas = new GeneradorDePrendas(TipoPrenda.LENTES);
    Assertions.assertEquals(generadorDePrendas.identificarCategoria(), CategoriaPrenda.ACCESORIO);
  }

  @Test
  public void siCreoUnaPrendaValidaNoRompe() {
    GeneradorDePrendas generadorDePrendas = new GeneradorDePrendas(TipoPrenda.REMERA);
    MaterialConstruccion materialConstruccion = new MaterialConstruccion(
        TipoMaterial.ALGODON, null, new Color(1, 2, 3), null);
    generadorDePrendas.setMaterialPrenda(materialConstruccion);
    Assertions.assertDoesNotThrow(generadorDePrendas::generarPrenda);
  }

  @Test
  public void siCreoUnaPrendaSinTipoPrendaSeGeneraPrendaInvalidaException() {
    Assertions.assertThrows(PrendaInvalidaException.class, () -> new GeneradorDePrendas(null));
  }

  @Test
  public void siCreoUnaPrendaSinColorPrincipalSeGeneraPrendaInvalidaException() {
    GeneradorDePrendas generadorDePrendas = new GeneradorDePrendas(TipoPrenda.BERMUDA);
    MaterialConstruccion materialConstruccion = new MaterialConstruccion(
        TipoMaterial.ALGODON, null, null, new Color(1, 2, 3));
    Assertions.assertThrows(PrendaInvalidaException.class, () -> generadorDePrendas.setMaterialPrenda(materialConstruccion));
  }

  @Test
  public void siCreoUnaPrendaSinTipoMaterialSeGeneraPrendaInvalidaException() {
    GeneradorDePrendas generadorDePrendas = new GeneradorDePrendas(TipoPrenda.BERMUDA);
    MaterialConstruccion materialConstruccion = new MaterialConstruccion(
        null, null, new Color(1, 2, 3), null);
    Assertions.assertThrows(PrendaInvalidaException.class, () -> generadorDePrendas.setMaterialPrenda(materialConstruccion));
  }

  @Test
  public void siCreoUnaPrendaQueNoCondiceMaterialConTipoPrendaSeGeneraPrendaInvalidaException() {
    GeneradorDePrendas generadorDePrendas = new GeneradorDePrendas(TipoPrenda.CAMISA);
    MaterialConstruccion materialConstruccion = new MaterialConstruccion(
        TipoMaterial.CUERO, null, new Color(1, 2, 3), null);
    Assertions.assertThrows(PrendaInvalidaException.class, () -> generadorDePrendas.setMaterialPrenda(materialConstruccion));
  }

  ///

  @Test
  public void ColegioSanJuanGeneraUniformeCorrectamente() {
    Institucion sanJuan = new ColegioSanJuan();
    Uniforme uniforme = sanJuan.crearUniforme();
    Assertions.assertEquals(TipoPrenda.CHOMBA, uniforme.getPrendaSuperior().getTipo());
    Assertions.assertEquals(TipoMaterial.PIQUE, uniforme.getPrendaSuperior().getTipoMaterialConstruccion());
    Assertions.assertEquals(Integer.valueOf(0), uniforme.getPrendaSuperior().getColorPrincipal().getRojo());
    Assertions.assertEquals(Integer.valueOf(255), uniforme.getPrendaSuperior().getColorPrincipal().getVerde());
    Assertions.assertEquals(Integer.valueOf(0), uniforme.getPrendaSuperior().getColorPrincipal().getAzul());
    Assertions.assertEquals(TipoPrenda.PANTALON, uniforme.getPrendaInferior().getTipo());
    Assertions.assertEquals(TipoMaterial.ACETATO, uniforme.getPrendaInferior().getTipoMaterialConstruccion());
    Assertions.assertEquals(Integer.valueOf(150), uniforme.getPrendaInferior().getColorPrincipal().getRojo());
    Assertions.assertEquals(Integer.valueOf(152), uniforme.getPrendaInferior().getColorPrincipal().getVerde());
    Assertions.assertEquals(Integer.valueOf(154), uniforme.getPrendaInferior().getColorPrincipal().getAzul());
    Assertions.assertEquals(TipoPrenda.ZAPATILLAS, uniforme.getCalzado().getTipo());
    Assertions.assertEquals(TipoMaterial.POLIESTER, uniforme.getCalzado().getTipoMaterialConstruccion());
    Assertions.assertEquals(Integer.valueOf(255), uniforme.getCalzado().getColorPrincipal().getRojo());
    Assertions.assertEquals(Integer.valueOf(255), uniforme.getCalzado().getColorPrincipal().getVerde());
    Assertions.assertEquals(Integer.valueOf(255), uniforme.getCalzado().getColorPrincipal().getAzul());
  }

  @Test
  public void InstitutoJohnsonGeneraUniformeCorrectamente() {
    Institucion johnson = new InstitutoJohnson();
    Uniforme uniforme = johnson.crearUniforme();
    Assertions.assertEquals(TipoPrenda.CAMISA, uniforme.getPrendaSuperior().getTipo());
    Assertions.assertEquals(TipoMaterial.ALGODON, uniforme.getPrendaSuperior().getTipoMaterialConstruccion());
    Assertions.assertEquals(Integer.valueOf(255), uniforme.getPrendaSuperior().getColorPrincipal().getRojo());
    Assertions.assertEquals(Integer.valueOf(255), uniforme.getPrendaSuperior().getColorPrincipal().getVerde());
    Assertions.assertEquals(Integer.valueOf(255), uniforme.getPrendaSuperior().getColorPrincipal().getAzul());
    Assertions.assertEquals(TipoPrenda.PANTALON, uniforme.getPrendaInferior().getTipo());
    Assertions.assertEquals(TipoMaterial.DE_VESTIR, uniforme.getPrendaInferior().getTipoMaterialConstruccion());
    Assertions.assertEquals(Integer.valueOf(0), uniforme.getPrendaInferior().getColorPrincipal().getRojo());
    Assertions.assertEquals(Integer.valueOf(0), uniforme.getPrendaInferior().getColorPrincipal().getVerde());
    Assertions.assertEquals(Integer.valueOf(0), uniforme.getPrendaInferior().getColorPrincipal().getAzul());
    Assertions.assertEquals(TipoPrenda.ZAPATOS, uniforme.getCalzado().getTipo());
    Assertions.assertEquals(TipoMaterial.CUERO, uniforme.getCalzado().getTipoMaterialConstruccion());
    Assertions.assertEquals(Integer.valueOf(0), uniforme.getCalzado().getColorPrincipal().getRojo());
    Assertions.assertEquals(Integer.valueOf(0), uniforme.getCalzado().getColorPrincipal().getVerde());
    Assertions.assertEquals(Integer.valueOf(0), uniforme.getCalzado().getColorPrincipal().getAzul());
  }

}
