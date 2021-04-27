package excepciones;

public class FaltaTipoDePrendaException extends RuntimeException {
  public FaltaTipoDePrendaException(String causa) {
    super("" + causa);
  }
}
