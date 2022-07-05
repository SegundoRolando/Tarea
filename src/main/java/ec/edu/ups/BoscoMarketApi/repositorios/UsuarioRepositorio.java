package ec.edu.ups.BoscoMarketApi.repositorios;

import ec.edu.ups.BoscoMarketApi.entidades.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
    @Query("SELECT p.correo FROM Usuario p where p.correo = :correo")
    String inicioSesionCorreo(String correo);

    @Query("SELECT p.password FROM Usuario p where p.password = :password")
    String inicioSesionPasword(String password);
}
