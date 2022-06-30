package ec.edu.ups.BoscoMarketApi.repositorios;

import ec.edu.ups.BoscoMarketApi.entidades.Sucursal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SucursalRepositorio extends CrudRepository<Sucursal, Long> {

}
