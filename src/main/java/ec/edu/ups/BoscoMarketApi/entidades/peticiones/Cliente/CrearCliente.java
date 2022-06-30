package ec.edu.ups.BoscoMarketApi.entidades.peticiones.Cliente;

import com.fasterxml.jackson.annotation.JsonProperty;
import ec.edu.ups.BoscoMarketApi.entidades.Usuario;
import lombok.Getter;
import lombok.Setter;

public class CrearCliente {
    @JsonProperty
    @Getter @Setter
    private String nombre;

    @JsonProperty
    @Getter @Setter
    private String cedula;

    @JsonProperty
    @Getter @Setter
    private String apellido;

    @JsonProperty
    @Getter @Setter
    private String telefono;

    @JsonProperty
    @Getter @Setter
    private String correo;

    @JsonProperty
    @Getter @Setter
    private String direccion;

    @JsonProperty
    @Getter @Setter
    private Long usuario;

    public CrearCliente() {
    }
}
