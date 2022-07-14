package ec.edu.ups.BoscoMarketApi.controladores;

import ec.edu.ups.BoscoMarketApi.entidades.Cliente;
import ec.edu.ups.BoscoMarketApi.entidades.PagoTarjeta;
import ec.edu.ups.BoscoMarketApi.entidades.Usuario;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.Tarjeta.CrearTarjeta;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.Usuario.CrearUsuario;
import ec.edu.ups.BoscoMarketApi.servicios.ClienteServicio;
import ec.edu.ups.BoscoMarketApi.servicios.TarjetaServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class TarjetaControlador {
    @Autowired
    @Setter @Getter
    private TarjetaServicio tarjetaServicio;

    @Autowired
    @Setter @Getter
    private ClienteServicio clienteServicio;

    @PostMapping("/tarjeta/create")
    public ResponseEntity<PagoTarjeta> createTarjeta(@RequestBody CrearTarjeta crearTarjeta){

        Optional<Cliente> cliente = clienteServicio.findByCodigo(crearTarjeta.getCliente());
        if(cliente.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        PagoTarjeta tarjeta = new PagoTarjeta();
        tarjeta.setNumero(crearTarjeta.getNumero());
        tarjeta.setNombre(crearTarjeta.getNombre());
        tarjeta.setFecha(crearTarjeta.getFecha());
        tarjeta.setCliente(cliente.get());
        tarjetaServicio.save(tarjeta);
        return ResponseEntity.ok(tarjeta);
    }

    @DeleteMapping("/tarjeta/delete/{id}")
    public void delete(@PathVariable Long id) {
        PagoTarjeta tarjeta = this.tarjetaServicio.findById(id);
        this.tarjetaServicio.delete(tarjeta);
    }

    @PutMapping("/tarjeta/edit/{id}")
    public ResponseEntity <PagoTarjeta> update(@RequestBody CrearTarjeta crearTarjeta, @PathVariable Long id) {
        PagoTarjeta tarjeta = this.tarjetaServicio.findById(id);
        Optional<Cliente> cliente = clienteServicio.findByCodigo(crearTarjeta.getCliente());
        if(cliente.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        tarjeta.setNumero(crearTarjeta.getNumero());
        tarjeta.setNombre(crearTarjeta.getNombre());
        tarjeta.setFecha(crearTarjeta.getFecha());
        tarjeta.setCliente(cliente.get());
        this.tarjetaServicio.save(tarjeta);
        return ResponseEntity.ok(tarjeta);
    }
}
