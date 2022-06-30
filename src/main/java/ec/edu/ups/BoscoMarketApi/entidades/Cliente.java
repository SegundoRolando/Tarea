package ec.edu.ups.BoscoMarketApi.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int id;
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private String cedula;
    @Getter @Setter
    private String apellido;
    @Getter @Setter
    private String telefono;
    @Getter @Setter
    private String correo;
    @Getter @Setter
    private String direccion;

    public Cliente() {
    }
}
