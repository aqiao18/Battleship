
public class Destroyer {

	// Instance Variables
	String name;
	String location;
	int holes;
	boolean vertical;

	// Constructor Declaration of Class
	public Destroyer(String name, String location, int holes, boolean vertical) {
		this.name = name;
		this.location = location;
		this.holes = holes;
		this.vertical = vertical;
	}

	public String getName() {
		return name;
	}

	public String location() {
		return location;
	}

	public int getHoles() {
		return holes;
	}

	public boolean vertical() {
		return vertical;
	}

}
