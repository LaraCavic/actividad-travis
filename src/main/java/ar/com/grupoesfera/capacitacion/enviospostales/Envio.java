package ar.edu.ge.meli;

import java.math.BigDecimal;
import java.util.List;

public class Envio {
    public List<Paquete> Paquetes;
    public double Costo;
    public String DireccionEntrega;
    public Vehiculo Transporte;

    public double getCosto() {
        return Costo;
    }

    public void setCosto(double costo) {
        Costo = costo;
    }
}
