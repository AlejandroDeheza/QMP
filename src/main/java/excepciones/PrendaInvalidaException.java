package excepciones;

public class PrendaInvalidaException extends RuntimeException {
  public PrendaInvalidaException(String causa) {
    super("La prenda es invalida porque: " + causa);
  }
}
