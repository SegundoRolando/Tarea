package ec.edu.ups.BoscoMarketApi.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double latitud;
    private double longitud;
    private String estado;
    private double costoEnvio;
    @ManyToOne
    @JoinColumn
    private Usuario usuario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Sucursal  sucursal;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Factura factura;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Producto> producto;

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }
}
