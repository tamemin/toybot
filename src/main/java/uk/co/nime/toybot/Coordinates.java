package uk.co.nime.toybot;

/**
 * Describes a simple coordinate that contains an x and y position
 * 
 * @author tamer
 *
 */
public class Coordinates {
	
	private int x;	
	private int y;
	
	public Coordinates(int x, int y) {	
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	/**
	 * Calculate the new coordinate location by adding a delta
	 * 
	 * @param delta
	 * @return
	 */
	public Coordinates add(Coordinates delta) {
		Coordinates sum = new Coordinates(this.x + delta.getX(), this.y + delta.getY());
		return sum;	
	}

}
