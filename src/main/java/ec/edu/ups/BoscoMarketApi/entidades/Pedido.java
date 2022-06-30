package ec.edu.ups.BoscoMarketApi.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Pedido implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private double latitud;
    @Getter @Setter
    private double longitud;
    @Getter @Setter
    private String estado;
    @Getter @Setter
    private double costoEnvio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @Getter @Setter
    private Sucursal  sucursal;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @Getter @Setter
    private FacturaCabecera facturaCabecera;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "pedido", cascade = CascadeType.ALL)
    @JsonIgnore
    @Getter @Setter
    private List<Producto> producto;

    public Pedido() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", estado='" + estado + '\'' +
                ", costoEnvio=" + costoEnvio +
                ", sucursal=" + sucursal +
                ", facturaCabecera=" + facturaCabecera +
                '}';
    }
}
