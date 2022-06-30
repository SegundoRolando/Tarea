package ec.edu.ups.BoscoMarketApi.controladores;

import ec.edu.ups.BoscoMarketApi.entidades.PagoTarjeta;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.Tarjeta.CrearTarjeta;
import ec.edu.ups.BoscoMarketApi.servicios.TarjetaServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TarjetaControlador {
    @Autowired
    @Setter @Getter
    private TarjetaServicio tarjetaServicio;

    @PostMapping("/tarjeta/create")
    public ResponseEntity<PagoTarjeta> createTarjeta(@RequestBody CrearTarjeta crearTarjeta){

        PagoTarjeta tarjeta = new PagoTarjeta();
        tarjeta.setNumero(crearTarjeta.getNumero());
        tarjeta.setNombre(crearTarjeta.getNombre());
        tarjetaServicio.save(tarjeta);
        return ResponseEntity.ok(tarjeta);
    }
}
