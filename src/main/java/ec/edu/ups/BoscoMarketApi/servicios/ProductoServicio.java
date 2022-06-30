package ec.edu.ups.BoscoMarketApi.servicios;

import ec.edu.ups.BoscoMarketApi.entidades.Producto;
import ec.edu.ups.BoscoMarketApi.repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    public List<Producto> findAll(){
        return (List<Producto>) productoRepositorio.findAll();
    }

    public void save(Producto persona){
        productoRepositorio.save(persona);
    }

    public List<String> retrieveProductoBySucursal(Long codigo){
        return (List<String>) productoRepositorio.findProductoByCodigo(codigo);
    }

    public List<String> findProductoByCategoria(String nombre){
        return (List<String>) productoRepositorio.findProductoByCategoria(nombre);
    }

    public Producto findById(Long id) {
        return productoRepositorio.findById(id).orElse(null);
    }
}
