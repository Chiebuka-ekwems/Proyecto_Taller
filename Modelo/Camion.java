package Modelo;


public class Camion extends Vehiculo
{
    private static final double precioHora=40;
    private static final double plusDificil=50;
    
    public Camion(String matricula, String modelo, String fechaEntrada, String horaEntrada, Cliente dueno){
        super(matricula, modelo,fechaEntrada,horaEntrada, dueno);        
    }
    
    //Getters
    public double getPrecioHora(){
        return precioHora;
    }
    
    public double getPlusDificil(){
        return plusDificil;
    }
    
    //Setters
    //Siempre va a ser 40
    @Override
    public double getPrecio(){
        return precioHora+plusDificil;
    }
}
