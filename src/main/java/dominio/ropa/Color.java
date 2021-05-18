package dominio.ropa;

public class Color {

  private Integer rojo;
  private Integer verde;
  private Integer azul;

  public Color(Integer rojo, Integer verde, Integer azul){

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
