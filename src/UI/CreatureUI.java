package src.UI;
import src.actor.creature.*;
import src.shape.*;
import src.map.*;
import lib.*;
public class CreatureDisplay extends UI{
	Creature[] CreatureInfo = new Creature[1];
	int index = 0;
	UIGrid[][] uigrid;
	public CreatureUI(Map map, double x_position, double y_position, 
		double xlength, double ylength){
		this.uigrid = uigrid;
		this.x_position = x_position;
		this.y_position = y_position;
		this.xlength = xlength;
		this.ylength = ylength;
	} 
	public CreatureDisplay(double x_position, double y_position){
		super(x_position, y_position);
		CreatureInfo[0] = new BasicCreature("Basic Creature");
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