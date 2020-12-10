package ar.edu.ge.meli;

import java.util.List;

public class AsignadorDeVehiculos {

    public Vehiculo obtenerTransporte(List<Paquete> paquetes) throws Exception {

        double pesoTotal =
                paquetes.stream()
                        .mapToDouble(p -> p.Peso)
                        .sum();

        if(pesoTotal <= 5)
            return new Bicicleta();
        if(pesoTotal <= 50)
            return new Auto();
        if(pesoTotal > 50 && pesoTotal <= 150)
            return new Camioneta();

        throw new UnsendableShipmentException("No se puede despachar este envio por exceso de peso");
    }
}
