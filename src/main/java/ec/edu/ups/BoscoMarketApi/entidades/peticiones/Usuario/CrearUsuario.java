package ec.edu.ups.BoscoMarketApi.entidades.peticiones.Usuario;

import com.fasterxml.jackson.annotation.JsonProperty;
import ec.edu.ups.BoscoMarketApi.entidades.Cliente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

public class CrearUsuario {
    @JsonProperty
    @Getter @Setter
    private String correo;
    @JsonProperty
    @Getter @Setter
    private String password;
    @JsonProperty
    @Getter @Setter
    private String rol;
    @JsonProperty
    @Getter @Setter
    private int cliente;

    public CrearUsuario() {
    }
}
