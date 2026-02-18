package Modelo;
import java.util.List;
import java.util.ArrayList;


public abstract class Vehiculo
{
    private String matricula;
    private String modelo;
    
    //Apartir de aqui borrar en el futuro porque ya esta puesto en cliente y trabajoTaller
    /*private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni; */
    private String fechaEntrada;
    private String horaEntrada;
    private static final String CSV_FORMATO = "matricula;modelo;fechaEntrada;horaEntrada";
    
    //implementar la relación agregación para ir desde el muchos al 1 (vehiculo ya sabe quien es el dueño)
    private Cliente dueno;
    
    //Implementar relacion 1 vehiculo muchis trabajos
    private List<TrabajoTaller> misTrabajos;
    
    
    public Vehiculo(String matricula, String modelo, String fechaEntrada, String horaEntrada, Cliente dueno){
        this.matricula=matricula;
        this.modelo=modelo;
        this.fechaEntrada=fechaEntrada;
        this.horaEntrada=horaEntrada;
        this.dueno=dueno;
        
        misTrabajos = new ArrayList<TrabajoTaller>();
    }
    
    //Getters
    public Cliente getCliente(){
        return dueno;
    }
    
    
    public String getMatricula(){
        return matricula;
    }
    
    public String getModelo(){
        return modelo;
    }
    
    
    public String getFechaEntrada(){
        return fechaEntrada;
    }
    
    public String getHoraEntrada(){
        return horaEntrada;
    }
    
    
    //CRUD Trabajos
    public boolean addTrabajoTaller(TrabajoTaller tt){
        if(tt!=null){
            misTrabajos.add(tt);
            return true;
        }
        return false;
    }
    
    //Setters
    public void setMatricula(String matricula){
        this.matricula=matricula;
    }
    
    public void setModelo(String modelo){
        this.modelo=modelo;
    }
    
    
    public void setFechaEntrada(String fechaEntrada){
        this.fechaEntrada=fechaEntrada;
    }
    
    
    public void setHoraEntrada(String horaEntrada){
        this.horaEntrada=horaEntrada;
    }
    
    public abstract double getPrecio();
    
    @Override
    public String toString(){
        return this.matricula + ";"
        + this.modelo + ";"
        + this.fechaEntrada + ";"
        + this.horaEntrada + ";";
    }
    
    public static String getCsvFormato(){
        return CSV_FORMATO;
    }
}
