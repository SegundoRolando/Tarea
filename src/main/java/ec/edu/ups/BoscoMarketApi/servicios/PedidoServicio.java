package ec.edu.ups.BoscoMarketApi.servicios;

import ec.edu.ups.BoscoMarketApi.entidades.Pedido;
import ec.edu.ups.BoscoMarketApi.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicio {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    //Guaradar pedido
    public void save(Pedido pedido){
        pedidoRepositorio.save(pedido);
    }/*
    public void actualizaCantidad(Pedido pedido, Long id){
        pedidoRepositorio.actualizarStock(id);
    }*/


    //Actualizar  Pedido
    /*
    public Optional<Pedido> findById(long id){
        return (Optional<Pedido>)  pedidoRepositorio.findById(id);
    }*/
    public Pedido findById(Long id){ return pedidoRepositorio.findById(id).orElse(null);
    }

    public List<Pedido> findAll(){
        return (List<Pedido>) pedidoRepositorio.findAll();
    }

    public void delete(Long id){
        pedidoRepositorio.deleteById(id);
    }
    public Optional<Pedido> findByCodigo(Long codigo){
        return (Optional<Pedido>) pedidoRepositorio.findById(codigo);
    }

    public Long obtenerID(Double latitud){
        return pedidoRepositorio.obtenerID(latitud);
    }

}
