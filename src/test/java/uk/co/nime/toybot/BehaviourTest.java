package uk.co.nime.toybot;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * Tests the expected behaviour of the toy robot simulator
 * 
 * @author tamer
 *
 */
public class BehaviourTest {
		
	private final static String INVALID_LOCATION = "Invalid Location";
	
	BotSimulator simulator;
	
	
	@Before
	public void init() {	
		simulator = new BotSimulator();			
	}
	
	/**
	 * Tests that all commands are ignored until a valid placement is received
	 * 
	 */
	@Test
	public void ignoreCommandsUntilValidPlacementTest() {
		
		simulator.move();
		assertEquals(INVALID_LOCATION, simulator.report());
		
		simulator.left();
		assertEquals(INVALID_LOCATION, simulator.report());
		
		simulator.right();
		assertEquals(INVALID_LOCATION, simulator.report());	
		
		simulator.place(50, 0, Facing.NORTH);
		assertEquals(INVALID_LOCATION, simulator.report());		
		
		simulator.place(0, 0, Facing.NORTH);
		assertEquals("0,0,NORTH", simulator.report());		
	}
	
	/**
	 * Tests that placements to invalid locations are ignored
	 * 
	 */
	@Test
	public void placementBoundaryTest() {
		
		simulator.place(0, 0, Facing.NORTH);
		assertEquals("0,0,NORTH", simulator.report());
		
		simulator.place(5, 0, Facing.NORTH);
		assertEquals("0,0,NORTH", simulator.report());
		
		simulator.place(0, 5, Facing.NORTH);
		assertEquals("0,0,NORTH", simulator.report());
		
		simulator.place(5, 5, Facing.NORTH);
		assertEquals("0,0,NORTH", simulator.report());
		
		simulator.place(-1, 0, Facing.NORTH);
		assertEquals("0,0,NORTH", simulator.report());
		
		simulator.place(0, -1, Facing.NORTH);
		assertEquals("0,0,NORTH", simulator.report());
		
		simulator.place(-1, -1, Facing.NORTH);
		assertEquals("0,0,NORTH", simulator.report());	
	}
	
	/**
	 * This models the example given in the problem
	 */
	@Test
	public void exampleInputOutputTest() {
		
		simulator.place(0, 0, Facing.NORTH);
		simulator.move();
		assertEquals("0,1,NORTH", simulator.report());
		
		simulator.place(0, 0, Facing.NORTH);
		simulator.left();
		assertEquals("0,0,WEST", simulator.report());
		
		simulator.place(1, 2, Facing.EAST);
		simulator.move();
		simulator.move();
		simulator.left();
		simulator.move();
		assertEquals("3,3,NORTH", simulator.report());			
	}
	
	/**
	 * This walks the robot clockwise around the edge of the table
	 * 
	 */
	@Test
	public void walkPeriphery() {
		
		simulator.place(0, 0, Facing.NORTH);
		
		assertEquals("0,0,NORTH", simulator.report());
		
		simulator.move();
		simulator.move();
		simulator.move();
		simulator.move();
		
		assertEquals("0,4,NORTH", simulator.report());
		
		simulator.right();
		assertEquals("0,4,EAST", simulator.report());
		
		simulator.move();
		simulator.move();
		simulator.move();
		simulator.move();
		
		assertEquals("4,4,EAST", simulator.report());
		
		simulator.right();
		
		assertEquals("4,4,SOUTH", simulator.report());
		
		simulator.move();
		simulator.move();
		simulator.move();
		simulator.move();
		
		assertEquals("4,0,SOUTH", simulator.report());
		
		simulator.right();
		
		assertEquals("4,0,WEST", simulator.report());
		
		simulator.move();
		simulator.move();
		simulator.move();
		simulator.move();
		
		assertEquals("0,0,WEST", simulator.report());
		
		simulator.right();
		
		assertEquals("0,0,NORTH", simulator.report());		
	}
	
	/**
	 * This tries to walk off the eastern edge of the table, and proves that commands that would push 
	 * the robot off the edge are ignored.
	 * 
	 */
	@Test
	public void walkOffTableEast() {
		
		simulator.place(0, 0, Facing.EAST);
		
		assertEquals("0,0,EAST", simulator.report());
		
		simulator.move();
		simulator.move();
		simulator.move();
		simulator.move();
		simulator.move();
		simulator.move();
		simulator.move();
		
		assertEquals("4,0,EAST", simulator.report());
	}
	
	/**
	 * This tries to walk off the northern edge of the table, and proves that commands that would push 
	 * the robot off the edge are ignored.
	 * 
	 */
	@Test
	public void walkOffTableNorth() {
		
		simulator.place(0, 0, Facing.NORTH);
		
		assertEquals("0,0,NORTH", simulator.report());
		
		simulator.move();
		simulator.move();
		simulator.move();
		simulator.move();
		simulator.move();
		simulator.move();
		simulator.move();
		
		assertEquals("0,4,NORTH", simulator.report());
	}
	
	/**
	 * This tries to walk off the southern edge of the table, and proves that commands that would push 
	 * the robot off the edge are ignored.
	 * 
	 */
	@Test
	public void walkOffTableSouth() {
		
		simulator.place(0, 0, Facing.SOUTH);	
		assertEquals("0,0,SOUTH", simulator.report());	
		simulator.move();
		assertEquals("0,0,SOUTH", simulator.report());
	}
	
	/**
	 * This tries to walk off the western edge of the table, and proves that commands that would push 
	 * the robot off the edge are ignored.
	 * 
	 */
	@Test
	public void walkOffTableWest() {
		
		simulator.place(0, 0, Facing.WEST);	
		assertEquals("0,0,WEST", simulator.report());	
		simulator.move();
		assertEquals("0,0,WEST", simulator.report());
	}
		
	

}
