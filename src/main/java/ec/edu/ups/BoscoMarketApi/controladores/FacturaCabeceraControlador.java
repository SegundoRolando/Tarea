package ec.edu.ups.BoscoMarketApi.controladores;

import ec.edu.ups.BoscoMarketApi.entidades.FacturaCabecera;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.FacturaCabecera.CrearFacturaCabecera;
import ec.edu.ups.BoscoMarketApi.servicios.ClienteServicio;
import ec.edu.ups.BoscoMarketApi.servicios.FacturaCabeceraServicio;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FacturaCabeceraControlador {
    @Autowired
    @Setter
    private FacturaCabeceraServicio facturaCabeceraServicio;

    @Autowired
    @Setter
    private ClienteServicio clienteServicio;

    @PostMapping("/FactCab/create")
    public ResponseEntity<FacturaCabecera> createFacturaCabecera(@RequestBody CrearFacturaCabecera crearFacturaCabecera){
        FacturaCabecera facturaCabecera = new FacturaCabecera();
        facturaCabecera.setFecha(crearFacturaCabecera.getFecha());
        facturaCabecera.setIva(crearFacturaCabecera.getIva());
        facturaCabecera.setSubtotal(crearFacturaCabecera.getSubtotal());
        facturaCabecera.setTotal(crearFacturaCabecera.getTotal());

        //facturaCabecera.setCliente(clienteServicio.findById(crearFacturaCabecera.getId()));
        facturaCabeceraServicio.save(facturaCabecera);
        return ResponseEntity.ok(facturaCabecera);
    }
}
