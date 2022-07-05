package ec.edu.ups.BoscoMarketApi.repositorios;

import ec.edu.ups.BoscoMarketApi.entidades.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public  interface PedidoRepositorio extends CrudRepository<Pedido, Long> {
/*
    @Query("UPDATE producto, pedido SET producto.stock = producto.stock-pedido.cantidad_producto WHERE (pedido.producto_id=producto.id);")
    String actualizarStock(Long id);*/

    @Query("SELECT p.id FROM Pedido p where p.latitud = :latitud")
    Long obtenerID(Double latitud);
}
