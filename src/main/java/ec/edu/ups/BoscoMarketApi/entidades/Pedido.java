package ec.edu.ups.BoscoMarketApi.entidades;

import javax.persistence.*;

@Entity
public class Pedido{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double latitud;
    private double longitud;
    private String estado;
    private double costoEnvio;
    //@ManyToOne
    //@JoinColumn
    //private Usuario usuario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Sucursal  sucursal;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private FacturaCabecera facturaCabecera;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Producto producto;
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

   /* public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }*/

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public FacturaCabecera getFacturaCabecera() {
        return facturaCabecera;
    }

    public void setFacturaCabecera(FacturaCabecera facturaCabecera) {
        this.facturaCabecera = facturaCabecera;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
