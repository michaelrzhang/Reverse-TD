package src.UI;
import src.actor.creature.*;
import src.shape.*;
import src.map.*;
import lib.*;
import src.grid.*;
public class CreatureUI extends UI{
	Creature[] CreatureInfo = new Creature[1];
	int index = 0;
	UIGrid[][] uigrid;
	public CreatureUI(double x_position, double y_position, 
		double xlength, double ylength){
		super(x_position, y_position, xlength, ylength, "Creatures");
		CreatureInfo[0] = new BasicCreature("Basic Creature");
		for (Creature c : CreatureInfo){
			c.hit_box.set_X(x_position + xlength/3);
			c.hit_box.set_Y(y_position + ylength*(2.0/3));
		}
	} 
	public void draw(){
		Creature c = CreatureInfo[index];
		c.hit_box.draw();
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(x_position + xlength/4, y_position + ylength,"Creature: " + c.name);
		StdDraw.text(x_position + xlength/4, y_position + ylength*(3.0/4),"Health: " + String.valueOf(c.health));
		StdDraw.text(x_position + xlength/4, y_position + ylength*(1.0/2),"Cost: " + String.valueOf(c.cost));
		StdDraw.text(x_position + xlength/4, y_position + ylength*(1.0/4),"Velocity: " + String.valueOf(c.get_velocity())); 
	}
	public void change(int n){
		if (index + n >= 0 && index + n < CreatureInfo.length){
			index += n;
		}
	}

}