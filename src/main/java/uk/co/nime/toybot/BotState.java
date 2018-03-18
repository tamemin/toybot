package uk.co.nime.toybot;

/**
 * Stores the state of the toy robot
 * 
 * @author tamer
 *
 */
public class BotState {
	
	/** The direction the robot is facing */
	private Facing facing;	
	
	/** The current location of the robot */
	private Coordinates location;	
	
	/** The flag indicating whether the robot is in a valid location */
	private boolean validLocation;
	
	public BotState() {
		validLocation = false;
	}
	
	public Facing getFacing() {
		return facing;
	}
	

	public void setFacing(Facing facing) {
		this.facing = facing;
	}
	
	public void setLocation(Coordinates location) {
		this.location = location;
	}
	
	public Coordinates getLocation() {
		return location;
	}
	
	public boolean isValidLocation() {
		return validLocation;
	}
	
	public void setValidLocation(boolean validLocation) {
		this.validLocation = validLocation;
	}
	

}
