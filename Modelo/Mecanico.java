package Modelo;

import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Cliente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mecanico extends Persona
{
    private int nVehiculos;
    private int codMecanico;
    
    private List<Vehiculo> misVehiculos;
    private List<TrabajoTaller> misTrabajos;
    
    private static final String CSV_FORMATO = "codMecanico";
    
    public Mecanico(String nombre, String apellido1, String apellido2, String dni, String email, String telefono, int codMecanico){
        super(nombre, apellido1, apellido2, dni, email, telefono);
        this.codMecanico=codMecanico;
        misVehiculos= new ArrayList<Vehiculo>();
        misTrabajos= new ArrayList<TrabajoTaller>();
    }
    
    //Getters
    public int getNVehiculos(){
        return nVehiculos;
    }
    
    public int getCodMecanico(){
        return codMecanico;
    }
    
    public List<TrabajoTaller> getTrabajos(){
        return misTrabajos;
    }
    
    //Setters
    public void setNVehiculos(int nVehiculos){
        this.nVehiculos=nVehiculos;
    }
    
    //La solucion prevista sera algo que se le añadira mas adelante
    public void addTrabajoTaller (Vehiculo v,String diagnostico /*String solucionPrevista*/, String fechaEntrada,String horaEntrada, double horasPrevistas){
        Cliente c = v.getCliente();
        TrabajoTaller tt = new TrabajoTaller(diagnostico,  horasPrevistas, fechaEntrada,horaEntrada, c, v);
        misTrabajos.add(tt);
        v.addTrabajoTaller(tt);
    }
    
    @Override
    public String toString(){
        return super.toString()
        + this.codMecanico +";";
    }
    
    
    //No se pone override porque es un metodo estatico
    public static String getCsvFormato(){
        return Persona.getCsvFormato() + ";" + Mecanico.CSV_FORMATO;
    }
}
