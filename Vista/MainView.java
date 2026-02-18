package Vista;
import Controlador.*;
import Modelo.*;
import java.util.Scanner;

public class MainView
{
    public static void main(String[] args){
        Controlador controlador = Controlador.getSingleton();
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        
        do{
            //Menu
            mostrarMenu();
            int opcion = sc.nextInt();
            realizarOpcionMenu(opcion,sc, controlador);
            
            //Submenus
            /*mostrarSubMenu();
            opcion = sc.nextInt();
            realizarOpcionMenu(opcion,sc, controlador);*/
            if (opcion == -1) continuar = false;
        }while(continuar);
    }
    
    
    public static void mostrarMenu(){
        print("Super Taller Chiebuka\n");
        print("----------------------\n");
        print("1. Para entrar en las opciones de cliente\n");
        print("2. Para entrar en las opciones de mecanico\n");
        print("3. Para entrar en las opciones de Vehiculo\n");
        print("4. Para añadir un nuevo trabajo de taller\n");
        print("5. Listar todas las personas\n");
        print("-1. Para salir\n");
    }
    
    public static void listarPersonas(){
        imprimirDatos(Controlador.getSingleton().listarPersonas());    
    }
    
    /*public static void mostrarSubMenu(){
        print("Super Taller Chiebuka\n");
        print("----------------------\n");
        print("1. Si eres un nuevo cliente | Registrar\n");
        print("2. Si ya eres un cliente | Introduce dni\n");
        print("3.Listar clientes por primer apellido\n");
        print("4.Listar clientes ordenados\n");
        print("-1. Volver atras\n");
    }*/
    
    
    public static void realizarOpcionMenu (int opcion, Scanner sc, Controlador controlador){
        switch(opcion){
            case 1:
                mostrarMenuCliente(sc,controlador);
                break;
            case 2: 
                mostrarMenuMecanico(sc,controlador);
                break;
            case 3:
                mostrarMenuVehiculo(sc,controlador);
                break;
            case 4:
                mostrarMenuTrabajo(sc,controlador);
                break;
            case 5:
                listarPersonas();
                break;
                
        }
    }
    
    //Cambiar
    public static void mostrarMenuCliente (Scanner sc, Controlador controlador){
        print("Super Taller Chiebuka\n");
        print("----------------------\n");
        print("1. Si eres un nuevo cliente | Registrar\n");
        print("2. Si ya eres un cliente | Introduce dni\n");
        print("3.Listar clientes por primer apellido\n");
        print("4.Listar clientes\n");
        print("-2. Volver atras\n");
        
        int opcion = sc.nextInt();
        switch(opcion){
            case 1:
                registrarCliente(sc,controlador);
                break;
            case 2: 
                buscarClientePorDni(sc,controlador);
                break;
            case 3:
                String apellido = sc.nextLine();
                System.out.println(controlador.listarClientesPorApellido(apellido));
                break;
            case 4:
                listarClientes();
                break;
            case -2:
                println("Volviendo hacia atras");
                break;
                
        }
    }
    
    public static void mostrarMenuMecanico (Scanner sc, Controlador controlador){
        print("Super Taller Chiebuka\n");
        print("----------------------\n");
        print("1. Si eres un nuevo mecanico | Registrar\n");
        print("2. Si ya eres un mecanico | Introduce dni\n");
        print("3.Listar mecanicos por primer apellido\n");
        print("4.Listar mecanicos\n");
        print("-2. Volver atras\n");
        
        int opcion = sc.nextInt();
        switch(opcion){
            case 1:
                registrarMecanico(sc,controlador);
                break;
            case 2: 
                buscarMecanicoPorDni(sc,controlador);
                break;
            case 3:
                String apellido = sc.nextLine();
                System.out.println(controlador.listarMecanicosPorApellido(apellido));
                break;
            case 4:
                listarMecanicos();
                break;
            case -2:
                println("Volviendo hacia atras");
                break;
                
        }
    }
    
    public static void mostrarMenuVehiculo (Scanner sc, Controlador controlador){
        print("Super Taller Chiebuka\n");
        print("----------------------\n");
        print("1. Para registrar un nuevo vehiculo | Registrar\n");
        print("2. Buscar Vehiculo por matricula | Introduce Matricula\n");
        print("3.Listar vehiculos por tipo de vehiculo\n");
        print("4.Listar Vehiculos\n");
        print("-2. Volver atras\n");
        
        int opcion = sc.nextInt();
        switch(opcion){
            case 1:
                registrarVehiculo(sc,controlador);
                break;
            case 2: 
                buscarVehiculoMatricula(sc,controlador);
                break;
            case 3:
                listarVehiculoTipo(sc);
                break;
            case 4:
                listarVehiculos();
                break;
            case -2:
                println("Volviendo hacia atras");
                break;
                
        }
    }
    
    public static void mostrarMenuTrabajo (Scanner sc, Controlador controlador){
        print("Super Taller Chiebuka\n");
        print("----------------------\n");
        print("1. Para añadir un nuevo Trabajo | Registrar\n");
        print("2. Para ver todos los trabajos | Introduce dni\n");
        print("3.Listar trabajos no pagados\n");
        print("4.Listar todos los trabajos\n");
        print("5.Listar trabajos de un cliente\n");        
        print("-2. Volver atras\n");
        
        int opcion = sc.nextInt();
        switch(opcion){
            case 1:
                registrarTrabajo(sc,controlador);
                break;
            case 2: 
                buscarClientePorDni(sc,controlador);
                break;
            case 3:
                listarTrabajosNoPagados();
                break;
            case 4:
                listarClientes();
                break;
            case 5: 
                listarTrabajoCliente();
                break;
            case -2:
                println("Volviendo hacia atras");
                break;
                
        }
    }
    
    //Copiado del profe por si acaso
    public static void listarClientes(){
        // Hacer pedido del paquete global (el que trae todo dentro) ¿a quien? Al controlador
        //Me llega el paquete como un String
        //llamo el "desembalaje e impresion en pantalla!"
        String datosdeClientesTodos = Controlador.getSingleton().listarClientes();
        imprimirDatos(datosdeClientesTodos);
    }
    
    public static void listarMecanicos(){
        // Hacer pedido del paquete global (el que trae todo dentro) ¿a quien? Al controlador
        //Me llega el paquete como un String
        //llamo el "desembalaje e impresion en pantalla!"
        String datosdeClientesTodos = Controlador.getSingleton().listarMecanicos();
        imprimirDatos(datosdeClientesTodos);
    }
    
    
    /*
     * Le llega 
     * linea1\n
     * linea2\n
     * ....
     * lineax\n
     * 
     * Se encarga de separar x lineas en un String[] para cogerlas e imprimirlas de una en una      
       
    */
    public static void imprimirDatos(String datos){
        //Me pasan un paquete, global, con subpaquetes, apilados con \n
        //Cada paquetito se que es un String CSV dato1;dato2;dato3...
        String[] lineas = datos.split("\n");
        for(String l:lineas){
            imprimirColumnas(l);
        }
    }
    
    public static void imprimirColumnas(String linea){
        int anchoColumna=15;
        String[] columnas=linea.split(";");
        for(String col:columnas){
            //print(col+ " ");
            System.out.printf("| %-" + anchoColumna + "s ", col);
        }
        println("");
    }
    
    
    //Crud Cliente
    private static void registrarCliente (Scanner sc, Controlador controlador){
        print("Introduce tu nombre: \n");
        String csv = sc.next() + ";";
        println("Introduce primer apellido:");
        csv += sc.next() + ";";
        println("Introduce segundo apellido:");
        csv += sc.next() + ";";
        println("Introduce tu dni:");
        csv += sc.next() + ";";
        println("Introduce primer email:");
        csv += sc.next() + ";";
        println("Introduce primer tlfno:");
        csv += sc.next() + ";";
        println("Introduce primer codigo:");
        csv += sc.next();
        boolean creado = controlador.addCliente(csv);
        if(creado) println("Cliente creado");
        else println("Error cliente no creado");
    }
    
    private static void buscarClientePorDni (Scanner sc, Controlador controlador){
        println("Introduce el dni del cliente");
        String dni=sc.next();
        
        Cliente c = controlador.getClientePorDni(dni);
        String datos = c.toString();
        imprimirDatos(datos);
    }
    
    
    //Crud Mecanico
    private static void registrarMecanico (Scanner sc, Controlador controlador){
        print("Introduce tu nombre: \n");
        String csv = sc.next() + ";";
        println("Introduce primer apellido:");
        csv += sc.next() + ";";
        println("Introduce segundo apellido:");
        csv += sc.next() + ";";
        println("Introduce tu dni:");
        csv += sc.next() + ";";
        println("Introduce primer email:");
        csv += sc.next() + ";";
        println("Introduce primer tlfno:");
        csv += sc.next() + ";";
        println("Introduce primer codigo:");
        csv += sc.next();
        boolean creado = controlador.addMecanico(csv);
        if(creado) println("Mecanico creado");
        else println("Error mecanico no creado");
    }
    
    private static void buscarMecanicoPorDni (Scanner sc, Controlador controlador){
        println("Introduce el dni del cliente");
        String dni=sc.next();
        
        Mecanico m = controlador.getMecanicoPorDni(dni);
        String datos = m.toString();
        imprimirDatos(datos);
    }
    
    //Crud Vehiculo
    private static void registrarVehiculo (Scanner sc, Controlador controlador){
        print("Introduce el dni del dueño del coche: \n");
        String dniDueno = sc.next();
        print("Que tipo de vehiculo vas a añadir: \n");
        print("| 1-Moto | 2-Coche | 3-Camion | 4-Furgon |: \n");
        int tipoVehi = sc.nextInt();
        println("Introduce la matrícula del vehículo:");
        String csv = sc.next() + ";";
        println("Introduce el modelo del vehículo:");
        csv += sc.next() + ";";
        println("Introduce la fecha de entrada:");
        csv += sc.next() + ";";
        println("Introduce la hora de entrada:");
        csv += sc.next() + ";";
        
        boolean creado = controlador.addVehiculo(csv, dniDueno, tipoVehi);
        if(creado) println("Vehiculo creado");
        else println("Error vehiculo no creado");
    }
    
    private static void buscarVehiculoMatricula (Scanner sc, Controlador controlador){
        println("Introduce la matricula de tu vehiculo");
        String matricula=sc.next();
        
        Vehiculo v = controlador.getVehiculoPorMatricula(matricula);
        String datos = v.toString();
        imprimirDatos(datos);
    }
    
    public static void listarVehiculos(){
        // Hacer pedido del paquete global (el que trae todo dentro) ¿a quien? Al controlador
        //Me llega el paquete como un String
        //llamo el "desembalaje e impresion en pantalla!"
        String datosdeVehiculosTodos = Controlador.getSingleton().listarVehiculos();
        imprimirDatos(datosdeVehiculosTodos);
    }
    
    public static void listarVehiculoTipo(Scanner sc){
        println("Introduce número del 1 al 4 según el tipo de vehiculo que quieres:");
        println("| 1-Moto | 2-Coche | 3-Camion | 4-Furgon |");
        int tipo = sc.nextInt();
        
        imprimirDatos(Controlador.getSingleton().listarVehiculoTipo(tipo));
        
    }
    
    //Crud trabajos Taller
    private static void registrarTrabajo (Scanner sc, Controlador controlador){
        print("Introduce el dni del mecanico: \n");
        String dniMecanico= sc.next();
        print("Introduce la matricula del Vehiculo: \n");
        String matriculaVehi = sc.next() ;
        println("Introduce la descripcion del trabajo a realizar:");
        String description = sc.next();
        println("Introduce las horas prevista:");
        double horasPrevistas = sc.nextDouble();
        println("Introduce la fecha de entrada:");
        String fechaEntrada = sc.next();
        println("Introduce la hora de entrada:");
        String horaEntrada = sc.next();
        
        boolean creado = controlador.addTrabajo(dniMecanico, matriculaVehi,description,horasPrevistas,fechaEntrada,horaEntrada);
        if(creado) println("Trabajo creado");
        else println("Error trabajo no creado");
    }
    
    public static void listarTrabajosNoPagados (){
        imprimirDatos(Controlador.getSingleton().listarTrabajosNoPagados());
    }
    
    public static void listarTrabajoCliente(){
        
    }
    
    
    public static void print(String texto){
        System.out.print(texto);
    }
    
    public static int getOpcionMenu(){
        return leerEntero("Opcion:");
    }
    
    public static int leerEntero (String info){
        print(info);
        return (new Scanner(System.in)).nextInt();
    }
    
    public static void println(String texto){
        System.out.println(texto);
    }
}
