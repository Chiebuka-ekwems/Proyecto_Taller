package Modelo;

import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Cliente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cliente extends Persona
{
    private int nVehiculos;
    private int codCliente;
    
    private List<Vehiculo> misVehiculos;
    private static final String CSV_FORMATO = "codCliente";
    
    public Cliente(String nombre,String apellido1, String apellido2, String dni, String email, String telefono, int codCliente){
        super(nombre, apellido1, apellido2, dni, email, telefono);
        this.codCliente=codCliente;
        misVehiculos= new ArrayList<Vehiculo>();
    }
    
    
    public int getCodigoCliente(){
        return codCliente;
    }
    
    
    
    
    //Crud vehiculos
    public void addVehiculo (Vehiculo v) {
        misVehiculos.add(v);
    }
    
    public boolean tengoVehiculo(String matricula){
        for(Vehiculo v: misVehiculos){
            if(v.getMatricula().equals(matricula)) return true;
        }
        return false;
    }
    
    public List<Vehiculo> getVehiculos(){
        return misVehiculos;
    }
    
    public List<Vehiculo> getVehiculoPorTipo(int tipo){
        List<Vehiculo> lista = new ArrayList<Vehiculo>();
        
        for(Vehiculo v :misVehiculos){
            //| 1-Moto | 2-Coche | 3-Camion | 4-Furgon |
            switch(tipo){
                case 1: 
                    if (v instanceof Moto) lista.add(v);
                    break;
                case 2:
                    if (v instanceof Coche) lista.add(v);
                    break;
                case 3:
                    if (v instanceof Camion) lista.add(v);
                    break;
                case 4:
                    if (v instanceof Furgon) lista.add(v);
                    break;
            }
        }
        
        return lista;
    }
    
    //borrar un vehiculo
    
    @Override
    public String toString(){
        return super.toString()
        + this.codCliente +";";
    }
    
    
    //No se pone override porque es un metodo estatico
    public static String getCsvFormato(){
        return Persona.getCsvFormato() + ";" + Cliente.CSV_FORMATO;
    }
    
    @Override
    public int compareTo(Persona p){
        if (p instanceof Cliente){
            int codCliente1 = this.getCodigoCliente();
            int codCliente2 = ((Cliente)p).getCodigoCliente();
        
            if (codCliente1 - codCliente2 == 0) return 0;
            else if (codCliente1 - codCliente2 < 0) return -1;
            else return 1;
            
        } else return super.compareTo(p);
        
        
    }
    
    /*Preguntar a gemini sobre este metodo
     * @Override
     * public int compareTo(Persona p){
        if (p instanceof Cliente){
            Integer c1 = new Integer(this.getCodCliente());
            Integer c2 = new Integer(((Cliente)p).getCodCliente());
            return c1.compareTo(c2);
            
        } else return super.compareTo(p);
           
    }
     * 
       */
}
