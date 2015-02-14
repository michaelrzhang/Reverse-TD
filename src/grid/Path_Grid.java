package src.grid;
public class Path_Grid extends Grid{
	public Path_Grid(double x, double y,String nm){
		super(x, y, nm);
		this.can_place = false;
	}
	public Path_Grid(Grid g){
		super(g.x_position, g.y_position, g.name);
		this.can_place = false;
	}
	public String type(){
		return "Path";
	}
}