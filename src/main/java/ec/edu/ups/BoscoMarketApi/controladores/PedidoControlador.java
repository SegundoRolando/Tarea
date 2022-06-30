package ec.edu.ups.BoscoMarketApi.controladores;

import ec.edu.ups.BoscoMarketApi.entidades.Pedido;
import ec.edu.ups.BoscoMarketApi.entidades.Producto;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.Pedido.CrearPedido;
import ec.edu.ups.BoscoMarketApi.servicios.*;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PedidoControlador{

    @Autowired
    @Setter
    private PedidoServicio pedidoServicio;
    @Autowired
    @Setter
    private SucursalServicio sucursalServicio;
    @Autowired
    @Setter
    private FacturaCabeceraServicio facturaCabeceraServicio;

    @Autowired
    @Setter
    private ProductoServicio productoServicio;

    @PostMapping("/pedido/create")
    public ResponseEntity<Pedido> createPedido(@RequestBody CrearPedido crearPedido){
        Pedido pedido = new Pedido();
        pedido.setCostoEnvio(crearPedido.getCostoEnvio());
        pedido.setEstado(crearPedido.getEstado());
        pedido.setLatitud(crearPedido.getLatitud());
        pedido.setLongitud(crearPedido.getLongitud());

        pedido.setSucursal(sucursalServicio.findById(crearPedido.getIdSucursal()));
        pedido.setFacturaCabecera(facturaCabeceraServicio.findById(crearPedido.getIdFacturaCabecera()));
        pedido.setProducto(productoServicio.findById(crearPedido.getIdProducto()));
        pedidoServicio.save(pedido);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/pedidos")
    public ResponseEntity <List<Pedido>> getAllPedidos(){
        List<Pedido> pedidoList = pedidoServicio.findAll();
        return new ResponseEntity<List<Pedido>>(pedidoList, HttpStatus.OK);
    }
}
