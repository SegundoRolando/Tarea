package ec.edu.ups.BoscoMarketApi.repositorios;

import ec.edu.ups.BoscoMarketApi.entidades.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoRepositorio extends CrudRepository<Producto, Long> {

    @Query("SELECT p from Producto p")
    List<String> findProductos();

    @Query("SELECT p FROM Producto p where p.sucursal.id = :codigo")
    List<Producto> findProductoByCodigo(Long codigo);

    @Query("SELECT p FROM Producto p where p.categoria.nombre = :nombre")
    List<Producto> findProductoByCategoria(String nombre);

    @Query("SELECT p.precio FROM Producto p where p.id = :codigo")
    Double precioByID(Long codigo);
}
