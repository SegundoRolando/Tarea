package ec.edu.ups.BoscoMarketApi.repositorios;

import ec.edu.ups.BoscoMarketApi.entidades.PagoTarjeta;
import org.springframework.data.repository.CrudRepository;

public interface TarjetaRepositorio extends CrudRepository<PagoTarjeta, Long> {
}
