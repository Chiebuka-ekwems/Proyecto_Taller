
package Modelo;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PersonaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PersonaTest
{
    /**
     * Default constructor for test class PersonaTest
     */
    public PersonaTest()
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
       Test de los getters
       */
    @Test
    public void testGetters(){
        //Add
        Persona p = new Persona("nombre","apellido1","apellido2","dni","email","telefono");
        
        //Act
        String nombre = p.getNombre();
        String apellido1 = p.getApellido1();
        String apellido2 = p.getApellido2();
        String dni = p.getDni();
        String email= p.getEmail();
        String telefono=p.getTelefono();
        
        
        //Assert
        assertTrue(nombre.equals("nombre"));
        assertTrue(apellido1.equals("apellido1"));
        assertTrue(apellido2.equals("apellido2"));
        assertTrue(dni.equals("dni"));
        assertTrue(email.equals("email"));
        assertTrue(telefono.equals("telefono"));
    }
    
    /**
     * Test de los setters
     */
    @Test
    public void testSetters(){
        //Add
        Persona p = new Persona("nombre","apellido1","apellido2","dni","email","telefono");
        
        //Act
        p.setNombre("otronombre");
        p.setApellido1("otroapellido1");
        p.setDni("otroDni");
        
        String nombre = p.getNombre();
        String apellido1 = p.getApellido1();
        String dni = p.getDni();
        
        
        //Assert
        assertTrue(nombre.equals("otronombre"));
        assertTrue(apellido1.equals("otroapellido1"));
        assertTrue(dni.equals("otroDni"));
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