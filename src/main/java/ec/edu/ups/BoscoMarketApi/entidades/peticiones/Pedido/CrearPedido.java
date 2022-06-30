package ec.edu.ups.BoscoMarketApi.entidades.peticiones.Pedido;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class CrearPedido {
    @JsonProperty
    @Getter @Setter
    private double latitud;
    @JsonProperty
    @Getter @Setter
    private double longitud;
    @JsonProperty
    @Getter @Setter
    private String estado;
    @JsonProperty
    @Getter @Setter
    private double costoEnvio;
    @JsonProperty
    @Getter @Setter
    private Long sucursal;
    @JsonProperty
    @Getter @Setter
    private Long facturaCabecera;
    @JsonProperty
    @Getter @Setter
    private Long producto;

    public CrearPedido(){

    }
}
