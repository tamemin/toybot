package uk.co.nime.toybot;

/**
 * Defines the operations that can be sent to the toy robot simulator
 * 
 * @author tamer
 *
 */
public interface BotOperations {
	
	/**
	 * Place the robot at x,y facing direction
	 * @param x
	 * @param y
	 * @param facing
	 */
	public void place(int x, int y, Facing facing);
	
	/**
	 * move forward one space
	 */
	public void move();
	
	/**
	 * turn left 90 degrees
	 */
	public void left();
	
	/**
	 * turn right 90 degrees
	 */
	public void right();
	
	/**
	 * 
	 * @return A report of the robot location
	 */
	public String report();

}
