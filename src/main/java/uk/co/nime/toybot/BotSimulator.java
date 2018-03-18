package uk.co.nime.toybot;

/**
 * Implements the toy robot simulation
 * 
 * @author tamer
 *
 */
public class BotSimulator implements BotOperations {
	
	private final static int MAX_X = 4;
	private final static int MAX_Y = 4;
	private final static int MIN_X = 0;
	private final static int MIN_Y = 0;
	
	private final static String INVALID_LOCATION = "Invalid Location";

	/** State storage for the toy robot */
	private BotState botState;
	
	/** Navigation bean for the toy robot */
	private Navigator navigator;
	
	/**
	 * Setup the simulator
	 */
	public BotSimulator() {
		navigator = new Navigator();
		botState = new BotState();
		botState.setValidLocation(false);
	}
	
	@Override
	public void place(int x, int y, Facing facing) {
		Coordinates newLocation = new Coordinates(x, y);
		
		if (boundsOk(newLocation)) {
			botState.setLocation(newLocation);
			botState.setFacing(facing);
			botState.setValidLocation(true);
		}	
	}

	@Override
	public void move() {

		if (botState.isValidLocation()) {		
			Coordinates delta = navigator.getDeltaForDirection(botState.getFacing());
			Coordinates newLocation = botState.getLocation().add(delta);
			if (boundsOk(newLocation)) {
				botState.setLocation(newLocation);
			}			
		}
	}

	@Override
	public void left() {
		
		if (botState.isValidLocation()) {
			botState.setFacing(navigator.getLeftTurnDirection(botState.getFacing()));
		}	
	}

	@Override
	public void right() {
		if (botState.isValidLocation()) {
			botState.setFacing(navigator.getRightTurnDirection(botState.getFacing()));
		}		
	}

	@Override
	public String report() {
		String report = INVALID_LOCATION;
		if (botState.isValidLocation()) {
			report = String.format("%d,%d,%s", botState.getLocation().getX(), botState.getLocation().getY(), botState.getFacing().toString());
		}
		return report;
	}
	
	/**
	 * Return true if the location is within the play area boundary
	 * @param location
	 * @return
	 */
	private boolean boundsOk(Coordinates location) {
		
		return  !((location.getX()<MIN_X) || (location.getX()>MAX_X) || (location.getY()<MIN_Y) || (location.getY()>MAX_Y)) ;
	
	}

}
