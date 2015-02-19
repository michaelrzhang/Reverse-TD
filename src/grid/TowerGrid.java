package src.grid;
import src.actor.tower.*;
import src.map.*;
public class TowerGrid extends Grid{
	Tower tower; // what tower is on the grid *towers should not overlap 
	public TowerGrid(double x, double y,String nm, Map m){
		super(x, y, nm, m);
		this.can_place = true;
	}
	public String type(){
		return "Tower";
	}
}