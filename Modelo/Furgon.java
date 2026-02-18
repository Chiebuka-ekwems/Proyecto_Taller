package Modelo;


public class Furgon extends Vehiculo
{
    private static final double precioHora=30;
    private static final double plusDificil=30;
    
    public Furgon(String matricula, String modelo, String fechaEntrada, String horaEntrada, Cliente dueno){
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
    //Siempre va a ser 30
    @Override
    public double getPrecio(){
        return precioHora+plusDificil;
    }
}
