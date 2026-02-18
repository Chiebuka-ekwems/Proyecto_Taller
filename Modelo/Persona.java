package Modelo;


/**
 * Write a description of class Persona here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Persona implements Comparable<Persona>
{
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private String email;
    private String telefono;
    
    private static final String CSV_FORMATO = "nombre;apellido1;apellido2;dni;email;telefono";
    
    public Persona(String nombre, String apellido1, String apellido2, String dni, String email, String telefono){
        this.nombre=nombre;
        this.apellido1=apellido1;
        this.apellido2=apellido2;
        this.dni=dni;
        this.email=email;
        this.telefono=telefono;
    }
    
    //Getters
    public String getNombre(){
        return nombre;
    }
    
    public String getApellido1(){
        return apellido1;
    }
    
    public String getApellido2(){
        return apellido2;
    }
    
    public String getDni(){
        return dni;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getTelefono(){
        return telefono;
    }
    
    
    //Setters
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setApellido1(String apellido1){
        this.apellido1=apellido1;
    }
    
    public void setApellido2(String apellido2){
        this.apellido2=apellido2;
    }
    
    public void setDni(String dni){
        this.dni=dni;
    }
    
    public void setEmail(String email){
        this.email=email;
    }
    
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
    
    
    @Override
    public String toString(){
        return this.nombre + ";"
        + this.apellido1 + ";"
        + this.apellido2 + ";"
        + this.dni + ";" 
        + this.email + ";"
        + this.telefono + ";";
    }
    
    public static String getCsvFormato(){
        return CSV_FORMATO;
    }
    
    @Override
    public int compareTo(Persona p){
        //Si quiero comparar por apellido si es igual, por apellido2 y si es igual por nombre 
        String misDatos = this.getApellido1() + this.getApellido2() + this.getNombre();
        String datosP = p.getApellido1() + p.getApellido2() + p.getNombre();
        
        return misDatos.compareTo(datosP);
        
        //return this.getApellido1().compareTo(p.getApellido1());
    }
}
