package ar.edu.ge.meli;


import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class TestDespachador {

    @Test(expected = UnsendableShipmentException.class)
    public void testEnvioConExcesoDePeso() throws Exception {

        Despachador despachador = new Despachador();
        List<Paquete> paquetes = Arrays.asList(
                new Paquete(100),
                new Paquete(30),
                new Paquete(40)
        );

        Envio e = despachador.generarEnvio(paquetes,"Av SiempreViva 123");
        assertThat(e.getCosto()).isEqualTo(50);
    }

    @Test
    public void testEnvioPosibleConBiciConMocks() throws Exception {

        CalculadorDeCostos calculador = mock( CalculadorDeCostos.class);
        AsignadorDeVehiculos asignador = mock( AsignadorDeVehiculos.class);
        List<Paquete> paquetes = Arrays.asList(
                new Paquete(1),
                new Paquete(2)
        );

        Despachador despachador = new Despachador(calculador,asignador);

        //doReturn(50).when(calculador).calcularCosto(2);
        //doReturn(new Bicicleta()).when(asignador).obtenerTransporte(paquetes);
        when(calculador.calcularCosto(eq(2))).thenReturn(50D);
        when(asignador.obtenerTransporte(paquetes)).thenReturn(new Bicicleta());

        Envio e = despachador.generarEnvio(paquetes,"Av SiempreViva 123");
        assertThat(e.getCosto()).isEqualTo(50);
    }

    @Test
    public void testEnvioPosibleConBici() throws Exception {

        Despachador despachador = new Despachador();
        List<Paquete> paquetes = Arrays.asList(
                new Paquete(1),
                new Paquete(2)
        );

        Envio e = despachador.generarEnvio(paquetes,"Av SiempreViva 123");
        assertThat(e.getCosto()).isEqualTo(50);
    }

    @Test
    public void testEnvioPosibleConAuto() throws Exception {

        Despachador despachador = new Despachador();
        List<Paquete> paquetes = Arrays.asList(
                new Paquete(10),
                new Paquete(10),
                new Paquete(11)
        );

        Envio e = despachador.generarEnvio(paquetes,"Av SiempreViva 123");
        assertThat(e.getCosto()).isEqualTo(50);
    }

    @Test
    public void testEnvioPosibleConCamioneta() throws Exception {

        Despachador despachador = new Despachador();
        List<Paquete> paquetes = Arrays.asList(
                new Paquete(10),
                new Paquete(20),
                new Paquete(30)
        );

        Envio e = despachador.generarEnvio(paquetes,"Av SiempreViva 123");
        assertThat(e.getCosto()).isEqualTo(50);
    }

}