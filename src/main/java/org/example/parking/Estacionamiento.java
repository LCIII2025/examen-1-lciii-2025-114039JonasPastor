package org.example.parking;

import java.time.LocalDateTime;
import java.util.*;

public class Estacionamiento {
    private final int capacidadMaxima = 50;
    private final Map<String, Ticket> vehiculosEstacionados = new HashMap<>();
    private final Map<String, Cliente> clientesRegistrados = new HashMap<>();

    public boolean ingresarVehiculo(String dni, String nombre, Vehiculo vehiculo) {
        // -TODO implementar la logica para registrar el ingreso de un nuevo vehiculo en el parking
        // -la capacidad maxima del estacionamiento es de 50 vehiculos, si supera esta cap[acidad retornar FALSE
        // -validar que no exista otro vehiculo con la misma patente, es un caso de error, retornar FALSE
        // -validar si existe el cliente registrado, agregar el nuevo vehiculo en la lista del cliente existente, caso contrario crear un nuevo registro
        // si el proceso es exitoso retornar TRUE

        boolean ok = true;

        if(vehiculosEstacionados.size() > capacidadMaxima) {
            ok = false;
        }

        if(vehiculosEstacionados.containsKey(vehiculo.getPatente())) {
            ok = false;
        }

        if(clientesRegistrados.containsKey(dni)){
            clientesRegistrados.get(dni).agregarVehiculo(vehiculo);
            Ticket ticket = new Ticket(clientesRegistrados.get(dni), vehiculo);
            vehiculosEstacionados.put(vehiculo.getPatente(), ticket);
        } else{
            Cliente cliente = new Cliente(dni, nombre);
            cliente.agregarVehiculo(vehiculo);
            clientesRegistrados.put(dni,cliente);
            Ticket ticket = new Ticket(clientesRegistrados.get(dni), vehiculo);
            vehiculosEstacionados.put(vehiculo.getPatente(), ticket);
        }

        return ok;
    }

    public Ticket retirarVehiculo(String patente) throws Exception {
        // -TODO implementar la lógica para retirar un vehiculo del parking
        // -validar que exista la patente, caso contrario arrojar la exception "Vehiculo no encontrado"
        // -calcular y retornar el ticket del vehiculoEstacionado (ver Ticket.marcarSalida())
        if(!vehiculosEstacionados.containsKey(patente)){
            throw new Exception("Vehiculo no encontrado");
        }
        Ticket t = vehiculosEstacionados.get(patente);
        t.marcarSalida();
        vehiculosEstacionados.remove(patente);
        return t;
    }

    public List<Ticket> listarVehiculosEstacionados() {
        return new ArrayList<>(vehiculosEstacionados.values());
    }
}
