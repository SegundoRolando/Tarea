package ec.edu.ups.BoscoMarketApi.controladores;

import ec.edu.ups.BoscoMarketApi.entidades.Pedido;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.Categoria.ActualizarCategoria;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.Pedido.ActualizarPedido;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.Pedido.CrearPedido;
import ec.edu.ups.BoscoMarketApi.servicios.*;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    private FacturaDetalleServicio facturaDetalleServicio;
    @Autowired
    @Setter
    private ProductoServicio productoServicio;
    @Autowired
    @Setter
    private ClienteServicio clienteServicio;

    @PostMapping("/pedido/create")
    public ResponseEntity<Pedido> createPedido(@RequestBody CrearPedido crearPedido){
        Pedido pedido = new Pedido();
        pedido.setCostoEnvio(crearPedido.getCostoEnvio());
        pedido.setEstado(crearPedido.getEstado());
        pedido.setCantidadProducto(crearPedido.getCantidadProducto());
        pedido.setLatitud(crearPedido.getLatitud());
        pedido.setLongitud(crearPedido.getLongitud());
        pedido.setCliente(clienteServicio.findById(crearPedido.getIdCliente()));
        pedido.setSucursal(sucursalServicio.findById(crearPedido.getIdSucursal()));
        //pedido.setFacturaDetalle(facturaDetalleServicio.findById(crearPedido.getIdFacturaDetalle()));
        pedido.setProducto(productoServicio.findById(crearPedido.getIdProducto()));
        pedidoServicio.save(pedido);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/pedidos")
    public ResponseEntity <List<Pedido>> getAllPedidos(){
        List<Pedido> pedidoList = pedidoServicio.findAll();
        return new ResponseEntity<List<Pedido>>(pedidoList, HttpStatus.OK);
    }
    @DeleteMapping("pedido/eliminar/{id}")
    public ResponseEntity<String> eliminarPedido(@PathVariable Long id){
        pedidoServicio.delete(id);
        return ResponseEntity.ok("ok");
    }

    @PutMapping("pedido/actualizar")
    public ResponseEntity<Pedido> actualizarPedidos(@RequestBody ActualizarPedido actualizarPedido){
        Optional<Pedido> pedidoOptional = pedidoServicio.findById(actualizarPedido.getId());
        if(pedidoOptional.isEmpty()){
            return  ResponseEntity.badRequest().build();
        }
        Pedido pedido =pedidoOptional.get();
        pedido.setLatitud(actualizarPedido.getLatitud());
        pedido.setLongitud(actualizarPedido.getLongitud());
        pedido.setEstado(actualizarPedido.getEstado());
        pedido.setCantidadProducto(actualizarPedido.getCantidadProducto());
        pedido.setCostoEnvio(actualizarPedido.getCostoEnvio());
        pedido.setCliente(clienteServicio.findById(actualizarPedido.getIdCliente()));
        pedido.setSucursal(sucursalServicio.findById(actualizarPedido.getIdSucursal()));
        pedido.setProducto(productoServicio.findById(actualizarPedido.getIdProducto()));
        pedidoServicio.save(pedido);
        return ResponseEntity.ok(pedido);
    }
}
