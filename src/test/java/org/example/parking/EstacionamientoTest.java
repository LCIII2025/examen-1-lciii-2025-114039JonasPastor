package org.example.parking;

import org.junit.Test;

import java.time.LocalDateTime;

import static junit.framework.Assert.*;
import static org.example.parking.Vehiculo.Tipo.AUTO;
import static org.example.parking.Vehiculo.Tipo.PICKUP;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
        //TODO test
        Cliente cliente = new Cliente("12345678","Nombre");
        Vehiculo vehiculo = new Vehiculo("FFF333","Fiat",AUTO);
        cliente.agregarVehiculo(vehiculo);
        Ticket ticket = new Ticket(cliente, vehiculo);

        Estacionamiento estacionamiento = new Estacionamiento();

        Vehiculo testVehiculo = new Vehiculo("FFF333","Fiat",AUTO);
        estacionamiento.ingresarVehiculo("12345678","Nombre",testVehiculo);
        Ticket testTicket = estacionamiento.retirarVehiculo("FFF333");

        Vehiculo testVehiculo2 = new Vehiculo("PPP444","Toyota",PICKUP);
        estacionamiento.ingresarVehiculo("12345678","Nombre",testVehiculo2);
        Ticket testTicket2 = estacionamiento.retirarVehiculo("PPP444");

        assertEquals(testTicket.getVehiculo(), ticket.getVehiculo());
        assertNotSame(testTicket2.getVehiculo(), ticket.getVehiculo());
    }

    @Test
    public void testCalcularPrecio() throws Exception {
        // TODO test
        Cliente cliente = new Cliente("12345678","Nombre");
        Vehiculo vehiculo = new Vehiculo("FFF333","Fiat",AUTO);
        Ticket ticket = new Ticket(cliente, vehiculo);

        for (int i = 1; i < 201; i++){
            ticket.calcularPrecio();
            assertTrue(ticket.calcularPrecio() >= 0 && ticket.calcularPrecio() <= 20100);
        }
    }

}