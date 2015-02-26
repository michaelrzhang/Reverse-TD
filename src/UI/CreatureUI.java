package src.UI;
import src.actor.creature.*;
import src.shape.*;
import src.map.*;
import lib.*;
import src.grid.*;
import java.awt.Graphics2D;
import java.awt.Color;
public class CreatureUI extends UI{
	Creature[] CreatureInfo = new Creature[2];
	int index = 0;
	UIGrid[][] uigrid;
	public CreatureUI(int x_position, int y_position, 
		int xlength, int ylength){
		super(x_position, y_position, xlength, ylength, "Creatures");
		CreatureInfo[0] = new BasicCreature("Basic Creature");
		CreatureInfo[1] = new FastCreature("Fast Creature");
		for (Creature c : CreatureInfo){
			c.hit_box.set_X(x_position + xlength/3);
			c.hit_box.set_Y(y_position + 2*ylength/3);
		}
	} 
	public void draw(Graphics2D g2d){
		Creature c = CreatureInfo[index];
		c.hit_box.draw(g2d);
		g2d.setColor(Color.WHITE);
		g2d.drawString("Creature: " + c.name, x_position + xlength/4, y_position + ylength);
		g2d.drawString("Health: " + String.valueOf(c.health), x_position + xlength/4, y_position + 3*ylength/4);
		g2d.drawString("Cost: " + String.valueOf(c.cost), x_position + xlength/4, y_position + ylength/2);
		g2d.drawString("Velocity: " + String.valueOf(c.get_velocity()), x_position + xlength/4, y_position + ylength/4); 
	}
	public void change(int n){
		if (index + n >= 0 && index + n < CreatureInfo.length){
			index += n;
		}
		System.out.println(index);
	}
	public Creature get_Creature(){
		return CreatureInfo[index];
	}

}