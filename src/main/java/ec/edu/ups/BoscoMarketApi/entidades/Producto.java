package ec.edu.ups.BoscoMarketApi.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private long id;
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private double precio;
    @Getter @Setter
    private int stock;
    @Getter @Setter
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter @Setter
    private Sucursal sucursal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @Getter @Setter
    private Pedido pedido;
    @OneToOne
    @Getter @Setter
    private Categoria categoria;

    public Producto() {
    }

    public Producto(Long id, String nombre, double precio, int stock, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
    }

}
