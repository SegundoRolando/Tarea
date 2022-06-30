package ec.edu.ups.BoscoMarketApi.controladores;

import ec.edu.ups.BoscoMarketApi.entidades.Categoria;
import ec.edu.ups.BoscoMarketApi.entidades.Producto;
import ec.edu.ups.BoscoMarketApi.entidades.Sucursal;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.Producto.CrearProducto;
import ec.edu.ups.BoscoMarketApi.repositorios.CategoriaRepositorio;
import ec.edu.ups.BoscoMarketApi.servicios.CategoriaServicio;
import ec.edu.ups.BoscoMarketApi.servicios.ProductoServicio;
import ec.edu.ups.BoscoMarketApi.servicios.SucursalServicio;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductoControlador {

    @Autowired
    @Setter
    private ProductoServicio productoServicio;

    @Autowired
    @Setter
    private SucursalServicio sucursalServicio;

    @Autowired
    @Setter
    private CategoriaServicio categoriaServicio;


    @PostMapping("/producto/create")
    public ResponseEntity<Producto> createProducto(@RequestBody CrearProducto crearProducto){

        Producto producto = new Producto();
        producto.setNombre(crearProducto.getNombre());
        producto.setPrecio(crearProducto.getPrecio());
        producto.setStock(crearProducto.getStock());
        producto.setDescripcion(crearProducto.getDescripcion());

        producto.setSucursal(sucursalServicio.findById(crearProducto.getIdSucursal()));
        producto.setCategoria(categoriaServicio.findCategoria(crearProducto.getIdCategoria()));
        productoServicio.save(producto);
        return ResponseEntity.ok(producto);
    }

    @GetMapping("categoria/{nombre}")
    public ResponseEntity<Categoria> getCategoriaProductoByNombre(@PathVariable String nombre){
        System.out.println(nombre);
        Categoria categoria = categoriaServicio.findCategoriaProductoByNombre(nombre);
        return ResponseEntity.ok(categoria);
    }
}
