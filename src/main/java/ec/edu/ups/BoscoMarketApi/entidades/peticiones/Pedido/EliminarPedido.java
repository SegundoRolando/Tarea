package ec.edu.ups.BoscoMarketApi.entidades.peticiones.Pedido;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class EliminarPedido {
    @JsonProperty
    @Getter @Setter
    private double latitud;
    @JsonProperty
    @Getter @Setter
    private double longitud;
    @JsonProperty
    @Getter @Setter
    private String estado;
    @Getter @Setter
    @JsonProperty
    private int cantidadProducto;
    @JsonProperty
    @Getter @Setter
    private double costoEnvio;
    @JsonProperty
    @Getter @Setter
    private Long idCliente;
    @JsonProperty
    @Getter @Setter
    private Long idSucursal;
    @JsonProperty
    @Getter @Setter
    private Long idFacturaDetalle;
    @JsonProperty
    @Getter @Setter
    private Long idProducto;

    public EliminarPedido(){
    }
}