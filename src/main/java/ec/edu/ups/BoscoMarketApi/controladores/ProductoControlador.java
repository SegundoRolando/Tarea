package ec.edu.ups.BoscoMarketApi.controladores;

import ec.edu.ups.BoscoMarketApi.entidades.Producto;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.Producto.CrearProducto;
import ec.edu.ups.BoscoMarketApi.servicios.ProductoServicio;
import ec.edu.ups.BoscoMarketApi.servicios.SucursalServicio;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoControlador {

    @Autowired
    @Setter
    private ProductoServicio productoServicio;

    @Autowired
    @Setter
    private SucursalServicio sucursalServicio;

    @PostMapping("/producto/create")
    public ResponseEntity<Producto> createProducto(@RequestBody CrearProducto crearProducto){

        Producto producto = new Producto();
        producto.setNombre(crearProducto.getNombre());
        producto.setPrecio(crearProducto.getPrecio());
        producto.setStock(crearProducto.getStock());
        producto.setDescripcion(crearProducto.getDescripcion());

        producto.setSucursal(sucursalServicio.findById(crearProducto.getId()));
        productoServicio.save(producto);
        return ResponseEntity.ok(producto);
    }

    @GetMapping("prodXsucursal/{codigo}")
    public ResponseEntity<List<String>> getProductosBySucursal(@PathVariable Long codigo){
        List<String> productos = productoServicio.retrieveProductoBySucursal(codigo);
        return new ResponseEntity<List<String>>(productos, HttpStatus.OK);
        //
    }
}
