package src.UI;
import src.actor.creature.*;
import src.shape.*;
import src.map.*;
import lib.*;
public class CreatureDisplay extends UI{
	Creature[] CreatureInfo = new Creature[1];
	CreatureInfo[0] = new BasicCreature("Basic Creature");
	int index = 0;
	UIGrid[][] uigrid;
	public CreatureUI(Map map, double x_position, double y_position, 
		double xlength, double ylength){
		super(map, x_position, y_position, xlength, ylength, "Creatures");
	} 
	public void display(){
		Creature c = CreatureInfo[index];
		c.getShape.draw();
		StdDraw.textLeft(,,c.name);
		StdDraw.textLeft(,,String.valueOf(c.health));
		StdDraw.textLeft(,,String.valueof(c.cost));

	}
	public void change(int n){
		if (index + n >= 0 && index + n < CreatureInfo.length){
			index += n;
		}
	}

}