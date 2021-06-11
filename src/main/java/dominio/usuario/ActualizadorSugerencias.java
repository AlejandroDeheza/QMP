package dominio.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ActualizadorSugerencias implements ObserverClima{

  private String ciudad;
  private AsesorDeImagen asesorDeImagen;
  private List<Usuario> suscritos = new ArrayList<>();

  public ActualizadorSugerencias(String ciudad, AsesorDeImagen asesorDeImagen) {
    this.ciudad = ciudad;
    this.asesorDeImagen = asesorDeImagen;
  }

  public void actualizar(List<String> alertasActuales) {
    Random aleatorio = new Random();
    this.suscritos.forEach(
        usuario -> usuario.agregarSugerencia(
            asesorDeImagen.sugerirAtuendo(
                ciudad,
                usuario.getGuardarropas().get(aleatorio.nextInt(usuario.getGuardarropas().size()))
            )
        )
    );
  }

  public void suscribirse(Usuario usuario) {
    this.suscritos.add(usuario);
  }

  public void desuscribirse(Usuario usuario) {
    this.suscritos.remove(usuario);
  }
}
