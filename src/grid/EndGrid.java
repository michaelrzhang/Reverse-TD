package src.grid;
import src.map.*;
import src.actor.creature.*;
public class EndGrid extends DirectionGrid{

	// public End_Grid(double x, double y,double xDirection, double yDirection, String nm, Map m){
	// 	super(x, y, nm, m);
	// }
	public EndGrid(Grid g){
		super(g, g);
	}
	public void setCreaturesDirection(){
		for (Creature c : creatures){
			if (c != null){
				map.remove(c);
				remove_Creature(c);
			}
		}
	}
}