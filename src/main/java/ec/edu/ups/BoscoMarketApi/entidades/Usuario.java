package ec.edu.ups.BoscoMarketApi.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String correo;
    @Getter @Setter
    private String password;
    @Getter @Setter
    private String rol;
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    @Getter @Setter
    private Cliente cliente;

    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                ", rol='" + rol + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
