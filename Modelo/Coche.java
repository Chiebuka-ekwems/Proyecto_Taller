package Modelo;


public class Coche extends Vehiculo
{
    private static final double precioHora=25;
    
    public Coche(String matricula, String modelo, String fechaEntrada, String horaEntrada, Cliente dueno){
        super(matricula, modelo,fechaEntrada,horaEntrada, dueno);        
    }
    
    //Getters
    public double getPrecioHora(){
        return precioHora;
    }
    
    //Setters
    //Siempre va a ser 25
    
    
    //metodo getPrecio
    @Override
    public double getPrecio(){
        return precioHora;
    }
}
