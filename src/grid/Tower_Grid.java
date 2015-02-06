package grid;
import tower.*;
public class Tower_Grid extends Grid{
	Tower tower; // what tower is on the grid *towers should not overlap 
	public Tower_Grid(double x, double y,String nm){
		super(x, y, nm);
		this.can_place = true;
	}
}