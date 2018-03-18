package uk.co.nime.toybot;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the navigator services
 * 
 * @author tamer
 *
 */
public class NavigatorTest {
	
	@Test
	public void leftTurnTest() {
		Navigator navigator = new Navigator();	
		assertEquals(Facing.WEST,navigator.getLeftTurnDirection(Facing.NORTH));
		assertEquals(Facing.NORTH,navigator.getLeftTurnDirection(Facing.EAST));
		assertEquals(Facing.EAST,navigator.getLeftTurnDirection(Facing.SOUTH));
		assertEquals(Facing.SOUTH,navigator.getLeftTurnDirection(Facing.WEST));	
	}
	
	@Test
	public void rightTurnTest() {
		Navigator navigator = new Navigator();	
		assertEquals(Facing.EAST,navigator.getRightTurnDirection(Facing.NORTH));
		assertEquals(Facing.SOUTH,navigator.getRightTurnDirection(Facing.EAST));
		assertEquals(Facing.WEST,navigator.getRightTurnDirection(Facing.SOUTH));
		assertEquals(Facing.NORTH,navigator.getRightTurnDirection(Facing.WEST));	
	}
	@Test
	public void navigationDeltaTest() {
		Navigator navigator = new Navigator();
		Coordinates current = navigator.getDeltaForDirection(Facing.NORTH);
		current = current.add(navigator.getDeltaForDirection(Facing.EAST));
		current = current.add(navigator.getDeltaForDirection(Facing.SOUTH));
		current = current.add(navigator.getDeltaForDirection(Facing.WEST));
		assertEquals(0, current.getX());
		assertEquals(0, current.getY());
		
	}

}
