package Modelo;


public class Moto extends Vehiculo
{
    private static final double precioHora=20;
    
    public Moto(String matricula, String modelo, String fechaEntrada, String horaEntrada, Cliente dueno){
        super(matricula, modelo,fechaEntrada,horaEntrada, dueno);        
    }
    
    //Getters
    public double getPrecioHora(){
        return precioHora;
    }
    
    //Setters
    //Siempre va a ser 20
    @Override
    public double getPrecio(){
        return precioHora;
    }
}
