package ec.edu.ups.BoscoMarketApi.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
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
    @OneToMany(fetch =  FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<FacturaCabecera> facturaCabeceras;

    public Cliente() {
    }
}
