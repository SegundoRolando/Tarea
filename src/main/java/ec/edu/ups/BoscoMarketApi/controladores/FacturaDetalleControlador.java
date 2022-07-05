package ec.edu.ups.BoscoMarketApi.controladores;

import ec.edu.ups.BoscoMarketApi.entidades.FacturaDetalle;
import ec.edu.ups.BoscoMarketApi.entidades.Pedido;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.FacturaDetalle.CrearFacturaDetalle;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.Pedido.CrearPedido;
import ec.edu.ups.BoscoMarketApi.servicios.FacturaDetalleServicio;
import ec.edu.ups.BoscoMarketApi.servicios.PedidoServicio;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class FacturaDetalleControlador {
    @Autowired
    @Setter
    private FacturaDetalleServicio facturaDetalleServicio;
    @Autowired
    @Setter
    private PedidoServicio pedidoServicio;

    @PostMapping("/facturaDetalle/create")
    public ResponseEntity<FacturaDetalle> createFacturaDetalle(@RequestBody CrearFacturaDetalle crearFacturaDetalle){
        FacturaDetalle  facturaDetalle = new FacturaDetalle();
        facturaDetalle.setCantidad(crearFacturaDetalle.getCantidad());
        facturaDetalle.setPrecio(crearFacturaDetalle.getPrecio());
        facturaDetalle.setDescripcion(crearFacturaDetalle.getDescripcion());
        facturaDetalle.setTotalXproducto(crearFacturaDetalle.getTotalXproducto());
        facturaDetalle.setPedido(pedidoServicio.findById(crearFacturaDetalle.getIdPedido()));
        facturaDetalleServicio.save(facturaDetalle);
        return ResponseEntity.ok(facturaDetalle);
    }

    @GetMapping("/lista")
    public ResponseEntity <List<FacturaDetalle>> getAllPedidos(){
        List<FacturaDetalle> facDet = facturaDetalleServicio.findAll();
        return new ResponseEntity<List<FacturaDetalle>>(facDet, HttpStatus.OK);
    }
}
