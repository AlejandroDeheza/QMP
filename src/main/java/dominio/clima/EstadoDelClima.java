package dominio.clima;

import java.math.BigDecimal;

public class EstadoDelClima {

  BigDecimal temperatura;
  BigDecimal humedad;

  public EstadoDelClima(BigDecimal temperatura, BigDecimal humedad) {
    this.temperatura = temperatura;
    this.humedad = humedad;
  }

  public BigDecimal getTemperatura() {
    return temperatura;
  }

  public BigDecimal getHumedad() {
    return humedad;
  }

}
