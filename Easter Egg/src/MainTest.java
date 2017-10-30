import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MainTest {
	
	private Main main;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		main = new Main();
	}

	@Test
	public void testKaran() {
		String name = main.karan();
		assertEquals(name, "Karan Singla");
		assertEquals(1 , main.getCount());
	}
	
	@Test
	public void testPeter() {
		String name = main.peter();
		assertEquals(name, "Peter Bae");
		assertEquals(1 , main.getCount());
	}
	
	@Test
	public void testLogan() {
		String name = main.logan();
		assertEquals(name, "Logan Stafford");
		assertEquals(1 , main.getCount());
	}
	
	@Test
	public void testCarter() {
		String name = main.peter();
		assertEquals(name, "Peter Bae");
		assertEquals(1 , main.getCount());
	}
	
	@Test
	public void testAlex() {
		String name = main.alex();
		assertEquals(name, "Alex Merk");
		assertEquals(1, main.getCount());
	}
	
	@Test
	public void testCount() {
		assertEquals(0,main.getCount());
	}
}
