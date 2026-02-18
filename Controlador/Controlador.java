package Controlador;
import java.util.List;
import Modelo.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Write a description of class Controlador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controlador
{
    private static Controlador singleton; //solteron
    
    private List <Cliente> misClientes;
    private List <Mecanico> misMecanicos;
    
    private Controlador() {
        misClientes = new ArrayList<Cliente>();
        misMecanicos = new ArrayList<Mecanico>();
    }
    
    public static Controlador getSingleton() {
        if(singleton == null) singleton = new Controlador();
        return singleton;
    }
    
    //Crud Cliente
    public String listarClientesPorApellido(String apellido){
        String resultado="";
        for(Cliente c: misClientes) {
            if(c.getApellido1().equals(apellido)) {
                resultado += c.toString() + "\n";
            }
        }
        return Cliente.getCsvFormato() + "\n" + resultado;
    }
    
    public String listarPersonas(){
        String resultado="";
        
        List<Persona> misPersonas = new ArrayList<Persona>();
        
        for (Cliente c : misClientes){
            misPersonas.add(c);
        }
        
        for (Mecanico m : misMecanicos){
            misPersonas.add(m);
        }
        
        Persona[] miArrayOrdenado = misPersonas.toArray(new Persona[0]);
        
        
        //Voy a ordenar
        Arrays.sort(miArrayOrdenado);
        for(Persona p: miArrayOrdenado) {
             
            resultado += p.toString() + "\n";
            
        }
        return Cliente.getCsvFormato() + "\n" + resultado;
    }
    
    public String listarClientes(){
        String resultado="";
        
        Cliente [] miArrayOrdenado = misClientes.toArray(new Cliente[0]);
        
        //Voy a ordenar
        Arrays.sort(miArrayOrdenado);
        for(Cliente c: miArrayOrdenado) {
             
            resultado += c.toString() + "\n";
            
        }
        return Cliente.getCsvFormato() + "\n" + resultado;
    }
    
    public boolean addCliente (String csvCliente){
        String[] datos = csvCliente.split(";");
        
        Cliente c = new Cliente(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],Integer.parseInt(datos[6]));
        for(Cliente cliente: misClientes){
            if(cliente.getDni().equals(c.getDni())) return false;
        }
        misClientes.add(c);
        return true;
    }
    
    public Cliente getClientePorDni(String dni){
        for(Cliente c: misClientes){
            if(c.getDni().equals(dni)) return c;
        }
        return null;
    }
    
    //Crud Mecanico
    public String listarMecanicosPorApellido(String apellido){
        String resultado="";
        for(Mecanico m: misMecanicos) {
            if(m.getApellido1().equals(apellido)) {
                resultado += m.toString() + "\n";
            }
        }
        return Mecanico.getCsvFormato() + "\n" + resultado;
    }
    
    public String listarMecanicos(){
        String resultado="";
        for(Mecanico m: misMecanicos) {
             
            resultado += m.toString() + "\n";
            
        }
        return Mecanico.getCsvFormato() + "\n" + resultado;
    }
    
    public boolean addMecanico (String csvMecanico){
        String[] datos = csvMecanico.split(";");
        
        Mecanico m = new Mecanico(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],Integer.parseInt(datos[6]));
        for(Mecanico mecanico: misMecanicos){
            if(mecanico.getDni().equals(mecanico.getDni())) return false;
        }
        misMecanicos.add(m);
        return true;
    }
    
    public Mecanico getMecanicoPorDni(String dni){
        for(Mecanico m: misMecanicos){
            if(m.getDni().equals(dni)) return m;
        }
        return null;
    }
    
    //Crud Vehiculo
    public boolean addVehiculo (String csvVehiculo, String dniDueno, int tipoVehi){
        String[] datos = csvVehiculo.split(";");
        Vehiculo v = null;
        Cliente dueno = getClientePorDni(dniDueno);
        if(dueno==null){
            return false;
        }
        if (dueno.tengoVehiculo(datos[0])) {
            return false; 
        }
        //1-Moto | 2-Coche | 3-Camion | 4-Furgon
        switch(tipoVehi){
            case 1:
                 v = new Moto(datos[0],datos[1],datos[2],datos[3],dueno);
                break;
            case 2:
                v = new Coche(datos[0],datos[1],datos[2],datos[3],dueno);
                break;
            case 3:
                v = new Camion(datos[0],datos[1],datos[2],datos[3],dueno);
                break;
            case 4:
                v = new Furgon(datos[0],datos[1],datos[2],datos[3],dueno);
                break;
            
        }
        
        if (v!=null){
            dueno.addVehiculo(v);
            return true;
        }
        
        return false;
        
    }
    
    public String listarVehiculos(){
        String resultado="";
        for(Cliente c: misClientes) {
            
            for(Vehiculo v: c.getVehiculos()){
                resultado += v.toString() + "\n";
            }
                        
        }
        return Vehiculo.getCsvFormato() + "\n" + resultado;
    }
    
    public Vehiculo getVehiculoPorMatricula(String matricula){
        for(Cliente c: misClientes){
            for(Vehiculo v: c.getVehiculos()){
                if (v.getMatricula().equals(matricula)) return v;
            }
        }
        return null;
    }
    
    public String listarVehiculoTipo(int tipo){
        String resultado="";
        
        for(Cliente c : misClientes){
            List<Vehiculo> result = c.getVehiculoPorTipo(tipo);
            for (Vehiculo v: result){
                resultado+=v.toString() + "\n";
            }
        }
        
        return resultado;
    }
    
    //Crud Trabajo
    //Es mejor pasar un solo parametro csv y hacerle split cambiar a futuro
    public boolean addTrabajo (String dniMecanico, String matriculaVehi, String description, double horasPrevistas, String fechaEntrada, String horaEntrada){
        //Error de diseño pedir dni de cliente porque se puede sacar vehiculo borrar en el futuro.
        //Cliente dueno = getClientePorDni(dniCliente);
        
        //Hace falta asignarle un mecanico y añadirle el trabajo una vez creado a su propia lista
        //Terminar este metodo 
        Mecanico m = getMecanicoPorDni(dniMecanico);
        
        Vehiculo vCliente = getVehiculoPorMatricula(matriculaVehi);
        
        if(m!=null && vCliente!=null){
            //El mecanico es el que se encarga de crear el trabajo taller esto hay que cambiarlo 
            m.addTrabajoTaller(vCliente, description,fechaEntrada,horaEntrada, horasPrevistas);
        } else{
            return false;
        }
        /*for(Cliente cliente: misClientes){
            if(cliente.getDni().equals(c.getDni())) return false;
        }
        misClientes.add(c);*/
        return true;
    }
    
    public String listarTrabajosNoPagados(){
        String resultado="";
        
        for(Mecanico m : misMecanicos){
            for(TrabajoTaller j: m.getTrabajos()){
                if(j.getCobrado()==false){
                    resultado += j.toString() + "\n";
                }
            }
        }
        //Solucionar error con resultado
        return TrabajoTaller.getCsvFormato() + "\n" + resultado;
        
    }
    /*
     * public boolean addCliente (String csvCliente){
        String[] datos = csvCliente.split(";");
        
        Cliente c = new Cliente(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],Integer.parseInt(datos[6]));
        for(Cliente cliente: misClientes){
            if(cliente.getDni().equals(c.getDni())) return false;
        }
        misClientes.add(c);
        return true;
    }
       */
}
