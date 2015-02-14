package src.grid;
import src.map.*;
public class Path_Grid extends Grid{
	public Path_Grid(double x, double y,String nm, Map m){
		super(x, y, nm, m);
		this.can_place = false;
	}
	public Path_Grid(Grid g){
		super(g.x_position, g.y_position, g.name, g.map);
		this.can_place = false;
	}
	public String type(){
		return "Path";
	}
}