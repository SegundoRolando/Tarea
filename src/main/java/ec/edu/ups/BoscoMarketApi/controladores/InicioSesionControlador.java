package ec.edu.ups.BoscoMarketApi.controladores;

import ec.edu.ups.BoscoMarketApi.entidades.Usuario;
import ec.edu.ups.BoscoMarketApi.servicios.UsuarioServicio;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InicioSesionControlador {

    @Autowired
    @Setter
    private UsuarioServicio usuarioServicio;

    @PostMapping("/inicioSesion")
    public ResponseEntity<String> inicioSesion(@RequestBody Usuario usuario){
        String resultadoCorreo = usuarioServicio.iniciarSesionCorreo(usuario.getCorreo());
        String resultadoPassword = usuarioServicio.iniciarSesionPassword(usuario.getPassword());
        if (resultadoCorreo == null || resultadoPassword == null){
            return new ResponseEntity<String>("Correo o contraseña incorrectos", HttpStatus.OK);
        }else {
            return new ResponseEntity<String>("Inicio de sesion correcto", HttpStatus.OK);
        }
    }
}
