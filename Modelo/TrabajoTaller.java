package Modelo;

import java.util.List;
import java.util.ArrayList;

public class TrabajoTaller
{
    private String descripcion;
    private String solucionPrevista;
    private String fechaEntrada;
    private String horaEntrada;
    private double horasPrevistas;
    //Habria que quitar las horas reales de los parametros del constructor e inicializarlo a 0 dentro del constructor al iguak qye cobrado
    private double horasReales;
    private boolean cobrado;
    private List<Vehiculo> misVehiculos;
    
    //Temporal
    private Vehiculo v;
    private Cliente dueno;
    
    //CSV
    private static final String CSV_FORMATO = "descripcion;fechaEntrada;horaEntrada;Cliente;Vehiculo;Cobrado";
    
    public TrabajoTaller(String descripcion, double horasPrevistas, String fechaEntrada,String horaEntrada, Cliente c, Vehiculo v){
        this.descripcion=descripcion;
        solucionPrevista="";
        this.horasPrevistas=horasPrevistas;
        this.horaEntrada=horaEntrada;
        horasReales=0;
        cobrado=false;
        misVehiculos= new ArrayList<Vehiculo>();
        this.dueno=c;
        this.v=v;        
    }
    
    public static String getCsvFormato(){
        return CSV_FORMATO;
    }
    
    
    //Terminar este toString para este TrabajoTaller
    @Override
    public String toString(){
        return this.descripcion + ";"
        + this.fechaEntrada + ";"
        + this.horaEntrada + ";" 
        + this.v.getCliente().getNombre() + ";"
        + this.v.getMatricula() + ";"
        + this.cobrado + ";";
    }
    
    //Getters
    public String getDescripcion(){
        return descripcion;
    }
    
    public String getSolucionPrevista(){
        return solucionPrevista;
    }
    
    public String getFechaEntrada(){
        return fechaEntrada;
    }
    
    public String getHoraEntrada(){
        return horaEntrada;
    }
    
    public double getHorasPrevistas(){
        return horasPrevistas;
    }
    
    
    public double getHorasReales(){
        return horasReales;
    }
    
    public boolean getCobrado(){
        return cobrado;
    }
    
    //Setters
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    
    public void setSolucionPrevista(String solucionPrevista){
        this.solucionPrevista=solucionPrevista;
    }
    
    public void setFechaEntrada(String fechaEntrada){
        this.fechaEntrada=fechaEntrada;
    }
    
    public void setHoraEntrada(String horaEntrada){
        this.horaEntrada=horaEntrada;
    }
    
    public void setHorasPrevistas(double horasPrevistas){
        this.horasPrevistas=horasPrevistas;
    }
    
    public void setHorasReales(double horasReales){
        this.horasReales=horasReales;
    }
    
    public void setCobrado(boolean cobrado){
        this.cobrado=cobrado;
    }
}
