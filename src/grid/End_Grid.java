package src.grid;
import src.map.*;
import src.creature.*;
public class End_Grid extends Direction_Grid{

	// public End_Grid(double x, double y,double xDirection, double yDirection, String nm, Map m){
	// 	super(x, y, nm, m);
	// }
	public End_Grid(Grid g){
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