package src.grid;
import src.map.*;
public class PathGrid extends Grid{
	public PathGrid(double x, double y,String nm, Map m){
		super(x, y, nm, m);
		this.can_place = false;
	}
	public PathGrid(Grid g){
		super(g.x_position, g.y_position, g.name, g.map);
		this.can_place = false;
	}
	public String type(){
		return "Path";
	}
}