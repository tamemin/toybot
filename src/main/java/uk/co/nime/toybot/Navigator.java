package uk.co.nime.toybot;

/**
 * Provides services to the toy robot simulator
 * 
 * @author tamer
 *
 */
public class Navigator {
	
	/**
	 * Gets the coordinate delta for the given direction
	 * 
	 * @param direction
	 * @return
	 */
	public Coordinates getDeltaForDirection(Facing direction) {
		
		Coordinates delta = null;
		
		switch (direction) {
		case NORTH : 
			delta = new Coordinates(0, 1);
			break;
		case EAST: 
			delta = new Coordinates(1, 0);
			break;
		case SOUTH: 
			delta = new Coordinates(0, -1);
			break;
		case WEST: 
			delta = new Coordinates(-1,0);
			break;
		default:
			delta = new Coordinates(0,0);
		}
		
		return delta;
	}
	
	/**
	 * Gets the new direction after turning left
	 * 
	 * @param currentDirection
	 * @return
	 */
	public Facing getLeftTurnDirection(Facing currentDirection) {
		
		Facing newDirection = null;
		
		switch (currentDirection) {
		case NORTH :
			newDirection = Facing.WEST;
			break;
		case EAST :
			newDirection = Facing.NORTH;
			break;
		case SOUTH :
			newDirection = Facing.EAST;
			break;
		case WEST :
			newDirection = Facing.SOUTH;
		}
		
		return newDirection;
		
	}
	
	/**
	 * Gets the new direction after turning right
	 * 
	 * @param currentDirection
	 * @return
	 */
	public Facing getRightTurnDirection(Facing currentDirection) {
		
		Facing newDirection = null;
		
		switch (currentDirection) {
		case NORTH :
			newDirection = Facing.EAST;
			break;
		case EAST :
			newDirection = Facing.SOUTH;
			break;
		case SOUTH :
			newDirection = Facing.WEST;
			break;
		case WEST :
			newDirection = Facing.NORTH;
		}
		
		return newDirection;
		
	}

}
