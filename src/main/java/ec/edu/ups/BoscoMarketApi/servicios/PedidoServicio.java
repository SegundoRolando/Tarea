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
    }

    //Actualizar  Pedido
    public Optional<Pedido> findById(long id){
        return (Optional<Pedido>)  pedidoRepositorio.findById(id);
    }

    public List<Pedido> findAll(){
        return (List<Pedido>) pedidoRepositorio.findAll();
    }

    public void delete(Long id){
        pedidoRepositorio.deleteById(id);
    }

}
