package ar.edu.ge.meli;

import java.math.BigDecimal;
import java.util.List;

public class Despachador {

    public CalculadorDeCostos calculadorDeCostos;
    public AsignadorDeVehiculos asignadorDeVehiculos;
    public int ContadorDeEnvios;

    public Despachador(){
        calculadorDeCostos = new CalculadorDeCostos();
        asignadorDeVehiculos = new AsignadorDeVehiculos();
        ContadorDeEnvios = 0;
    }

    public Despachador(CalculadorDeCostos calculador,
                       AsignadorDeVehiculos asignador){
        calculadorDeCostos = calculador;
        asignadorDeVehiculos = asignador;
        ContadorDeEnvios = 0;
    }

    public Envio generarEnvio(List<Paquete> paquetes, String direccion) throws Exception {
        Envio envio = new Envio();
        envio.Paquetes = paquetes;
        envio.Costo = calculadorDeCostos.calcularCosto(paquetes.size());
        envio.DireccionEntrega = direccion;
        try{
            envio.Transporte = asignadorDeVehiculos.obtenerTransporte(paquetes);
        }catch (Exception ex){
            throw ex;
        }
        if(ContadorDeEnvios > 10)
            envio.Costo = envio.getCosto() * 1.1;

        ContadorDeEnvios++;
        return envio;
    }
}
