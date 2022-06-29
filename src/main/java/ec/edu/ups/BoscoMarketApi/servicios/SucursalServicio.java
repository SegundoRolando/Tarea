package ec.edu.ups.BoscoMarketApi.servicios;

import ec.edu.ups.BoscoMarketApi.entidades.Sucursal;
import ec.edu.ups.BoscoMarketApi.repositorios.SucursalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalServicio {
    @Autowired
    private SucursalRepositorio sucursalRepositorio;

    public Sucursal findById(Long id) {
        return sucursalRepositorio.findById(id).orElse(null);
    }

}
