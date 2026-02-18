package Modelo;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ClienteTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ClienteTest
{
    /**
     * Default constructor for test class ClienteTest
     */
    public ClienteTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }
    
    
    /**
     * Test toString
       */
    @Test
    public void testToString(){
        
        //Añadir Add
        //declarar objetos a probar e inicializarlos
        Cliente muLoco = new Cliente("loco","chalao","pasaoRosca","1A","diablo@email.it","666",666);
        
        //Actuar Act
        String resultado = muLoco.toString();
        
        
        //Asegurar Assert
        assertTrue(resultado.equals("loco;chalao;pasaoRosca;1A;diablo@email.it;666;666;"));
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}