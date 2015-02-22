package src.grid;
import src.map.*;
import src.*;
public abstract class Grid{
	String name; // id of grid
	double x_position; // xposition of center
	double y_position; // yposition of center
	boolean can_place; // determines if towers can be built on this grid
	Map map;
	Selectable s;
	public Grid(double x, double y, String nm, Map m){
		this.x_position = x;
		this.y_position = y;
		this.name = nm;
		this.map = m;
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
	public boolean can_place(){
		return can_place;
	}
	public void set_canPlace(boolean b){
		can_place = b;
	}
}