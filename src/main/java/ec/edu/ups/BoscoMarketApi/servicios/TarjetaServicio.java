package ec.edu.ups.BoscoMarketApi.servicios;

import ec.edu.ups.BoscoMarketApi.entidades.Cliente;
import ec.edu.ups.BoscoMarketApi.entidades.PagoTarjeta;
import ec.edu.ups.BoscoMarketApi.repositorios.ClienteRepositorio;
import ec.edu.ups.BoscoMarketApi.repositorios.TarjetaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarjetaServicio {
    @Autowired
    private TarjetaRepositorio tarjetaRepositorio;

    public void save(PagoTarjeta tarjeta){
        tarjetaRepositorio.save(tarjeta);
    }

    public List<PagoTarjeta> findAllTarjetas(){
        return (List<PagoTarjeta>) tarjetaRepositorio.findAll();
    }

    public PagoTarjeta findById(Long id){ return tarjetaRepositorio.findById(id).orElse(null);
    }
}
