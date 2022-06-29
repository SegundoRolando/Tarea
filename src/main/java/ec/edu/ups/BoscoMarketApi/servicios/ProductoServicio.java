package ec.edu.ups.BoscoMarketApi.servicios;

import ec.edu.ups.BoscoMarketApi.entidades.Producto;
import ec.edu.ups.BoscoMarketApi.entidades.Sucursal;
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

}
