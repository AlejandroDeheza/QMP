package dominio.ropa;

public class Color {

  private final Integer rojo;
  private final Integer verde;
  private final Integer azul;

  public Color(Integer rojo, Integer verde, Integer azul) {

    this.rojo = rojo;
    this.verde = verde;
    this.azul = azul;
  }


  //GETTERS
  public Integer getRojo() {
    return rojo;
  }

  public Integer getVerde() {
    return verde;
  }

  public Integer getAzul() {
    return azul;
  }
}
