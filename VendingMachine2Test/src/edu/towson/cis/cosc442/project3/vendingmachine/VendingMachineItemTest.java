package edu.towson.cis.cosc442.project3.vendingmachine;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>VendingMachineItemTest</code> contains tests for the class <code>{@link VendingMachineItem}</code>.
 *
 * @generatedBy CodePro at 3/2/17 3:22 PM
 * @author tedsmithiii
 * @version $Revision: 1.0 $
 */
public class VendingMachineItemTest {
	/**
	 * Run the VendingMachineItem(String,double) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/2/17 3:22 PM
	 */
	@Test
	public void testVendingMachineItem_1()
		throws Exception {
		String name = "";
		double price = 1.0;

		VendingMachineItem result = new VendingMachineItem(name, price);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getName());
		assertEquals(1.0, result.getPrice(), 1.0);
	}

	/**
	 * Run the VendingMachineItem(String,double) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/2/17 3:22 PM
	 */
	@Test(expected = edu.towson.cis.cosc442.project3.vendingmachine.VendingMachineException.class)
	public void testVendingMachineItem_2()
		throws Exception {
		String name = "";
		double price = -4.9E-324;

		VendingMachineItem result = new VendingMachineItem(name, price);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String getName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/2/17 3:22 PM
	 */
	@Test
	public void testGetName_1()
		throws Exception {
		VendingMachineItem fixture = new VendingMachineItem("", 1.0);

		String result = fixture.getName();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the double getPrice() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/2/17 3:22 PM
	 */
	@Test
	public void testGetPrice_1()
		throws Exception {
		VendingMachineItem fixture = new VendingMachineItem("", 1.0);

		double result = fixture.getPrice();

		// add additional test code here
		assertEquals(1.0, result, 0.1);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 3/2/17 3:22 PM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 3/2/17 3:22 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 3/2/17 3:22 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(VendingMachineItemTest.class);
	}
}