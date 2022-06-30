package ec.edu.ups.BoscoMarketApi.controladores;

import ec.edu.ups.BoscoMarketApi.entidades.Cliente;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.Cliente.CrearCliente;
import ec.edu.ups.BoscoMarketApi.servicios.ClienteServicio;
import ec.edu.ups.BoscoMarketApi.servicios.UsuarioServicio;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteControlador {
    @Autowired
    @Setter
    private ClienteServicio clienteServicio;

    @Autowired
    @Setter
    private UsuarioServicio usuarioServicio;

    @PostMapping("/cliente/create")
    public ResponseEntity<Cliente> createCliente(@RequestBody CrearCliente crearCliente){

        Cliente cliente = new Cliente();
        cliente.setNombre(crearCliente.getNombre());
        cliente.setCedula(crearCliente.getCedula());
        cliente.setApellido(crearCliente.getApellido());
        cliente.setTelefono(crearCliente.getTelefono());
        cliente.setCorreo(crearCliente.getCorreo());
        cliente.setDireccion(crearCliente.getDireccion());
        clienteServicio.save(cliente);
        return ResponseEntity.ok(cliente);
    }
}
