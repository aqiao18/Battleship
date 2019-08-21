
public class Carrier {
	// Instance Variables
	String location;
	boolean vertical;
	int holes = 5;
	// Constructor Declaration of Class
	public Carrier (String location, boolean vertical) {
		this.location = location;
		this.vertical = vertical;
	}
	
	
	public String location() {
		return location;
	}
	
	public boolean vertical() {
		return vertical;
	}
	
//	public void updateSink() {
//		holes --;
//		if (holes == 0) System.out.println("Opponent's Carrier has been destroyed Commander!");
//	}
}
