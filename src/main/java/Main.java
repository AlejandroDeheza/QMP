import dominio.clima.AccuWeather;
import dominio.clima.AccuWeatherAPI;
import dominio.clima.RepositorioClima;
import dominio.clima.ServicioMeteorologico;
import dominio.interesadoEnAlertas.ActualizadorSugerenciasAnteAlerta;
import dominio.ropa.*;
import dominio.usuario.AsesorDeImagen;
import dominio.usuario.Guardarropa;
import dominio.usuario.RepositorioUsuarios;
import dominio.usuario.Usuario;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    ServicioMeteorologico servicioMeteorologico = new AccuWeather(
        new AccuWeatherAPI(),
        RepositorioClima.getInstance(),
        RepositorioUsuarios.getInstance()
    );

    Guardarropa unGuardarropa = new Guardarropa(
        "sin criterio",
        new HashSet<>(),
        new HashSet<>(),
        new HashSet<>(),
        new HashSet<>()
    );

    unGuardarropa.agregarPrenda(new Prenda(TipoPrenda.CAMISA, TipoMaterial.ALGODON, Trama.A_CUADROS, new Color(1, 2, 3), null, BigDecimal.valueOf(50)));
    unGuardarropa.agregarPrenda(new Prenda(TipoPrenda.BERMUDA, TipoMaterial.ALGODON, Trama.A_CUADROS, new Color(1, 2, 3), null, BigDecimal.valueOf(50)));
    unGuardarropa.agregarPrenda(new Prenda(TipoPrenda.BOTAS, TipoMaterial.ALGODON, Trama.A_CUADROS, new Color(1, 2, 3), null, BigDecimal.valueOf(50)));
    unGuardarropa.agregarPrenda(new Prenda(TipoPrenda.LENTES, TipoMaterial.ALGODON, Trama.A_CUADROS, new Color(1, 2, 3), null, BigDecimal.valueOf(50)));

    List<Guardarropa> lista = new ArrayList<>();
    lista.add(unGuardarropa);
    List<Guardarropa> otraLista = new ArrayList<>();
    otraLista.add(unGuardarropa);

    Usuario unUsuario = new Usuario(
        lista,
        new AsesorDeImagen(servicioMeteorologico),
        "Buenos Aires, Argentina",
        "algo@gmail.com"
    );

    Usuario otroUsuario = new Usuario(
        otraLista,
        new AsesorDeImagen(servicioMeteorologico),
        "Buenos Aires, Argentina",
        "otroAlgo@gmail.com"
    );

    unUsuario.suscribirAccionSobreAlertas(new ActualizadorSugerenciasAnteAlerta());
    otroUsuario.suscribirAccionSobreAlertas(new ActualizadorSugerenciasAnteAlerta());

    RepositorioUsuarios.getInstance().agregarUsuario(unUsuario);
    RepositorioUsuarios.getInstance().agregarUsuario(otroUsuario);

    RepositorioUsuarios.getInstance().calcularSugerenciasDiarias();
    servicioMeteorologico.actualizarAlertasMeteorologicas("Buenos Aires, Argentina");
  }
}
