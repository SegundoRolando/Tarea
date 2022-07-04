package ec.edu.ups.BoscoMarketApi.controladores;

import ec.edu.ups.BoscoMarketApi.servicios.FacturaDetalleServicio;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

public class FacturaDetalleControlador {
    @Autowired
    @Setter
    private FacturaDetalleServicio facturaDetalleServicio;
}
