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
    BorradorDePrendas borradorDePrendas = new BorradorDePrendas(TipoPrenda.BUZO);
    Assertions.assertEquals(borradorDePrendas.identificarCategoria(), CategoriaPrenda.PARTE_SUPERIOR);
    borradorDePrendas = new BorradorDePrendas(TipoPrenda.ZAPATILLAS);
    Assertions.assertEquals(borradorDePrendas.identificarCategoria(), CategoriaPrenda.CALZADO);
    borradorDePrendas = new BorradorDePrendas(TipoPrenda.PANTALON);
    Assertions.assertEquals(borradorDePrendas.identificarCategoria(), CategoriaPrenda.PARTE_INFERIOR);
    borradorDePrendas = new BorradorDePrendas(TipoPrenda.LENTES);
    Assertions.assertEquals(borradorDePrendas.identificarCategoria(), CategoriaPrenda.ACCESORIO);
  }

  @Test
  public void siCreoUnaPrendaValidaNoRompe() {
    BorradorDePrendas borradorDePrendas = new BorradorDePrendas(TipoPrenda.REMERA);
    borradorDePrendas.setTipoMaterial(TipoMaterial.ALGODON)
        .setColorPrincipal(new Color(1, 2, 3));
    Assertions.assertDoesNotThrow(borradorDePrendas::generarPrenda);
  }

  @Test
  public void siCreoUnaPrendaSinTipoPrendaSeGeneraPrendaInvalidaException() {
    Assertions.assertThrows(PrendaInvalidaException.class, () -> new BorradorDePrendas(null));
  }

  @Test
  public void siCreoUnaPrendaSinColorPrincipalSeGeneraPrendaInvalidaException() {
    BorradorDePrendas borradorDePrendas = new BorradorDePrendas(TipoPrenda.BERMUDA);
    borradorDePrendas.setTipoMaterial(TipoMaterial.ALGODON)
        .setColorSecundario(new Color(1, 2, 3));
    Assertions.assertThrows(PrendaInvalidaException.class, borradorDePrendas::generarPrenda);
  }

  @Test
  public void siCreoUnaPrendaSinTipoMaterialSeGeneraPrendaInvalidaException() {
    BorradorDePrendas borradorDePrendas = new BorradorDePrendas(TipoPrenda.BERMUDA);
    borradorDePrendas.setColorPrincipal(new Color(1, 2, 3));
    Assertions.assertThrows(PrendaInvalidaException.class, borradorDePrendas::generarPrenda);
  }

  @Test
  public void siCreoUnaPrendaQueNoCondiceMaterialConTipoPrendaSeGeneraPrendaInvalidaException() {
    BorradorDePrendas borradorDePrendas = new BorradorDePrendas(TipoPrenda.CAMISA);
    Assertions.assertThrows(PrendaInvalidaException.class, () -> borradorDePrendas.setTipoMaterial(TipoMaterial.CUERO));
  }

  ///

  @Test
  public void ColegioSanJuanGeneraUniformeCorrectamente() {
    Institucion sanJuan = new ColegioSanJuan();
    Uniforme uniforme = sanJuan.crearUniforme();
    Assertions.assertEquals(TipoPrenda.CHOMBA, uniforme.getPrendaSuperior().getTipo());
    Assertions.assertEquals(TipoMaterial.PIQUE, uniforme.getPrendaSuperior().getTipoMaterial());
    Assertions.assertEquals(Integer.valueOf(0), uniforme.getPrendaSuperior().getColorPrincipal().getRojo());
    Assertions.assertEquals(Integer.valueOf(255), uniforme.getPrendaSuperior().getColorPrincipal().getVerde());
    Assertions.assertEquals(Integer.valueOf(0), uniforme.getPrendaSuperior().getColorPrincipal().getAzul());
    Assertions.assertEquals(TipoPrenda.PANTALON, uniforme.getPrendaInferior().getTipo());
    Assertions.assertEquals(TipoMaterial.ACETATO, uniforme.getPrendaInferior().getTipoMaterial());
    Assertions.assertEquals(Integer.valueOf(150), uniforme.getPrendaInferior().getColorPrincipal().getRojo());
    Assertions.assertEquals(Integer.valueOf(152), uniforme.getPrendaInferior().getColorPrincipal().getVerde());
    Assertions.assertEquals(Integer.valueOf(154), uniforme.getPrendaInferior().getColorPrincipal().getAzul());
    Assertions.assertEquals(TipoPrenda.ZAPATILLAS, uniforme.getCalzado().getTipo());
    Assertions.assertEquals(TipoMaterial.POLIESTER, uniforme.getCalzado().getTipoMaterial());
    Assertions.assertEquals(Integer.valueOf(255), uniforme.getCalzado().getColorPrincipal().getRojo());
    Assertions.assertEquals(Integer.valueOf(255), uniforme.getCalzado().getColorPrincipal().getVerde());
    Assertions.assertEquals(Integer.valueOf(255), uniforme.getCalzado().getColorPrincipal().getAzul());
  }

  @Test
  public void InstitutoJohnsonGeneraUniformeCorrectamente() {
    Institucion johnson = new InstitutoJohnson();
    Uniforme uniforme = johnson.crearUniforme();
    Assertions.assertEquals(TipoPrenda.CAMISA, uniforme.getPrendaSuperior().getTipo());
    Assertions.assertEquals(TipoMaterial.ALGODON, uniforme.getPrendaSuperior().getTipoMaterial());
    Assertions.assertEquals(Integer.valueOf(255), uniforme.getPrendaSuperior().getColorPrincipal().getRojo());
    Assertions.assertEquals(Integer.valueOf(255), uniforme.getPrendaSuperior().getColorPrincipal().getVerde());
    Assertions.assertEquals(Integer.valueOf(255), uniforme.getPrendaSuperior().getColorPrincipal().getAzul());
    Assertions.assertEquals(TipoPrenda.PANTALON, uniforme.getPrendaInferior().getTipo());
    Assertions.assertEquals(TipoMaterial.DE_VESTIR, uniforme.getPrendaInferior().getTipoMaterial());
    Assertions.assertEquals(Integer.valueOf(0), uniforme.getPrendaInferior().getColorPrincipal().getRojo());
    Assertions.assertEquals(Integer.valueOf(0), uniforme.getPrendaInferior().getColorPrincipal().getVerde());
    Assertions.assertEquals(Integer.valueOf(0), uniforme.getPrendaInferior().getColorPrincipal().getAzul());
    Assertions.assertEquals(TipoPrenda.ZAPATOS, uniforme.getCalzado().getTipo());
    Assertions.assertEquals(TipoMaterial.CUERO, uniforme.getCalzado().getTipoMaterial());
    Assertions.assertEquals(Integer.valueOf(0), uniforme.getCalzado().getColorPrincipal().getRojo());
    Assertions.assertEquals(Integer.valueOf(0), uniforme.getCalzado().getColorPrincipal().getVerde());
    Assertions.assertEquals(Integer.valueOf(0), uniforme.getCalzado().getColorPrincipal().getAzul());
  }

}
