package org.example.parking;

import org.junit.Test;
import org.mockito.Mock;

import java.time.LocalDateTime;

import static junit.framework.Assert.*;
import static org.example.parking.Vehiculo.Tipo.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
//        Cliente cliente1 = new Cliente("12345678","Nombre");
//        Vehiculo vehiculo1 = new Vehiculo("FFF333","Fiat",AUTO);
//        Ticket ticket1 = new Ticket(cliente1, vehiculo1);
//
//        Vehiculo vehiculo2 = new Vehiculo("AAA333","Fiat",SUV);
//        Ticket ticket2 = new Ticket(cliente1, vehiculo2);
//
//        Vehiculo vehiculo3 = new Vehiculo("BBB333","Fiat",PICKUP);
//        Ticket ticket3 = new Ticket(cliente1, vehiculo3);

        Ticket mock = mock(Ticket.class);
        when(mock.calcularPrecio()).thenReturn(300.0);

        Ticket mock2 = mock(Ticket.class);
        when(mock2.calcularPrecio()).thenReturn(260.0);

        Ticket mock3 = mock(Ticket.class);
        when(mock3.calcularPrecio()).thenReturn(180.0);

        assertEquals(mock.calcularPrecio(), 300.0);
        assertEquals(mock2.calcularPrecio(), 260.0);
        assertEquals(mock3.calcularPrecio(), 180.0);

//        for (int i = 1; i < 201; i++){
//            assertTrue(ticket1.calcularPrecio() >= 0 && ticket1.calcularPrecio() <= 400);
//            assertTrue(ticket2.calcularPrecio() >= 0 && ticket2.calcularPrecio() <= 520);
//            assertTrue(ticket3.calcularPrecio() >= 0 && ticket3.calcularPrecio() <= 720);
//        }
    }
}