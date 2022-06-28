package ec.edu.ups.BoscoMarketApi.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Sucursal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String direccion;
    private String telefono;
    private String latitud;
    private String altitud;

    public Sucursal(){
    }

    public Sucursal(Long id, String name, String direccion, String telefono, String latitud, String altitud) {
        this.id = id;
        this.name = name;
        this.direccion = direccion;
        this.telefono = telefono;
        this.latitud = latitud;
        this.altitud = altitud;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getAltitud() {
        return altitud;
    }

    public void setAltitud(String altitud) {
        this.altitud = altitud;
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", latitud='" + latitud + '\'' +
                ", altitud='" + altitud + '\'' +
                '}';
    }
}
