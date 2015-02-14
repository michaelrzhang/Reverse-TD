package src.grid;
public abstract class Grid{
	String name; // id of grid
	double x_position; // xposition of center
	double y_position; // yposition of center
	boolean can_place; // determines if towers can be built on this grid
	Grid[] adjacent = new Grid[4]; // keeps track of what grids surround this grid  
	// Projectile[] projectiles;
	public Grid(double x, double y,String nm){
		this.x_position = x;
		this.y_position = y;
		this.name = nm;
		// this.adjacent[0] = upper;
		// this.adjacent[1] = right;
		// this.adjacent[2] = lower;
		// this.adjacent[3] = right;
	}
	public abstract String type();
	public void setStart(){}
	public void setEnd(){}
	public double get_x_position(){
		return x_position;
	}
	public double get_y_position(){
		return y_position;
	}
}