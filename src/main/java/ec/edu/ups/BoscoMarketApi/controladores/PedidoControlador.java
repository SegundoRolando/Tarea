package ec.edu.ups.BoscoMarketApi.controladores;

import ec.edu.ups.BoscoMarketApi.entidades.*;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.Pedido.CrearPedido;
import ec.edu.ups.BoscoMarketApi.servicios.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PedidoControlador{
    @Autowired
    private PedidoServicio pedidoServicio;
    private SucursalServicio sucursalServicio;
    private FacturaCabeceraServicio facturaCabeceraServicio;
    private ProductoServicio productoServicio;

    public void setPedidoServicio(PedidoServicio pedidoServicio) {
        this.pedidoServicio = pedidoServicio;
    }

    public void setSucursalServicio(SucursalServicio sucursalServicio) {
        this.sucursalServicio = sucursalServicio;
    }

    public void setFacturaCabeceraServicio(FacturaCabeceraServicio facturaCabeceraServicio) {
        this.facturaCabeceraServicio = facturaCabeceraServicio;
    }

    public void setProductoServicio(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @PostMapping("/pedido/create")
    public ResponseEntity<Pedido> createPedido(@RequestBody CrearPedido crearPedido){

        Optional<Sucursal> sucursal = Optional.ofNullable(sucursalServicio.findById(crearPedido.getSucursal()));
        if (sucursal.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Optional<Producto> producto = Optional.ofNullable(productoServicio.findById(crearPedido.getProducto()));
        if (producto.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Optional<FacturaCabecera> facturaCabecera = Optional.ofNullable(facturaCabeceraServicio.findById(crearPedido.getFacturaCabecera()));
        if (facturaCabecera.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Pedido pedido = new Pedido();
        pedido.setLatitud(crearPedido.getLatitud());
        pedido.setLongitud(crearPedido.getLongitud());
        pedido.setEstado(crearPedido.getEstado());
        pedido.setCostoEnvio(crearPedido.getCostoEnvio());
        pedido.setSucursal(sucursal.get());
        pedido.setProducto(producto.get());
        pedido.setFacturaCabecera(facturaCabecera.get());
        pedidoServicio.save(pedido);
        return ResponseEntity.ok(pedido);
    }
}
