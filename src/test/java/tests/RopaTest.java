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
  public void siCreoUnaPrendaValidaNoPasaNada() {
    GeneradorDePrendas generadorDePrendas = new GeneradorDePrendas(TipoPrenda.REMERA);
    MaterialConstruccion materialConstruccion = new MaterialConstruccion(
        TipoMaterial.ALGODON, null, new Color(1, 2, 3), null);
    generadorDePrendas.setMaterialPrenda(materialConstruccion);
    Assertions.assertDoesNotThrow(generadorDePrendas::generarPrenda);
  }

  @Test
  public void siCreoUnaPrendaInvalidaDaPrendaInvalidaException() {
    GeneradorDePrendas generadorDePrendas = new GeneradorDePrendas(TipoPrenda.BERMUDA);
    MaterialConstruccion materialConstruccion = new MaterialConstruccion(
        TipoMaterial.ALGODON, null, null, new Color(1, 2, 3));
    generadorDePrendas.setMaterialPrenda(materialConstruccion);
    Assertions.assertThrows(PrendaInvalidaException.class, generadorDePrendas::generarPrenda);
  }

  @Test
  public void siPidoCategoriaDespuesDeIngresarTipoDePrendaNoPasaNada() {
    GeneradorDePrendas generadorDePrendas = new GeneradorDePrendas(TipoPrenda.REMERA);
    Assertions.assertEquals(CategoriaPrenda.PARTE_SUPERIOR, generadorDePrendas.identificarCategoria());
  }

}
