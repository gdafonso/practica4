package Test;


import org.junit.*;
import Ficheros.practica;
import Ficheros.Propiedades;
import static org.junit.Assert.*;
import java.sql.Date;

public class TestJUnit {
	
	/*
	 *  Atributos de la clase Propiedades
	 *  y Objeto de la clase Propiedades
	 *  sobre el cual vamos a realizar
	 *  las pruebas
	 */    
    private static int id;
    private static String name;
    private static int length;
    private static String canRead;
    private static String canWrite;
    private static Date lastModified;
    private static Propiedades propiedades;
    private static String[] testArrayPropiedades;
    
	public void TestJUnit() {
		testBefore();
	}
	
	//  Run once before any of the test methods in the class
	@BeforeClass
	public static void testBeforeClass() {

		// Creamos una propiedades para los tests
		id = 1;
		name = "archivo1.txt";
		length = 128;
		canRead = "True";
		canWrite = "False";
		lastModified = new Date(119,10,2);
		propiedades = new Propiedades(id,name,length,canRead,canWrite,lastModified);
		System.out.println("@BeforeClass: Se han creado las siguientes propiedades para el tests:");
		System.out.println("ID: " + propiedades.getId());
		System.out.println("NOMBRE: " + propiedades.getName());
		System.out.println("TAMANO: " + propiedades.getLength());
		System.out.println("LECTURA: " + propiedades.getCanRead());
		System.out.println("ESCRITURA: " + propiedades.getCanWrite());
		System.out.println("FECHA ULTIMA MODIFICACION: " + propiedades.getLastModified());
	}
	
	// Run before the Test methods
	@Before
	public void testBefore() {
		
		// Antes de iniciar los tests
		// vaciamos el array de propiedades
		testArrayPropiedades = null;
		System.out.println("-------------------------------------------");
		System.out.println("@Before: Se ha vaciado el array de propiedades.");
		
	}

	
	// Check that two primitives / Objects are equal void
	@Test 
	public void testAssertEquals() { 
		System.out.println("Ejecutando test AssertEquals.");
		// Propiedades de test 
		Propiedades propiedades2 = new Propiedades(2,"archivo2.txt",256,"False","True",new Date(119,10,2));
		// Llamada al assert de tipo
		assertEquals(propiedades2, propiedades); 
	}
	 
	// Check that a condition is true
	@Test
	public void testAssertTrue() {
		System.out.println("Ejecutando test AssertTrue.");
		// id de test
		int testId = 2;
		// Llamada al assert de tipo True
		assertTrue(testId == propiedades.getId());
	}
	
	// Check that a condition is false
	@Test
	public void testAssertFalse() {
		System.out.println("Ejecutando test AssertFalse.");
		// id de test
		int testId = 2;
		// Llamada al assert de tipo False
		assertFalse(id == propiedades.getId());
	}
	
	// Check than an object isn't null
	@Test
	public void testAssertNotNull() {
		System.out.println("Ejecutando test AssertNotNull.");
		// Propiedades de test 
		Propiedades propiedades2 = null;
		// Llamada al assert de tipo NotNull
		assertNotNull(propiedades2); 
	}
	
	// Check than an object is null
	@Ignore
	@Test
	public void testAssertNull() {
		System.out.println("Ejecutando test AssertNulls.");
		// Propiedades de test 
		Propiedades propiedades2 = null;
		// Llamada al assert de tipo Null
		assertNull(propiedades2); 
	}
	
	// Check if two object references point to the same object
	@Test
	public void testAssertSame() {
		System.out.println("Ejecutando test AssertSame.");
		// Propiedades de test 
		Propiedades propiedades2 = propiedades;
		// Llamada al assert de tipo Same
		assertSame(propiedades2,propiedades);
	}
	
	// Check if two object references not point to the same object
	@Ignore
	@Test
	public void testAssertNotSame() {
		System.out.println("Ejecutando test AssertNotSame.");
		// Propiedades de test 
		Propiedades propiedades2 = new Propiedades();
		propiedades2.setName("archivo2.txt");
		propiedades2.setLength(256);
		// Llamada al assert de tipo NotSame
		assertNotSame(propiedades2,propiedades);
	}

	// Check wether two arrays are equal to each other
	@Ignore
	@Test
	public void testAssertArrayEquals() {
		System.out.println("Ejecutando test AssertArrayEquals.");
		// Array de test
		Propiedades testPropiedades = new Propiedades(1, "archivo2.txt", 128, "True", "False", new Date(119,10,1));
		testArrayPropiedades = new String[]{testPropiedades.toString()};
		
		// Array de Propiedades
		String[] arrayPropiedades = {propiedades.toString()};
		
		// Llamada al assert de tipo ArrayEquals
		assertArrayEquals(testArrayPropiedades,arrayPropiedades);
	}
	
	// Run after the Test methods
	@After
	public void testAfter() {
		
		// Tras ejecutar los tests eliminamos las
		// propiedades usadas
		this.id=0;
		this.name = null;
		this.length = 0;
		this.canRead = null;
		this.canWrite = null;
		this.lastModified = null;
		propiedades = null;
		System.out.println("@After: Se han eliminadon las propiedades usadas en el test.");
		
	}
	
	// Run after all the tests in the class have been run
	@AfterClass
	public static void testAfterClass() {
		// Muestra mensaje indicando que se han
		// terminado todos los tests
		System.out.println("@AfterClass: Se han terminado todos los test.");
	}
}
