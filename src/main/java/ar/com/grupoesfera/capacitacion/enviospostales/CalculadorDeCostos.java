package ar.edu.ge.meli;

import java.math.BigDecimal;

public class CalculadorDeCostos {

    public double calcularCosto(int cantidadPaquetes) {
        if(cantidadPaquetes < 5)
            return 50.0;
        if(cantidadPaquetes < 10)
            return 80.0;
        return 15*cantidadPaquetes;
    }

}
