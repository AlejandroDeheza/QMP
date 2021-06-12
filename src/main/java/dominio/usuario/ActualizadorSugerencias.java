package dominio.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ActualizadorSugerencias implements InteresadoEnAlertas {

  private String ciudad;
  private AsesorDeImagen asesorDeImagen;
  private List<Usuario> suscritos = new ArrayList<>();
  //hashMap con usuarios y sus ciudades? TODO
  //necesito una lista de usuarios o siempre puedo generar una instancia nueva para un usuario nuevo? TODO
  //esta clase deberia ser un singleton? para que el servicio meteorologico conozca solo una instancia..
  // ó cada vez que creo una instancia de este Interesado, la debo agregar a la lista del servicio meteorologico? TODO

  public ActualizadorSugerencias(String ciudad, AsesorDeImagen asesorDeImagen) {
    this.ciudad = ciudad;
    this.asesorDeImagen = asesorDeImagen;
  }

  public void avisar(List<String> alertasActuales, String ciudad) {
    if (this.ciudad.equals(ciudad)) {
      Random aleatorio = new Random();  // LOGICA REPETICA CON REPOSITORIO-USUARIOS TODO
      this.suscritos.forEach(
          usuario -> usuario.agregarSugerencia(
              // deberia dejar el metodo en el usuario?
              // dejando la ciudad y el asesor como atributos del usuario?
              asesorDeImagen.sugerirAtuendo(
                  ciudad,
                  usuario.getGuardarropas().get(aleatorio.nextInt(usuario.getGuardarropas().size()))
              )
          )
      );
    }
  }

  public void suscribirse(Usuario usuario) {
    this.suscritos.add(usuario);
  }

  public void desuscribirse(Usuario usuario) {
    this.suscritos.remove(usuario);
  }
}
