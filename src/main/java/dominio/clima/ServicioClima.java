package dominio.clima;

public interface ServicioClima {

  Integer getProbabilidadDePrecipitacionesActual(String ciudad);

  Integer getTemperaturaCelciusActual(String ciudad);
}
