package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
	VendingMachine vm;
	VendingMachineItem vmIA;
	VendingMachineItem vmIB;
	VendingMachineItem vmIC;
	VendingMachineItem vmID;
	@Before
	public void setUp() throws Exception {
		vm = new VendingMachine();
		vmIA = new VendingMachineItem("Skittles",1.75);
		vmIB = new VendingMachineItem("Donuts",2.50);
		vmIC = new VendingMachineItem("Gum", 1.25);
		vmID = new VendingMachineItem("Apple",.75);
	}

	@After
	public void tearDown() throws Exception {
		vm = null;
		vmIA = null;
		vmIB = null;
		vmIC = null;
		vmID = null;
	}

	@Test
	public void testAddItem() {
		
		//Precondition to make sure the item array is empty
	
		assertNull(vm.getItem("A"));
		assertNull(vm.getItem("B"));
		assertNull(vm.getItem("C"));
		assertNull(vm.getItem("D"));
		
		//Added each item to ensure that there is no issue associated with the specific item codes to the vending machine
		vm.addItem(vmIA, "A");
		assertEquals(vm.getItem("A").getName(),"Skittles");
		vm.addItem(vmIB, "B");
		assertEquals(vm.getItem("B").getName(),"Donuts");
		vm.addItem(vmIC, "C");
		assertEquals(vm.getItem("C").getName(),"Gum");
		vm.addItem(vmID, "D");
		assertEquals(vm.getItem("D").getName(),"Apple");
		
		
		
		//Tests below will cause exception errors.
		//Add an item to a code that is already occupied , makes the exceptiom go off
		//vm.addItem(vmID, "A");
		
		//Add an item to code that does not exist,
		//vm.addItem(vmIA, "G");
	}
	@Test
	public void testAddOccItem(){
		//Testing the exception by adding an item to a spot that is already occupied
		vm.addItem(vmID, "D");
		vm.addItem(vmID, "D");
		
	}
	@Test
	public void testAddBadCodeItem(){
		//Testing the exception by trying to add an item to a code that doesn't exist
		vm.addItem(vmID, "E");
		
		
	}

	@Test
	public void testRemoveItem() {
		
		//This adds each item to the list
		//Removes the item and checks that the returned item is the actual item at the code
		//Tries to access the item to see if the remove item completed its job
		vm.addItem(vmIA, "A");
		assertEquals(vm.removeItem("A").getName(),vmIA.getName()); //Testing that the returned value is the item deleted
		
		assertNull(vm.getItem("A"));
		vm.addItem(vmIB, "B");
		assertEquals(vm.removeItem("B").getName(),vmIB.getName()); //Testing that the returned value is the item deleted
		assertNull(vm.getItem("B"));
		
		vm.addItem(vmIC, "C");
		assertEquals(vm.removeItem("C").getName(),vmIC.getName()); //Testing that the returned value is the item deleted
		assertNull(vm.getItem("C"));
		
		vm.addItem(vmID, "D");
		assertEquals(vm.removeItem("D").getName(),vmID.getName()); //Testing that the returned value is the item deleted
		assertNull(vm.getItem("D"));
		
		//Tests below will cause exception errors.
		
		//Try to remove an item that already does not exist
		//vm.removeItem("D");
		
		
		//Try to access a code that does not exist
		//vm.removeItem("G");
		
	}
	@Test
	public void testRemoveEmptyItem(){
		//Will run to test the exception for trying to remove an empty item
		vm.removeItem("D");
		
		
	}

	@Test
	public void testInsertMoney() {
		//Precondition
		assertEquals(vm.getBalance(),0.00,.001);
		
		//Testing the insertion of money. 
		//Insert $10, and if I check the balance it should say 10
		vm.insertMoney(10.00);
		assertEquals(vm.getBalance(),10.00,.001);
		
		
		//Tests below will cause exception errors.
		
		//try to insert negative money
		//vm.insertMoney(-10.00);
	}
	@Test
	public void testInsertNegativeMoney(){
		//Will run to test the exception for trying to insert a negative amount of moeny
		vm.insertMoney(-10.00);
		
		
	}
	@Test
	public void testGetBalance() {
		//Precondition
				assertEquals(vm.getBalance(),0.00,.001);
				
				//Testing the insertion of money. 
				//Insert $10, and if I check the balance it should say 10, then 20, and 30
				vm.insertMoney(10.00);
				assertEquals(vm.getBalance(),10.00,.001);
				
				vm.insertMoney(10.00);
				assertEquals(vm.getBalance(),20.00,.001);
				vm.insertMoney(10.00);
				assertEquals(vm.getBalance(),30.00,.001);
	}

	@Test
	public void testMakePurchase() {
		vm.addItem(vmIA, "A");
		vm.addItem(vmIC, "C");
		
		//Try to buy something with no money
		assertEquals(vm.makePurchase("A"),false);
		assertEquals(vm.makePurchase("B"),false);
		assertEquals(vm.makePurchase("C"),false);
		assertEquals(vm.makePurchase("D"),false);
		//Add money and try to buy an item that exists, doesn't exist, exist
		vm.insertMoney(3.25);
		assertEquals(vm.makePurchase("A"),true);
		assertEquals(vm.makePurchase("B"),false);
		assertEquals(vm.makePurchase("C"),true);
		
		//With leftover change try to make a purchase
		assertEquals(vm.makePurchase("A"),false);
		assertEquals(vm.makePurchase("B"),false);
		assertEquals(vm.makePurchase("C"),false);
		assertEquals(vm.makePurchase("D"),false);
		
		
		//Tests below will cause exception errors.
		
		//Tests what will happen if you try using a code that doesn't exist
		//assertEquals(vm.makePurchase("G"),false);
	}

	@Test
	public void testReturnChange() {
		//Test it before money is inserted
		assertEquals(vm.returnChange(),0.00,.001);
		//Test after money is inserted
		vm.insertMoney(3.25);
		assertEquals(vm.returnChange(),3.25,.001);
		assertEquals(vm.getBalance(),0.00,.001);
		//Test after money is inserted and an blank item is attempted to be purchased
		vm.insertMoney(3.25);
		vm.makePurchase("A");
		assertEquals(vm.returnChange(),3.25,.001);
		assertEquals(vm.getBalance(),0.00,.001);
		//Test after money is inserted and an item is purchased
		vm.insertMoney(3.25);
		vm.addItem(vmIA, "A");
		vm.makePurchase("A");
		assertEquals(vm.returnChange(),1.50,.001);
		assertEquals(vm.getBalance(),0.00,.001);
		//Test after money is inserted and two items are purchased
		vm.insertMoney(3.25);
		vm.addItem(vmIA, "A");
		vm.makePurchase("A");
		vm.addItem(vmIC, "C");
		vm.makePurchase("C");
		assertEquals(vm.returnChange(),0.25,.001);
		assertEquals(vm.getBalance(),0.00,.001);
	}

}
