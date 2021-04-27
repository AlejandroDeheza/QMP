package excepciones;

public class TipoDePrendaInvalidaException extends RuntimeException {
  public TipoDePrendaInvalidaException(String causa) {
    super("" + causa);
  }
}
